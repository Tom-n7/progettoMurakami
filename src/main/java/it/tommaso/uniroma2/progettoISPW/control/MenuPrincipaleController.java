package it.tommaso.uniroma2.progettoISPW.control;

import it.tommaso.uniroma2.progettoISPW.bean.PrenotazioneBean;
import it.tommaso.uniroma2.progettoISPW.dao.factory.DAOFactory;
import it.tommaso.uniroma2.progettoISPW.model.FiltroPrenotazione;
import it.tommaso.uniroma2.progettoISPW.model.Prenotazione;
import it.tommaso.uniroma2.progettoISPW.supporto.Sessione;

import java.util.ArrayList;
import java.util.List;

public class MenuPrincipaleController {


    public List<PrenotazioneBean> ottieniPrenotazioneUtente(){


        FiltroPrenotazione filtroPrenotazione = new FiltroPrenotazione();
        filtroPrenotazione.impostaTestoRicerca(Sessione.getUsername());
        List<Prenotazione> prenotazioni = DAOFactory.ottieniDAOFactory().creaPrenotazioneDAO().ottieniListaFiltrata(filtroPrenotazione);
        List<PrenotazioneBean> listaPrenotazioniBean = new ArrayList<>();

        for(Prenotazione p : prenotazioni){
            listaPrenotazioniBean.add(new PrenotazioneBean(p));
        }


        return listaPrenotazioniBean;
    }


}
