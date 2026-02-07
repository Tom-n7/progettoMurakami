package it.tommaso.uniroma2.model;

import java.util.List;


/*
Classe deputata al mantenimento di un gruppo di libri a cui il lettore ha dato un nome.
 */

public class Scaffale {

    private String nomeScaffale;
    //meglio usare una struttura dati che supporti l'ordinamento in modo più agevole
    private List<Libro> libriContenuti;

    public void setInteroContenuto(List<Libro> libriContenuti) {
        this.libriContenuti = libriContenuti;
    }

    public void setNomeScaffale(String nomeScaffale) {
        this.nomeScaffale = nomeScaffale;
    }

    public List<Libro> getLibriContenuti() {
        return libriContenuti;
    }

    public String getNomeScaffale() {
        return nomeScaffale;
    }

    //deve farlo in ordine alfabetico
    public void inserisciLibro(Libro nuovoLibro){
        libriContenuti.add(nuovoLibro);
    }
}
