package it.tommaso.uniroma2.progettoispw.model;



import java.sql.Blob;
import java.time.DayOfWeek;

import java.util.Map;

public class Biblioteca {

    private int id;
    private String nome;
    private Indirizzo indirizzo;
    private Blob immagineAnteprima;
    private RegolaPrenotazione regolaPrenotazione;
    private Map<DayOfWeek,IOrarioGiornaliero> orarioSettimanale;

    public Biblioteca(){}

    public Biblioteca(int id, String nome, Indirizzo indirizzo, Blob immagineAnteprima, RegolaPrenotazione regolaPrenotazione, Map<DayOfWeek, IOrarioGiornaliero> orarioSettimanale) {
        this.id = id;
        this.nome = nome;
        this.indirizzo = indirizzo;
        this.immagineAnteprima = immagineAnteprima;
        this.regolaPrenotazione = regolaPrenotazione;
        this.orarioSettimanale = orarioSettimanale;
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

    public Indirizzo getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(Indirizzo indirizzo) {
        this.indirizzo = indirizzo;
    }

    public RegolaPrenotazione getRegolaPrenotazione() {
        return regolaPrenotazione;
    }

    public void setRegolaPrenotazione(RegolaPrenotazione regolaPrenotazione) {
        this.regolaPrenotazione = regolaPrenotazione;
    }

    public Map<DayOfWeek, IOrarioGiornaliero> getOrarioSettimanale() {
        return orarioSettimanale;
    }

    public void setOrarioSettimanale(Map<DayOfWeek, IOrarioGiornaliero> orarioSettimanale) {
        this.orarioSettimanale = orarioSettimanale;
    }

    public Blob getImmagineAnteprima() {
        return immagineAnteprima;
    }

    public void setImmagineAnteprima(Blob immagineAnteprima) {
        this.immagineAnteprima = immagineAnteprima;
    }
}
