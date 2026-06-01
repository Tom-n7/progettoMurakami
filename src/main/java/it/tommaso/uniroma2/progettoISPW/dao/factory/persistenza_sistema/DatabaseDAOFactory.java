package it.tommaso.uniroma2.progettoISPW.dao.factory.persistenza_sistema;

import it.tommaso.uniroma2.progettoISPW.dao.persistenza_sistema.BibliotecaDAO;
import it.tommaso.uniroma2.progettoISPW.dao.persistenza_sistema.LettoreDAO;
import it.tommaso.uniroma2.progettoISPW.dao.persistenza_sistema.PrenotazioneDAO;
import it.tommaso.uniroma2.progettoISPW.dao.persistenza_sistema.database.DatabaseBibliotecaDAO;
import it.tommaso.uniroma2.progettoISPW.dao.persistenza_sistema.database.DatabaseLettoreDAO;
import it.tommaso.uniroma2.progettoISPW.dao.persistenza_sistema.database.DatabasePrenotazioneDAO;
import it.tommaso.uniroma2.progettoISPW.dao.factory.DAOFactory;

public class DatabaseDAOFactory extends DAOFactory {
    @Override
    public BibliotecaDAO creaBibliotecaDAO() {
        return new DatabaseBibliotecaDAO();
    }

    @Override
    public LettoreDAO creaLettoreDAO() {
        return new DatabaseLettoreDAO();
    }

    @Override
    public PrenotazioneDAO creaPrenotazioneDAO() {
        return new DatabasePrenotazioneDAO();
    }
}
