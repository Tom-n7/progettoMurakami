package it.tommaso.uniroma2.progettoISPW.dao;

import it.tommaso.uniroma2.progettoISPW.exception.DAOException;
import it.tommaso.uniroma2.progettoISPW.model.IFiltroTestuale;
import it.tommaso.uniroma2.progettoISPW.model.Lettore;

import java.util.List;

public class LettoreDAO implements IRicercabiliDAO<Lettore> {

    //provvisorio
    public Lettore  ottieniLettore() {


        //provvisorio
        return new Lettore("Tommaso Testa", "tommaso.testa@students.uniroma2.eu", "ttesta");



    }


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

    }

    @Override
    public Lettore ottieni(int id) throws DAOException {
        return null;
    }

    @Override
    public void elimina(int id) throws DAOException {

    }
}
