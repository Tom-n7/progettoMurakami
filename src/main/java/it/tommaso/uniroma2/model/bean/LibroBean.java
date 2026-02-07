package it.tommaso.uniroma2.model.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LibroBean {

    LibroBean(String titolo, List<String> autori, String lingua, String codiceISNB,
              String nomeSerie, String numeroSerie, Date pubblicazione, String editore, String descrizione){

        this.autori = autori;
        this.codiceISNB = codiceISNB;
        this.descrizione = descrizione;
        this.editore = editore;
        this.lingua = lingua;
        this.nomeSerie = nomeSerie;
        this.numeroSerie = numeroSerie;
        this.pubblicazione = pubblicazione;
        this.titolo = titolo;

    }




    //metadati del libro.
    private String titolo;
    private List<String> autori = new ArrayList<>();
    private String lingua;
    private String codiceISNB;
    private String nomeSerie;
    private String numeroSerie;
    private Date pubblicazione;
    private String editore;
    private String descrizione;


    public Date getPubblicazione() {
        return pubblicazione;
    }

    public List<String> getAutori() {
        return autori;
    }

    public String getCodiceISNB() {
        return codiceISNB;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public String getEditore() {
        return editore;
    }

    public String getLingua() {
        return lingua;
    }

    public String getNomeSerie() {
        return nomeSerie;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public String getTitolo() {
        return titolo;
    }
}
