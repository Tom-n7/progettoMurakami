package it.tommaso.uniroma2.progettoISPW.model;

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

    public FaseDiPrenotazione getStatoPrenotazione() {
        return stato;
    }

    public void setStatoPrenotazione(FaseDiPrenotazione stato) {
        this.stato = stato;
    }

    public boolean isBozza(){
        if(stato == FaseDiPrenotazione.BOZZA){
            return true;
        }
        return false;
    }
}
