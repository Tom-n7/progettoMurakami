package it.tommaso.uniroma2.progettoispw.model;

public class Lettore {

    private String nome;
    private int id;
    private String indirizzoEmail;
    private String username;


    public Lettore(int id, String nome, String indirizzoEmail, String username) {
        this.id = id;
        this.nome = nome;
        this.indirizzoEmail = indirizzoEmail;
        this.username = username;
    }

    public Lettore(){
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
