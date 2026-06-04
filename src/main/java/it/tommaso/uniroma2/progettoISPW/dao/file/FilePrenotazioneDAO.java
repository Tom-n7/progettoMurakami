package it.tommaso.uniroma2.progettoISPW.dao.file;

import it.tommaso.uniroma2.progettoISPW.dao.PrenotazioneDAO;
import it.tommaso.uniroma2.progettoISPW.exception.DAOException;
import it.tommaso.uniroma2.progettoISPW.model.FaseDiPrenotazione;
import it.tommaso.uniroma2.progettoISPW.model.IFiltroTestuale;
import it.tommaso.uniroma2.progettoISPW.model.Libro;
import it.tommaso.uniroma2.progettoISPW.model.Prenotazione;

import java.util.List;

public class FilePrenotazioneDAO implements PrenotazioneDAO {
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

    @Override
    public void aggiungiLibroAPrenotazione(Prenotazione prenotazione, Libro libro) {

    }

    @Override
    public void aggiornaStatoPrenotazione(FaseDiPrenotazione nuovoStato, int idPrenotazione) {

    }
}
