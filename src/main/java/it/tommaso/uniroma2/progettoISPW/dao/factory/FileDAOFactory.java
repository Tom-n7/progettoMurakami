package it.tommaso.uniroma2.progettoISPW.dao.factory;

import it.tommaso.uniroma2.progettoISPW.dao.BibliotecaDAO;
import it.tommaso.uniroma2.progettoISPW.dao.LettoreDAO;
import it.tommaso.uniroma2.progettoISPW.dao.LibroDAO;
import it.tommaso.uniroma2.progettoISPW.dao.PrenotazioneDAO;
import it.tommaso.uniroma2.progettoISPW.dao.file.FileBibliotecaDAO;
import it.tommaso.uniroma2.progettoISPW.dao.file.FileLettoreDAO;
import it.tommaso.uniroma2.progettoISPW.dao.file.FileLibroDAO;
import it.tommaso.uniroma2.progettoISPW.dao.file.FilePrenotazioneDAO;

public class FileDAOFactory extends DAOFactory {

    @Override
    public BibliotecaDAO creaBibliotecaDAO() {
        return new FileBibliotecaDAO();
    }

    @Override
    public LettoreDAO creaLettoreDAO() {
        return new FileLettoreDAO();
    }

    @Override
    public PrenotazioneDAO creaPrenotazioneDAO() {
        return new FilePrenotazioneDAO();
    }

    @Override
    public LibroDAO creaLibroDAO() {
        return new FileLibroDAO();
    }
}
