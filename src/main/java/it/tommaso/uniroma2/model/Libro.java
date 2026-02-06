package it.tommaso.uniroma2.model;

/*
Classe la cui responsabilità è rappresentare all'interno del sistema un libro all'interno del sistema.
 */

import javax.swing.*;
import java.util.Date;
import java.util.List;

public class Libro {

    //metadati del libro.
    private String titolo;
   private List<String> autori;
   private String lingua;
   private String codiceISNB;
   private String nomeSerie;
   private int numeroSerie;
   private String pubblicazione;
   private String editore;
   private String descrizione;



   private void setTitolo(String titolo) {
       this.titolo = titolo;

   }

   private void setAutori(List<String> autori){
       this.autori = autori;
   }

   private void setLingua(String lingua){
       this.lingua = lingua;
   }

   private  void setCodiceISNB(String codiceISNB){
       this.codiceISNB = codiceISNB;
   }

   private void setNomeSerie(String nomeSerie){
       this.nomeSerie = nomeSerie;
   }

   private void setNumeroSerie(int numeroSerie){
       this.numeroSerie = numeroSerie;
   }

   private void setPubblicazione(String pubblicazione){
       this.pubblicazione = pubblicazione;
   }




}


