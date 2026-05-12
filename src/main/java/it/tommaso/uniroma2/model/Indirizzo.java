package it.tommaso.uniroma2.model;

public class Indirizzo {

    private String via;
    private String citta;
    private String CAP;

    @Override
    public String toString() {
        return via + ", " + citta + ", " + CAP;
    }
}
