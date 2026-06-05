package it.tommaso.uniroma2.progettoispw.dao;

import it.tommaso.uniroma2.progettoispw.model.FaseDiPrenotazione;
import it.tommaso.uniroma2.progettoispw.model.Libro;
import it.tommaso.uniroma2.progettoispw.model.Prenotazione;

public interface PrenotazioneDAO extends IRicercabiliDAO<Prenotazione> {

    public void aggiungiLibroAPrenotazione(Prenotazione prenotazione, Libro libro);

    public void aggiornaStatoPrenotazione(FaseDiPrenotazione nuovoStato, int idPrenotazione);

}
