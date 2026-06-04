package it.tommaso.uniroma2.progettoISPW.control;


import it.tommaso.uniroma2.progettoISPW.bean.*;
import it.tommaso.uniroma2.progettoISPW.dao.BibliotecaDAO;
import it.tommaso.uniroma2.progettoISPW.dao.IRicercabiliDAO;
import it.tommaso.uniroma2.progettoISPW.dao.LettoreDAO;
import it.tommaso.uniroma2.progettoISPW.dao.factory.DAOFactory;
import it.tommaso.uniroma2.progettoISPW.exception.DAOException;
import it.tommaso.uniroma2.progettoISPW.exception.RicercaException;
import it.tommaso.uniroma2.progettoISPW.model.*;
import it.tommaso.uniroma2.progettoISPW.supporto.Sessione;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
Controller applicativo del caso d'uso prenota libro.
 */
public class PrenotaLibroController {

    public List<BibliotecaBean> caricaBibliotecheRegistrate(FiltroBibliotecaBean filtroBean) throws RuntimeException {

        //lista di bean biblioteche da inviare allo strato view.
        List<BibliotecaBean> listaBeanBiblioteche = new ArrayList<>();
        //lista di biblioteche così come viene generata dal DAO.
        List<Biblioteca> listaBibliotecheOttenute = new ArrayList<>();
        //filtro che viene valutato ed eventualmente usato per ottenere una lista di biblioteche filtrata
        //secondo i criteri scelti.
        FiltroBiblioteca filtro = new FiltroBiblioteca(filtroBean);
        BibliotecaDAO bdao = DAOFactory.ottieniDAOFactory().creaBibliotecaDAO();
        try {

            listaBibliotecheOttenute.addAll(bdao.ottieniListaFiltrata(filtro));
            for (Biblioteca b : listaBibliotecheOttenute) {
                listaBeanBiblioteche.add(new BibliotecaBean(b));
            }


        } catch (DAOException | RicercaException e){
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        return listaBeanBiblioteche;
    }

    //ATTENZIONE,  operazione non ancora implementata!
    public void eliminaPrenotazione(PrenotazioneBean prenotazioneBean){

        try {
            DAOFactory.ottieniDAOFactory().creaPrenotazioneDAO().elimina(prenotazioneBean.getId());
        } catch (DAOException e) {
            throw new RuntimeException("Impossibile eliminare la prenotazione!",e);
        }
    }
    public PrenotazioneBean bozzaPrenotazione(BibliotecaBean bibliotecaSelezionata) {

        RecuperoBibliotecaThread t1 = new RecuperoBibliotecaThread(bibliotecaSelezionata);
        RecuperoLettoreThread t2 = new RecuperoLettoreThread();

        Biblioteca biblioteca;
        Lettore lettore;
        Prenotazione bozzaPrenotazione;
        IRicercabiliDAO<Prenotazione> pdao = DAOFactory.ottieniDAOFactory().creaPrenotazioneDAO();

        t1.start();
        t2.start();

        try{
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        bozzaPrenotazione = new Prenotazione();
        bozzaPrenotazione.setBiblioteca(biblioteca = t1.getBibliotecaOttenuta());
        bozzaPrenotazione.setLettore(lettore = t2.getLettore());
        bozzaPrenotazione.setGiornoPrenotazione(Date.from(Instant.now()));
        bozzaPrenotazione.setStatoPrenotazione(FaseDiPrenotazione.BOZZA);
        bozzaPrenotazione.setLibri(new ArrayList<>());
        /*
        Quando salvo la prenotazione, viene restituito l'id univoco valido che assegno all'istanza.
         */
        try {
            bozzaPrenotazione.setId(pdao.salva(bozzaPrenotazione));
        } catch (DAOException e) {
            throw new RuntimeException("Impossibile salvare la prenotazione!",e);
        }

        return  new PrenotazioneBean(bozzaPrenotazione);
    }

    public PrenotazioneBean aggiungiLibroAllaPrenotazione(PrenotazioneBean prenotazioneBean, LibroBean nuovoLibroBean){


        Prenotazione prenotazione = DAOFactory.ottieniDAOFactory().creaPrenotazioneDAO().ottieni(prenotazioneBean.getId());

        Libro libro = new Libro();

        libro.setId(nuovoLibroBean.getId());
        libro.setLingua(nuovoLibroBean.getLingua());
        libro.setAutori(nuovoLibroBean.getAutori());
        libro.setEditore(nuovoLibroBean.getEditore());
        libro.setEdizione(nuovoLibroBean.getEdizione());
        libro.setTitolo(nuovoLibroBean.getTitolo());
        libro.setImmagineCopertina(nuovoLibroBean.getImmagineAnteprima());

        prenotazione.addLibro(libro);
        (DAOFactory.ottieniDAOFactory().creaPrenotazioneDAO()).aggiungiLibroAPrenotazione(prenotazione,libro);

        return prenotazioneBean;
    }

    /*
    Questa operazione applica le (o la) regola di prenotazione della biblioteca alla bozza di prenotazione referenziata da prenotazioneBean.
    Se questa risulta conforme, il sistema cambia lo stato della prenotazione (da bozza -> verif
     */
    public void validaPrenotazione(PrenotazioneBean prenotazioneBean) throws RegoleBibliotecaException{

        RegolaPrenotazione regolaBiblioteca;
        Biblioteca bibliotecaDestinazione;
        Lettore lettoreRichiedente;

        Prenotazione prenotazione;
        try{
            prenotazione = DAOFactory.ottieniDAOFactory().creaPrenotazioneDAO().ottieni(prenotazioneBean.getId());
        } catch (DAOException e) {
            throw new RuntimeException(e);
        }

        bibliotecaDestinazione = prenotazione.getBiblioteca();
        regolaBiblioteca = bibliotecaDestinazione.getRegolaPrenotazione();
        lettoreRichiedente = prenotazione.getLettore();

        //se la prenotazione contravviene la regola, viene lanciata l'eccezione.
        try {
            regolaBiblioteca.passaPrenotazione(prenotazione.getLibri());
        } catch (NumeroLibriMassimoSuperatoException e) {
            String messaggio = "Hai superato limite libri stabilito dalla biblioteca: " + e.getNumeroLibriInEccesso() +" in eccesso!";
            throw new RegoleBibliotecaException(messaggio);
        }

        prenotazione.setStatoPrenotazione(FaseDiPrenotazione.VERIFICATA);
        DAOFactory.ottieniDAOFactory().creaPrenotazioneDAO().salva(prenotazione);

        generaRiepilogoBiblioteca(bibliotecaDestinazione, prenotazione);
        generaRiepilogoLettore(lettoreRichiedente, prenotazione);


    }


    private void generaRiepilogoLettore(Lettore lettore, Prenotazione prenotazione){}
    private void generaRiepilogoBiblioteca(Biblioteca biblioteca, Prenotazione prenotazione){}




}


class RecuperoLettoreThread extends Thread{

    Lettore lettore;

    public void run(){

        //provvisorio, deve usare interfaccia.
        LettoreDAO lettoreDAO = DAOFactory.ottieniDAOFactory().creaLettoreDAO();
        this.lettore = lettoreDAO.ottieni(Sessione.ottieniId());
    }

    public Lettore getLettore() {
        return lettore;
    }
}

class RecuperoBibliotecaThread extends Thread{

    BibliotecaBean bibliotecaRichiesta;
    Biblioteca bibliotecaOttenuta;

    RecuperoBibliotecaThread(BibliotecaBean bibliotecaBean){

        this.bibliotecaRichiesta = bibliotecaBean;

    }


    public void run(){

        //provvisorio, deve usare interfaccia
        DAOFactory daoFactory =  DAOFactory.ottieniDAOFactory();
        BibliotecaDAO bdao = daoFactory.creaBibliotecaDAO();
        this.bibliotecaOttenuta = bdao.ottieni(bibliotecaRichiesta.getId());

    }

    public Biblioteca getBibliotecaOttenuta(){
        return this.bibliotecaOttenuta;
    }
}
