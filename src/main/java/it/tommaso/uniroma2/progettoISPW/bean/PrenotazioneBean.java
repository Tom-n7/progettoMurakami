package it.tommaso.uniroma2.progettoISPW.bean;

import it.tommaso.uniroma2.progettoISPW.model.Biblioteca;
import it.tommaso.uniroma2.progettoISPW.model.Prenotazione;

import java.util.List;

public class PrenotazioneBean implements IBean<Prenotazione>{


    private BibliotecaBean biblioteca;
    private LettoreBean lettore;
    private List<LibroBean> libri;
    private int id;

    public PrenotazioneBean(BibliotecaBean biblioteca, LettoreBean lettore, int id, List<LibroBean> libri) {
        this.biblioteca = biblioteca;
        this.lettore = lettore;
        this.id = id;
        this.libri = libri;
    }

    public  PrenotazioneBean(Prenotazione prenotazione){

    }

    public BibliotecaBean getBiblioteca() {
        return biblioteca;
    }

    public void setBiblioteca(BibliotecaBean biblioteca) {
        this.biblioteca = biblioteca;
    }

    public LettoreBean getLettore() {
        return lettore;
    }

    public void setLettore(LettoreBean lettore) {
        this.lettore = lettore;
    }

    public List<LibroBean> getLibri() {
        return libri;
    }

    public void setLibri(List<LibroBean> libri) {
        this.libri = libri;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
