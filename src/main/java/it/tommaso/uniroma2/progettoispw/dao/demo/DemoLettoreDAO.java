package it.tommaso.uniroma2.progettoispw.dao.demo;

import it.tommaso.uniroma2.progettoispw.dao.LettoreDAO;
import it.tommaso.uniroma2.progettoispw.exception.DAOException;
import it.tommaso.uniroma2.progettoispw.model.IFiltroTestuale;
import it.tommaso.uniroma2.progettoispw.model.Lettore;

import java.util.List;

public class DemoLettoreDAO implements LettoreDAO {

    //provvisorio
    public Lettore  ottieniLettore() {
        return new Lettore(1,"Tommaso Testa", "tommaso.testa@students.uniroma2.eu", "ttesta99");
    }


    @Override
    public List<Lettore> ottieniTutti() throws DAOException {
        return List.of();
    }

    @Override
    public List<Lettore> ottieniListaFiltrata(IFiltroTestuale filtro) throws DAOException {
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
        return ottieniLettore();
    }

    @Override
    public void elimina(int id) throws DAOException {
        /*
        Potrebbe essere utile implementarlo in futuro
         */

        throw new UnsupportedOperationException();
    }
}
