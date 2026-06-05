package it.tommaso.uniroma2.progettoispw.bean;

import it.tommaso.uniroma2.progettoispw.model.Lettore;

public class LettoreBean {

     private int id;
     private String nome;
     private String username;
     private String email;

     public LettoreBean(Lettore lettore){

         this.id = lettore.getId();
         this.nome = lettore.getNome();
         this.username = lettore.getUsername();
         this.email = lettore.getIndirizzoEmail();

     }

     public LettoreBean(){};

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
