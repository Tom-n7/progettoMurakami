package it.tommaso.uniroma2.progettoISPW.model;

import it.tommaso.uniroma2.progettoISPW.bean.PrenotazioneBean;

import java.time.LocalTime;
import java.util.List;

public class Prenotazione {

    private  int id;
    private  Lettore lettore;
    private  Biblioteca biblioteca;

    private LocalTime giornoPrenotazione;
    private FaseDiPrenotazione stato;
    private List<Libro> libri;

    public Prenotazione() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Lettore getLettore() {
        return lettore;
    }

    public void setLettore(Lettore lettore) {
        this.lettore = lettore;
    }

    public Biblioteca getBiblioteca() {
        return biblioteca;
    }

    public void setBiblioteca(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    public LocalTime getGiornoPrenotazione() {
        return giornoPrenotazione;
    }

    public void setGiornoPrenotazione(LocalTime giornoPrenotazione) {
        this.giornoPrenotazione = giornoPrenotazione;
    }

    public List<Libro> getLibri() {
        return libri;
    }

    public void setLibri(List<Libro> libri) {
        this.libri = libri;
    }

    public FaseDiPrenotazione getStato() {
        return stato;
    }

    public void setStato(FaseDiPrenotazione stato) {
        this.stato = stato;
    }
}
