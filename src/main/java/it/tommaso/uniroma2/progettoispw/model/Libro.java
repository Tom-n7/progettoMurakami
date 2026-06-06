package it.tommaso.uniroma2.progettoispw.model;

import java.io.Serializable;
import java.util.List;

public class Libro implements Serializable {

    private int id;
    private String titolo;
    private List<String> autori;
    private String lingua;
    private String editore;

    private String edizione;
    private String codiceISNB;

    public Libro(String lingua, List<String> autori, String titolo, String editore, String edizione, String codiceISNB) {
        this.lingua = lingua;
        this.autori = autori;
        this.titolo = titolo;
        this.editore = editore;

        this.edizione = edizione;
        this.codiceISNB = codiceISNB;
    }

    public Libro(){}

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

    public List<String> getAutori() {
        return autori;
    }

    public void setAutori(List<String> autori) {
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

    public void addAutore(String nomeAutore){
        this.autori.add(nomeAutore);
    }
}
