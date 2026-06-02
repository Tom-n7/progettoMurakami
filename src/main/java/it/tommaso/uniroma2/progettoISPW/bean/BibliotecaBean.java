package it.tommaso.uniroma2.progettoISPW.bean;

import it.tommaso.uniroma2.progettoISPW.model.Biblioteca;

import java.time.DayOfWeek;
import java.util.Map;

public class BibliotecaBean implements IBean<Biblioteca> {


    private int id;
    private String nome;
    private String indirizzo;
    private String collegamentoAnteprima;
    private String regolePrenotazione;
    private Map<String, String> orarioSettimanale;


    public BibliotecaBean(Biblioteca biblioteca){

         id = biblioteca.getId();
         nome = biblioteca.getNome();
         indirizzo = biblioteca.getIndirizzo().getVia() + ", " + biblioteca.getIndirizzo().getCitta() +", " + biblioteca.getIndirizzo().getCAP();
         collegamentoAnteprima = null;
         regolePrenotazione = biblioteca.getRegolePrenotazione().toString();

         for (DayOfWeek day: DayOfWeek.values()){
             if( biblioteca.getOrarioSettimanale() != null) {
                 orarioSettimanale.put(day.toString(), biblioteca.getOrarioSettimanale().get(day).toString());
             }
         }

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getRegolePrenotazione() {
        return regolePrenotazione;
    }

    public void setRegolePrenotazione(String regolePrenotazione) {
        this.regolePrenotazione = regolePrenotazione;
    }

    public Map<String, String> getOrarioSettimanale() {
        return orarioSettimanale;
    }

    public void setOrarioSettimanale(Map<String, String> orarioSettimanale) {
        this.orarioSettimanale = orarioSettimanale;
    }

    public String getCollegamentoAnteprima() {
        return collegamentoAnteprima;
    }

    public void setCollegamentoAnteprima(String collegamentoAnteprima) {
        this.collegamentoAnteprima = collegamentoAnteprima;
    }

    public String toString(){
        return "Nome: " + nome + "\n"
                + "Indirizzo: " + indirizzo + "\n";
    }

}
