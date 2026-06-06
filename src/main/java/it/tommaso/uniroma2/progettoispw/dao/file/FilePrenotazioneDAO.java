package it.tommaso.uniroma2.progettoispw.dao.file;

import it.tommaso.uniroma2.progettoispw.dao.PrenotazioneDAO;
import it.tommaso.uniroma2.progettoispw.exception.DAOException;
import it.tommaso.uniroma2.progettoispw.model.FaseDiPrenotazione;
import it.tommaso.uniroma2.progettoispw.model.IFiltroTestuale;
import it.tommaso.uniroma2.progettoispw.model.Libro;
import it.tommaso.uniroma2.progettoispw.model.Prenotazione;

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
        /*
        Potrebbe essere utile implementarlo in futuro
         */

        throw new UnsupportedOperationException();
    }

    @Override
    public Prenotazione ottieni(int id) throws DAOException {
        return null;
    }

    @Override
    public void elimina(int id) throws DAOException {
        /*
        Potrebbe essere utile implementarlo in futuro
         */

        throw new UnsupportedOperationException();
    }

    @Override
    public void aggiungiLibroAPrenotazione(Prenotazione prenotazione, Libro libro) {
        /*
        Potrebbe essere utile implementarlo in futuro
         */

        throw new UnsupportedOperationException();
    }

    @Override
    public void aggiornaStatoPrenotazione(FaseDiPrenotazione nuovoStato, int idPrenotazione) {
        /*
        Potrebbe essere utile implementarlo in futuro
         */

        throw new UnsupportedOperationException();
    }
}
