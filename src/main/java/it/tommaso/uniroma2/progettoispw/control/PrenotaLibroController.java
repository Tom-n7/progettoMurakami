package it.tommaso.uniroma2.progettoispw.control;


import it.tommaso.uniroma2.progettoispw.bean.*;
import it.tommaso.uniroma2.progettoispw.dao.BibliotecaDAO;
import it.tommaso.uniroma2.progettoispw.dao.IRicercabiliDAO;
import it.tommaso.uniroma2.progettoispw.dao.LettoreDAO;
import it.tommaso.uniroma2.progettoispw.dao.factory.DAOFactory;
import it.tommaso.uniroma2.progettoispw.exception.DAOException;
import it.tommaso.uniroma2.progettoispw.exception.NumeroLibriMassimoSuperatoException;
import it.tommaso.uniroma2.progettoispw.exception.RegoleBibliotecaException;
import it.tommaso.uniroma2.progettoispw.exception.RicercaException;
import it.tommaso.uniroma2.progettoispw.model.*;
import it.tommaso.uniroma2.progettoispw.supporto.Sessione;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
Controller applicativo del caso d'uso prenota libro.
 */
public class PrenotaLibroController {

    public List<BibliotecaBean> caricaBibliotecheRegistrate(FiltroBibliotecaBean filtroBean) throws RicercaException {

        //lista di bean biblioteche da inviare allo strato view.
        List<BibliotecaBean> listaBeanBiblioteche = new ArrayList<>();
        //lista di biblioteche così come viene generata dal DAO.
        List<Biblioteca> listaBibliotecheOttenute = new ArrayList<>();
        //filtro che viene valutato ed eventualmente usato per ottenere una lista di biblioteche filtrata
        //secondo i criteri scelti.
        FiltroBiblioteca filtro = new FiltroBiblioteca(filtroBean);
        BibliotecaDAO bdao = DAOFactory.ottieniDAOFactory().creaBibliotecaDAO();
        try {

            listaBibliotecheOttenute.addAll(
                    bdao.ottieniListaFiltrata(filtro));
            for (Biblioteca b : listaBibliotecheOttenute) {
                listaBeanBiblioteche.add(new BibliotecaBean(b));
            }


        } catch (DAOException | RicercaException e){
            throw new RicercaException("Formato dati errato!",e);
        }
        return listaBeanBiblioteche;
    }


    public void eliminaPrenotazione(PrenotazioneBean prenotazioneBean) {

        DAOFactory.ottieniDAOFactory().creaPrenotazioneDAO().elimina(prenotazioneBean.getId());

    }
    public PrenotazioneBean bozzaPrenotazione(BibliotecaBean bibliotecaSelezionata) throws InterruptedException {

        RecuperoBibliotecaThread t1 = new RecuperoBibliotecaThread(bibliotecaSelezionata);
        RecuperoLettoreThread t2 = new RecuperoLettoreThread();

        Prenotazione bozzaPrenotazione;
        IRicercabiliDAO<Prenotazione> pdao = DAOFactory.ottieniDAOFactory().creaPrenotazioneDAO();

        t1.start();
        t2.start();

        try{
            t1.join();
            t2.join();
        } catch (InterruptedException e ) {
            throw new InterruptedException();
        }

        bozzaPrenotazione = new Prenotazione();
        bozzaPrenotazione.setBiblioteca( t1.getBibliotecaOttenuta());
        bozzaPrenotazione.setLettore( t2.getLettore());
        bozzaPrenotazione.setGiornoPrenotazione(Date.from(Instant.now()));
        bozzaPrenotazione.setStatoPrenotazione(FaseDiPrenotazione.BOZZA);
        bozzaPrenotazione.setLibri(new ArrayList<>());
        /*
        Quando salvo la prenotazione, viene restituito l'id univoco valido che assegno all'istanza.
         */

        bozzaPrenotazione.setId(pdao.salva(bozzaPrenotazione));


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
    public void validaPrenotazione(PrenotazioneBean prenotazioneBean) throws RegoleBibliotecaException {

        RegolaPrenotazione regolaBiblioteca;
        Biblioteca bibliotecaDestinazione;


        Prenotazione prenotazione;

        prenotazione = DAOFactory.ottieniDAOFactory().creaPrenotazioneDAO().ottieni(prenotazioneBean.getId());

        bibliotecaDestinazione = prenotazione.getBiblioteca();
        regolaBiblioteca = bibliotecaDestinazione.getRegolaPrenotazione();

        //se la prenotazione contravviene la regola, viene lanciata l'eccezione.
        try {
            regolaBiblioteca.passaPrenotazione(prenotazione.getLibri());

            prenotazione.setStatoPrenotazione(FaseDiPrenotazione.VERIFICATA);
            DAOFactory.ottieniDAOFactory().creaPrenotazioneDAO().aggiornaStatoPrenotazione(FaseDiPrenotazione.VERIFICATA,prenotazione.getId());

        } catch (NumeroLibriMassimoSuperatoException e) {
            String messaggio = "Hai superato limite libri stabilito dalla biblioteca: " + e.getNumeroLibriInEccesso() +" in eccesso!";
            throw new RegoleBibliotecaException(messaggio);
        }

    }






}


class RecuperoLettoreThread extends Thread{

    Lettore lettore;

    @Override
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

    @Override
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
