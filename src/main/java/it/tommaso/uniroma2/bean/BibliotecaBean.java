package it.tommaso.uniroma2.bean;

import it.tommaso.uniroma2.model.Biblioteca;

import java.time.DayOfWeek;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class BibliotecaBean {


    private String id;
    private String nome;
    private String indirizzo;
    private String collegamentoAnteprima;
    private String regolePrenotazione;
    private Map<String, String> orarioSettimanale;


    public BibliotecaBean(Biblioteca biblioteca){

         id = biblioteca.getId();
         nome = biblioteca.getNome();
         indirizzo = biblioteca.getIndirizzo().toString();
         collegamentoAnteprima = null;
         regolePrenotazione = biblioteca.getRegolePrenotazione().toString();

         for (DayOfWeek day: DayOfWeek.values()){
             if( biblioteca.getOrarioSettimanale() != null) {
                 orarioSettimanale.put(day.toString(), biblioteca.getOrarioSettimanale().get(day).toString());
             }
         }

    }


    public String toString(){
        return "Nome: " + nome + "\n"
                + "Indirizzo: " + indirizzo + "\n";
    }

}
