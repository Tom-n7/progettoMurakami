package it.tommaso.uniroma2.progettoISPW.dao.factory.persistenza_sistema;

import it.tommaso.uniroma2.progettoISPW.dao.persistenza_sistema.BibliotecaDAO;
import it.tommaso.uniroma2.progettoISPW.dao.persistenza_sistema.LettoreDAO;
import it.tommaso.uniroma2.progettoISPW.dao.persistenza_sistema.PrenotazioneDAO;
import it.tommaso.uniroma2.progettoISPW.dao.factory.DAOFactory;
import it.tommaso.uniroma2.progettoISPW.dao.persistenza_sistema.file.FileBibliotecaDAO;
import it.tommaso.uniroma2.progettoISPW.dao.persistenza_sistema.file.FileLettoreDAO;
import it.tommaso.uniroma2.progettoISPW.dao.persistenza_sistema.file.FilePrenotazioneDAO;

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
}
