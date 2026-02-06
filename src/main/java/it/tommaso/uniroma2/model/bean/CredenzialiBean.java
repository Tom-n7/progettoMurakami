package it.tommaso.uniroma2.model.bean;

import it.tommaso.uniroma2.model.Ruolo;

public class CredenzialiBean {

    private String username;
    private String password;
    private boolean verificate;
    private Ruolo ruolo;

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public boolean getVerificate(){
        return verificate;
    }

    public Ruolo getRuolo(){return  ruolo;}

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setVerificate(boolean verificate) {
        this.verificate = verificate;
    }

    public void setRuolo(Ruolo ruolo){this.ruolo = ruolo;}
}
