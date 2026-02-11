package it.tommaso.uniroma2.model;

/*
Classe la cui responsabilità è rappresentare all'interno del sistema un libro all'interno del sistema.
 */

import javax.swing.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Libro {

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
   private String nomeFileCopertina;
   private int idUnivoco;



   public void setTitolo(String titolo) {
       this.titolo = titolo;

   }

   public void setAutori(List<String> autori){
       this.autori = autori;
   }

   public void aggiungiAutore(String autore){this.autori.add(autore);}

   public void setLingua(String lingua){
       this.lingua = lingua;
   }

   public  void setCodiceISNB(String codiceISNB){
       this.codiceISNB = codiceISNB;
   }

   public void setNomeSerie(String nomeSerie){
       this.nomeSerie = nomeSerie;
   }

   public void setNumeroSerie(String numeroSerie){
       this.numeroSerie = numeroSerie;
   }

   public void setPubblicazione(Date pubblicazione){
       this.pubblicazione = pubblicazione;
   }

    public void setEditore(String editore) {
        this.editore = editore;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public void setNomeFileCopertina(String nomeFileCopertina) {this.nomeFileCopertina = nomeFileCopertina;}

    public void setIdUnivoco(int idUnivoco){this.idUnivoco = idUnivoco;}

    public String getTitolo() {
        return titolo;
    }

    public String getNomeSerie() {
        return nomeSerie;
    }

    public String getLingua() {
        return lingua;
    }

    public String getEditore() {
        return editore;
    }

    public String getCodiceISNB() {
        return codiceISNB;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public List<String> getAutori() {
        return autori;
    }

    public Date getPubblicazione() {
        return pubblicazione;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public String getNomeFileCopertina() {
        return nomeFileCopertina;
    }

    public int getIdUnivoco() {
        return idUnivoco;
    }
}


