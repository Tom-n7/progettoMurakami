package it.tommaso.uniroma2.progettoISPW.dao;

import it.tommaso.uniroma2.progettoISPW.model.FaseDiPrenotazione;
import it.tommaso.uniroma2.progettoISPW.model.Libro;
import it.tommaso.uniroma2.progettoISPW.model.Prenotazione;

public interface PrenotazioneDAO extends IRicercabiliDAO<Prenotazione> {

    public void aggiungiLibroAPrenotazione(Prenotazione prenotazione, Libro libro);

    public void aggiornaStatoPrenotazione(FaseDiPrenotazione nuovoStato, int idPrenotazione);

}
