package it.tommaso.uniroma2.progettoispw.model;

public class Indirizzo {

    private String via;
    private String citta;
    private String cap;

    public Indirizzo(String via, String citta, String cap) {
        this.via = via;
        this.citta = citta;
        this.cap = cap;
    }

    public Indirizzo(){}
    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public String getCap() {
        return cap;
    }

    public void setCap(String cap) {
        this.cap = cap;
    }

    @Override
    public String toString() {
        return via + ", " + citta + ", " + cap;
    }
}
