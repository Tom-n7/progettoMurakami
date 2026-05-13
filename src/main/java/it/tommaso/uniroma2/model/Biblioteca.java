package it.tommaso.uniroma2.model;

import java.time.DayOfWeek;
import java.util.EnumMap;
import java.util.List;

public class Biblioteca {

    private String id;
    private String nome;
    private Indirizzo indirizzo;
    private String collegamentoAnteprima;
    private List<RegolaPrenotazione> regolePrenotazione;
    private EnumMap<DayOfWeek,IOrarioGiornaliero> orarioSettimanale;


    public Biblioteca(String id, String nome, Indirizzo indirizzo, String collegamentoAnteprima, List<RegolaPrenotazione> regolePrenotazione, EnumMap<DayOfWeek, IOrarioGiornaliero> orarioSettimanale) {
        this.id = id;
        this.nome = nome;
        this.indirizzo = indirizzo;
        this.collegamentoAnteprima = collegamentoAnteprima;
        this.regolePrenotazione = regolePrenotazione;
        this.orarioSettimanale = orarioSettimanale;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCollegamentoAnteprima() {
        return collegamentoAnteprima;
    }

    public void setCollegamentoAnteprima(String collegamentoAnteprima) {
        this.collegamentoAnteprima = collegamentoAnteprima;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Indirizzo getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(Indirizzo indirizzo) {
        this.indirizzo = indirizzo;
    }

    public List<RegolaPrenotazione> getRegolePrenotazione() {
        return regolePrenotazione;
    }

    public void setRegolePrenotazione(List<RegolaPrenotazione> regolePrenotazione) {
        this.regolePrenotazione = regolePrenotazione;
    }

    public EnumMap<DayOfWeek, IOrarioGiornaliero> getOrarioSettimanale() {
        return orarioSettimanale;
    }

    public void setOrarioSettimanale(EnumMap<DayOfWeek, IOrarioGiornaliero> orarioSettimanale) {
        this.orarioSettimanale = orarioSettimanale;
    }


    @Override
    public String toString() {
        return super.toString();
    }
}
