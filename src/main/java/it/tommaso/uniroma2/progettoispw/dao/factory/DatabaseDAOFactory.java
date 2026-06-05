package it.tommaso.uniroma2.progettoispw.dao.factory;

import it.tommaso.uniroma2.progettoispw.dao.BibliotecaDAO;
import it.tommaso.uniroma2.progettoispw.dao.LettoreDAO;
import it.tommaso.uniroma2.progettoispw.dao.LibroDAO;
import it.tommaso.uniroma2.progettoispw.dao.PrenotazioneDAO;
import it.tommaso.uniroma2.progettoispw.dao.database.DatabaseBibliotecaDAO;
import it.tommaso.uniroma2.progettoispw.dao.database.DatabaseLettoreDAO;
import it.tommaso.uniroma2.progettoispw.dao.database.DatabaseLibroDAO;
import it.tommaso.uniroma2.progettoispw.dao.database.DatabasePrenotazioneDAO;

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

    @Override
    public LibroDAO creaLibroDAO() {
        return new DatabaseLibroDAO();
    }
}
