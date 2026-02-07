package it.tommaso.uniroma2.model;

import java.util.ArrayList;
import java.util.List;

public class LibreriaPersonale {

    private List<Scaffale> scaffaliLibreria;

    LibreriaPersonale(){
        scaffaliLibreria = new ArrayList<>();
    }


    public List<Scaffale> getScaffaliLibreria() {
        return scaffaliLibreria;
    }

    public void setScaffaliLibreria(List<Scaffale> scaffaliLibreria) {
        this.scaffaliLibreria = scaffaliLibreria;
    }

    public Scaffale trovaScaffale(String nomeScaffale){

        for (Scaffale scaffale : scaffaliLibreria) {

            if (scaffale.getNomeScaffale().equals(nomeScaffale)) {
                return scaffale;
            }

        }
        return null;
    }


}
