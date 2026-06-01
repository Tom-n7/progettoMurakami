package it.tommaso.uniroma2.progettoISPW.dao.persistenza_sistema.database;

import it.tommaso.uniroma2.progettoISPW.dao.persistenza_sistema.BibliotecaDAO;
import it.tommaso.uniroma2.progettoISPW.exception.DAOException;
import it.tommaso.uniroma2.progettoISPW.model.Biblioteca;
import it.tommaso.uniroma2.progettoISPW.model.IFiltroTestuale;

import java.util.List;

public class DatabaseBibliotecaDAO implements BibliotecaDAO {
    @Override
    public List<Biblioteca> ottieniTutti() throws DAOException {
        return List.of();
    }

    @Override
    public List<Biblioteca> ottieniListaFiltrata(IFiltroTestuale<Biblioteca> filtro) throws DAOException {
        return List.of();
    }

    @Override
    public int salva(Biblioteca oggetto) throws DAOException {
        return 0;
    }

    @Override
    public void salvaTutti(List<Biblioteca> listaOggetti) throws DAOException {

    }

    @Override
    public Biblioteca ottieni(int id) throws DAOException {
        return null;
    }

    @Override
    public void elimina(int id) throws DAOException {

    }
}
