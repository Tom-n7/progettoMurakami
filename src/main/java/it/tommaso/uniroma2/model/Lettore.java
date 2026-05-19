package it.tommaso.uniroma2.model;

public class Lettore {

    private String nome;
    private String cognome;
    private String indirizzoEmail;
    private String username;


    public Lettore(String nome, String cognome, String indirizzoEmail, String username) {
        this.nome = nome;
        this.cognome = cognome;
        this.indirizzoEmail = indirizzoEmail;
        this.username = username;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getIndirizzoEmail() {
        return indirizzoEmail;
    }

    public void setIndirizzoEmail(String indirizzoEmail) {
        this.indirizzoEmail = indirizzoEmail;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
