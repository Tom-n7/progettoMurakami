package it.tommaso.uniroma2.progettoispw.bean;

import it.tommaso.uniroma2.progettoispw.model.Libro;

import java.sql.Blob;
import java.util.List;

public class LibroBean implements IBean {

    private int id;
    private String titolo;
    private List<String> autori;
    private String lingua;
    private String editore;
    private Blob immagineAnteprima;
    private String edizione;
    private String codiceISNB;

    public LibroBean(){}

    public LibroBean(Libro libro){

        this.id = libro.getId();
        this.titolo = libro.getTitolo();
        this.autori = libro.getAutori();
        this.lingua = libro.getLingua();
        this.editore = libro.getEditore();

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

        StringBuilder builder = new StringBuilder("");
        for(String s : this.autori){
            if(builder.toString().isBlank()){
                builder.append(s);
            }else {

                builder.append(", ");
                builder.append(s);

            }
        }

        builder.insert(0,"\n");
        builder.insert(0,titolo);
        builder.append("\n");
        builder.append(lingua);
        builder.append("\n");
        builder.append(editore);
        builder.append("\n");
        builder.append(edizione);
        builder.append("\n");
        builder.append(codiceISNB);
        builder.append("\n");


        return builder.toString();
    }
}
