package it.tommaso.uniroma2.progettoispw.dao.demo;

import it.tommaso.uniroma2.progettoispw.dao.PrenotazioneDAO;
import it.tommaso.uniroma2.progettoispw.exception.DAOException;
import it.tommaso.uniroma2.progettoispw.model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DemoPrenotazioneDAO implements PrenotazioneDAO {

    private static final Map<Integer, Prenotazione> archivio = new HashMap<>();
    private static int ultimoIdPrenotazione = 1;

    private void valutaUtente(Prenotazione p, IFiltroTestuale filtro, List<Prenotazione> listaPrenotazioniFiltrata){
        if(p.getLettore().getUsername().equals(filtro.ottieniTestoRicerca())){
            listaPrenotazioniFiltrata.add(p);
        }
    }




    private static int assegnaId(){
        ultimoIdPrenotazione++;
        return ultimoIdPrenotazione;
    }

    @Override
    public List<Prenotazione> ottieniTutti() throws DAOException {
        List<Prenotazione> listaPrenotazioni = new ArrayList<>();

        for (Prenotazione p : archivio.values()){
            listaPrenotazioni.add(p);
        }


        return listaPrenotazioni;
    }

    @Override
    public List<Prenotazione> ottieniListaFiltrata(IFiltroTestuale filtro) throws DAOException {
        List<Prenotazione> listaFiltrata = new ArrayList<>();
        for(Prenotazione p : ottieniTutti()){
            valutaUtente(p,filtro,listaFiltrata);
        }
        return listaFiltrata;
    }

    @Override
    public int salva(Prenotazione oggetto) throws DAOException {
        oggetto.setId(assegnaId());
        archivio.put(oggetto.getId(), oggetto);
        return oggetto.getId();
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
        return archivio.get(id);
    }

    @Override
    public void elimina(int id) throws DAOException {
        archivio.remove(id);
    }

    @Override
    public void aggiungiLibroAPrenotazione(Prenotazione prenotazione, Libro libro) {

                /*
        Potrebbe essere utile implementarlo in futuro
         */


    }

    @Override
    public void aggiornaStatoPrenotazione(FaseDiPrenotazione nuovoStato ,int idPrenotazione) {

        archivio.get(idPrenotazione).setStatoPrenotazione(nuovoStato);
    }
}
