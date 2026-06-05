package it.tommaso.uniroma2.progettoispw.bean;

import it.tommaso.uniroma2.progettoispw.model.Libro;

import java.sql.Blob;
import java.util.List;

public class LibroBean implements IBean<LibroBean> {

    private int id;
    private String titolo;
    private List<String> autori;
    private String lingua;
    private String editore;
    private Blob immagineAnteprima;
    private String edizione;
    private String codiceISNB;

    public LibroBean(){}

    public LibroBean(int id, String titolo, List<String> autori, String lingua, String editore, Blob immagineAnteprima, String edizione, String codiceISNB) {
        this.id = id;
        this.titolo = titolo;
        this.autori = autori;
        this.lingua = lingua;
        this.editore = editore;
        this.immagineAnteprima = immagineAnteprima;
        this.edizione = edizione;
        this.codiceISNB = codiceISNB;
    }

    public LibroBean(Libro libro){

        this.id = libro.getId();
        this.titolo = libro.getTitolo();
        this.autori = libro.getAutori();
        this.lingua = libro.getLingua();
        this.editore = libro.getEditore();
        this.immagineAnteprima = libro.getImmagineCopertina();
        this.edizione = libro.getEdizione();
        this.codiceISNB = libro.getCodiceISNB();

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

    public Blob getImmagineAnteprima() {
        return immagineAnteprima;
    }

    public void setImmagineAnteprima(Blob immagineAnteprima) {
        this.immagineAnteprima = immagineAnteprima;
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


    @Override
    public String toString() {

        String autori = "" ;
        for(String s : this.autori){
            if(autori.isEmpty()){
                autori = s;
            }else {
                autori = autori + ", " + s;
            }
        }


        return titolo + "\n" + autori +"\n" + lingua + "\n" + editore + "\n" + edizione + "\n" + codiceISNB + "\n";
    }
}
