package it.tommaso.uniroma2.progettoISPW.control;


import it.tommaso.uniroma2.progettoISPW.bean.BibliotecaBean;
import it.tommaso.uniroma2.progettoISPW.bean.FiltroBibliotecaBean;
import it.tommaso.uniroma2.progettoISPW.bean.PrenotazioneBean;
import it.tommaso.uniroma2.progettoISPW.dao.persistenza_sistema.demo.DemoBibliotecaDAO;
import it.tommaso.uniroma2.progettoISPW.dao.persistenza_sistema.IRicercabiliDAO;
import it.tommaso.uniroma2.progettoISPW.dao.persistenza_sistema.demo.DemoLettoreDAO;
import it.tommaso.uniroma2.progettoISPW.dao.persistenza_sistema.demo.DemoPrenotazioneDAO;
import it.tommaso.uniroma2.progettoISPW.exception.DAOException;
import it.tommaso.uniroma2.progettoISPW.exception.RicercaException;
import it.tommaso.uniroma2.progettoISPW.model.*;

import java.time.LocalTime;
import java.util.ArrayList;
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
        try {

            listaBibliotecheOttenute.addAll(new DemoBibliotecaDAO().ottieniListaFiltrata(filtro));
            for (Biblioteca b : listaBibliotecheOttenute) {
                listaBeanBiblioteche.add(new BibliotecaBean(b));
            }


        } catch (DAOException | RicercaException e){
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        return listaBeanBiblioteche;
    }


    public void eliminaPrenotazione(PrenotazioneBean prenotazioneBean){

        try {
            (new DemoPrenotazioneDAO()).elimina(prenotazioneBean.getId());
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
        IRicercabiliDAO<Prenotazione> pdao = new DemoPrenotazioneDAO();

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
        bozzaPrenotazione.setGiornoPrenotazione(LocalTime.now());
        bozzaPrenotazione.setStatoPrenotazione(FaseDiPrenotazione.BOZZA);
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

}


class RecuperoLettoreThread extends Thread{

    Lettore lettore;

    public void run(){

        //provvisorio, deve usare interfaccia.
        this.lettore = (new DemoLettoreDAO()).ottieniLettore();
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
        DemoBibliotecaDAO bdao = new DemoBibliotecaDAO();
        bibliotecaOttenuta = bdao.ottieni(bibliotecaRichiesta.getId());

    }

    public Biblioteca getBibliotecaOttenuta(){
        return this.bibliotecaOttenuta;
    }
}
