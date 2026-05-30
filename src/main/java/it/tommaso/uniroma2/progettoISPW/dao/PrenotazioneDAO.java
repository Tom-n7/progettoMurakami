package it.tommaso.uniroma2.progettoISPW.dao;

import it.tommaso.uniroma2.progettoISPW.exception.DAOException;
import it.tommaso.uniroma2.progettoISPW.model.Biblioteca;
import it.tommaso.uniroma2.progettoISPW.model.IFiltroTestuale;
import it.tommaso.uniroma2.progettoISPW.model.Prenotazione;

import java.util.List;

public class PrenotazioneDAO implements IRicercabiliDAO<Prenotazione> {
    @Override
    public List<Prenotazione> ottieniTutti() throws DAOException {
        return List.of();
    }

    @Override
    public List<Prenotazione> ottieniListaFiltrata(IFiltroTestuale<Prenotazione> filtro) throws DAOException {
        return List.of();
    }

    @Override
    public int salva(Prenotazione oggetto) throws DAOException {
        return 0;
    }

    @Override
    public void salvaTutti(List<Prenotazione> listaOggetti) throws DAOException {

    }

    @Override
    public Prenotazione ottieni(int id) throws DAOException {
        return null;
    }

    @Override
    public void elimina(int id) throws DAOException {

    }
}
