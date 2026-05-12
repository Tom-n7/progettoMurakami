package it.tommaso.uniroma2.model;

public class Indirizzo {

    private String via;
    private String citta;
    private String CAP;

    public Indirizzo(String via, String citta, String CAP) {
        this.via = via;
        this.citta = citta;
        this.CAP = CAP;
    }

    @Override
    public String toString() {
        return via + ", " + citta + ", " + CAP;
    }
}
