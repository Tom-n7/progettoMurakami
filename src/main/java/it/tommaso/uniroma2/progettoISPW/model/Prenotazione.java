package it.tommaso.uniroma2.progettoISPW.model;

import it.tommaso.uniroma2.progettoISPW.bean.PrenotazioneBean;

import java.time.LocalTime;
import java.util.List;

public class Prenotazione {

    private final int id;
    private final Lettore lettore;
    private final Biblioteca biblioteca;

    private LocalTime giornoPrenotazione;
    private FaseDiPrenotazione stato;
    private List<Libro> libri;

    public Prenotazione(int id, Lettore lettore, Biblioteca biblioteca) {
        this.id = id;
        this.lettore = lettore;
        this.biblioteca = biblioteca;
    }

    public Prenotazione(PrenotazioneBean prenotazioneBean){

        this.id = prenotazioneBean.getId();
        this.lettore = new Lettore(prenotazioneBean.getLettore());




    }
}
