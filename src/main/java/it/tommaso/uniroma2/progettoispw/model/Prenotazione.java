package it.tommaso.uniroma2.progettoispw.model;


import java.util.Date;
import java.util.List;

public class Prenotazione {

    private  int id;
    private  Lettore lettore;
    private  Biblioteca biblioteca;

    private Date giornoPrenotazione;
    private FaseDiPrenotazione stato;
    private List<Libro> libri;

    public Prenotazione() {
    }

    public Prenotazione(int id, Lettore lettore, Biblioteca biblioteca, Date giornoPrenotazione, FaseDiPrenotazione stato, List<Libro> libri) {
        this.id = id;
        this.lettore = lettore;
        this.biblioteca = biblioteca;
        this.giornoPrenotazione = giornoPrenotazione;
        this.stato = stato;
        this.libri = libri;
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

    public Date getGiornoPrenotazione() {
        return giornoPrenotazione;
    }

    public void setGiornoPrenotazione(Date giornoPrenotazione) {
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
        return (stato == FaseDiPrenotazione.BOZZA);
    }

    public void addLibro(Libro libro){
        this.libri.add(libro);
    }


}
