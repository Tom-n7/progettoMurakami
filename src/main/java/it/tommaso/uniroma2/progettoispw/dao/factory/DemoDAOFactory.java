package it.tommaso.uniroma2.progettoispw.dao.factory;

import it.tommaso.uniroma2.progettoispw.dao.BibliotecaDAO;
import it.tommaso.uniroma2.progettoispw.dao.LettoreDAO;
import it.tommaso.uniroma2.progettoispw.dao.LibroDAO;
import it.tommaso.uniroma2.progettoispw.dao.PrenotazioneDAO;
import it.tommaso.uniroma2.progettoispw.dao.demo.DemoBibliotecaDAO;
import it.tommaso.uniroma2.progettoispw.dao.demo.DemoLettoreDAO;
import it.tommaso.uniroma2.progettoispw.dao.demo.DemoLibroDAO;
import it.tommaso.uniroma2.progettoispw.dao.demo.DemoPrenotazioneDAO;

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
