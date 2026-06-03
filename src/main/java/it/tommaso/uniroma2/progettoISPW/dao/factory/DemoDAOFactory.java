package it.tommaso.uniroma2.progettoISPW.dao.factory;

import it.tommaso.uniroma2.progettoISPW.dao.BibliotecaDAO;
import it.tommaso.uniroma2.progettoISPW.dao.LettoreDAO;
import it.tommaso.uniroma2.progettoISPW.dao.LibroDAO;
import it.tommaso.uniroma2.progettoISPW.dao.PrenotazioneDAO;
import it.tommaso.uniroma2.progettoISPW.dao.demo.DemoBibliotecaDAO;
import it.tommaso.uniroma2.progettoISPW.dao.demo.DemoLettoreDAO;
import it.tommaso.uniroma2.progettoISPW.dao.demo.DemoLibroDAO;
import it.tommaso.uniroma2.progettoISPW.dao.demo.DemoPrenotazioneDAO;

public class DemoDAOFactory extends DAOFactory {
    @Override
    public BibliotecaDAO creaBibliotecaDAO() {
        return new DemoBibliotecaDAO();
    }

    @Override
    public LettoreDAO creaLettoreDAO() {
        return new DemoLettoreDAO();
    }

    @Override
    public PrenotazioneDAO creaPrenotazioneDAO() {
        return new DemoPrenotazioneDAO();
    }

    @Override
    public LibroDAO creaLibroDAO() {
        return new DemoLibroDAO();
    }
}
