package it.tommaso.uniroma2.progettoISPW.model;

public class Indirizzo {

    private String via;
    private String citta;
    private String CAP;

    public Indirizzo(String via, String citta, String CAP) {
        this.via = via;
        this.citta = citta;
        this.CAP = CAP;
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

    public String getCAP() {
        return CAP;
    }

    public void setCAP(String CAP) {
        this.CAP = CAP;
    }

    @Override
    public String toString() {
        return via + ", " + citta + ", " + CAP;
    }
}
