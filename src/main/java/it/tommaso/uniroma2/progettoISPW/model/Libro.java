package it.tommaso.uniroma2.progettoISPW.model;

import java.util.Set;

public class Libro {

    private int id;
    private String titolo;
    private Set<String> autori;
    private String lingua;
    private String editore;
    private String urlAnteprima;
    private String edizione;
    private String codiceISNB;

    public Libro(int id, String lingua, Set<String> autori, String titolo, String editore, String urlAnteprima, String edizione, String codiceISNB) {
        this.id = id;
        this.lingua = lingua;
        this.autori = autori;
        this.titolo = titolo;
        this.editore = editore;
        this.urlAnteprima = urlAnteprima;
        this.edizione = edizione;
        this.codiceISNB = codiceISNB;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public Set<String> getAutori() {
        return autori;
    }

    public void setAutori(Set<String> autori) {
        this.autori = autori;
    }

    public String getLingua() {
        return lingua;
    }

    public void setLingua(String lingua) {
        this.lingua = lingua;
    }

    public String getEditore() {
        return editore;
    }

    public void setEditore(String editore) {
        this.editore = editore;
    }

    public String getUrlAnteprima() {
        return urlAnteprima;
    }

    public void setUrlAnteprima(String urlAnteprima) {
        this.urlAnteprima = urlAnteprima;
    }

    public String getEdizione() {
        return edizione;
    }

    public void setEdizione(String edizione) {
        this.edizione = edizione;
    }

    public String getCodiceISNB() {
        return codiceISNB;
    }

    public void setCodiceISNB(String codiceISNB) {
        this.codiceISNB = codiceISNB;
    }
}
