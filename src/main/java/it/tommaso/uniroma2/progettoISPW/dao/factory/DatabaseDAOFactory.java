package it.tommaso.uniroma2.progettoISPW.dao.factory;

import it.tommaso.uniroma2.progettoISPW.dao.BibliotecaDAO;
import it.tommaso.uniroma2.progettoISPW.dao.LettoreDAO;
import it.tommaso.uniroma2.progettoISPW.dao.PrenotazioneDAO;
import it.tommaso.uniroma2.progettoISPW.dao.database.DatabaseBibliotecaDAO;
import it.tommaso.uniroma2.progettoISPW.dao.database.DatabaseLettoreDAO;
import it.tommaso.uniroma2.progettoISPW.dao.database.DatabasePrenotazioneDAO;

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
