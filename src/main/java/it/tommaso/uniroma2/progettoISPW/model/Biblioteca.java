package it.tommaso.uniroma2.progettoISPW.model;



import java.sql.Blob;
import java.time.DayOfWeek;
import java.util.EnumMap;
import java.util.List;

public class Biblioteca {

    private int id;
    private String nome;
    private Indirizzo indirizzo;
    private Blob immagineAnteprima;
    private RegolaPrenotazione regolePrenotazione;
    private EnumMap<DayOfWeek,IOrarioGiornaliero> orarioSettimanale;

    public Biblioteca(){}

    public Biblioteca(int id, String nome, Indirizzo indirizzo, Blob immagineAnteprima, RegolaPrenotazione regolePrenotazione, EnumMap<DayOfWeek, IOrarioGiornaliero> orarioSettimanale) {
        this.id = id;
        this.nome = nome;
        this.indirizzo = indirizzo;
        this.immagineAnteprima = immagineAnteprima;
        this.regolePrenotazione = regolePrenotazione;
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

    public RegolaPrenotazione getRegolePrenotazione() {
        return regolePrenotazione;
    }

    public void setRegolePrenotazione(RegolaPrenotazione regolaPrenotazione) {
        this.regolePrenotazione = regolaPrenotazione;
    }

    public EnumMap<DayOfWeek, IOrarioGiornaliero> getOrarioSettimanale() {
        return orarioSettimanale;
    }

    public void setOrarioSettimanale(EnumMap<DayOfWeek, IOrarioGiornaliero> orarioSettimanale) {
        this.orarioSettimanale = orarioSettimanale;
    }

}
