package it.tommaso.uniroma2.bean;

public class CredenzialiBean {

    private String username;
    private String password;
    private boolean verificate;

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public boolean getVerificate(){
        return verificate;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setVerificate(boolean verificate) {
        this.verificate = verificate;
    }
}
