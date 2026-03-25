package it.tommaso.uniroma2.gestiscilp.model;


/*
Classe con la responsabilità di rappresentare nel sistema un utente registrato.
 */
public class Credenziali {

   private String username;
   private String password;
   private Ruolo ruolo;


    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRuolo(Ruolo ruolo) {
        this.ruolo = ruolo;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Ruolo getRuolo() {
        return ruolo;
    }
}
