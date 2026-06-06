package it.tommaso.uniroma2.progettoispw.dao.demo;

import it.tommaso.uniroma2.progettoispw.dao.LibroDAO;
import it.tommaso.uniroma2.progettoispw.exception.DAOException;
import it.tommaso.uniroma2.progettoispw.model.IFiltroTestuale;
import it.tommaso.uniroma2.progettoispw.model.Libro;

import java.util.List;

public class DemoLibroDAO implements LibroDAO {
    @Override
    public List<Libro> ottieniTutti() throws DAOException {
        return List.of();
    }

    @Override
    public List<Libro> ottieniListaFiltrata(IFiltroTestuale filtro) throws DAOException {
        return List.of();
    }

    @Override
    public int salva(Libro oggetto) throws DAOException {
        return 0;
    }

    @Override
    public void salvaTutti(List<Libro> listaOggetti) throws DAOException {
        /*
        Potrebbe essere utile implementarlo in futuro
         */

        throw new UnsupportedOperationException();
    }

    @Override
    public Libro ottieni(int id) throws DAOException {
        return null;
    }

    @Override
    public void elimina(int id) throws DAOException {
        /*
        Potrebbe essere utile implementarlo in futuro
         */

        throw new UnsupportedOperationException();
    }
}
