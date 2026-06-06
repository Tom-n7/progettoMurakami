package it.tommaso.uniroma2.progettoispw.dao.file;

import it.tommaso.uniroma2.progettoispw.dao.LettoreDAO;
import it.tommaso.uniroma2.progettoispw.exception.DAOException;
import it.tommaso.uniroma2.progettoispw.model.IFiltroTestuale;
import it.tommaso.uniroma2.progettoispw.model.Lettore;

import java.util.List;

public class FileLettoreDAO implements LettoreDAO {
    @Override
    public List<Lettore> ottieniTutti() throws DAOException {
        return List.of();
    }

    @Override
    public List<Lettore> ottieniListaFiltrata(IFiltroTestuale<Lettore> filtro) throws DAOException {
        return List.of();
    }

    @Override
    public int salva(Lettore oggetto) throws DAOException {
        return 0;
    }

    @Override
    public void salvaTutti(List<Lettore> listaOggetti) throws DAOException {
        /*
        Potrebbe essere utile implementarlo in futuro
         */

        throw new UnsupportedOperationException();
    }

    @Override
    public Lettore ottieni(int id) throws DAOException {
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
