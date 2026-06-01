package it.tommaso.uniroma2.progettoISPW.dao.factory.persistenza_sistema;

import it.tommaso.uniroma2.progettoISPW.dao.persistenza_sistema.BibliotecaDAO;
import it.tommaso.uniroma2.progettoISPW.dao.persistenza_sistema.LettoreDAO;
import it.tommaso.uniroma2.progettoISPW.dao.persistenza_sistema.PrenotazioneDAO;
import it.tommaso.uniroma2.progettoISPW.dao.persistenza_sistema.demo.DemoBibliotecaDAO;
import it.tommaso.uniroma2.progettoISPW.dao.persistenza_sistema.demo.DemoLettoreDAO;
import it.tommaso.uniroma2.progettoISPW.dao.persistenza_sistema.demo.DemoPrenotazioneDAO;
import it.tommaso.uniroma2.progettoISPW.dao.factory.DAOFactory;

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
}
