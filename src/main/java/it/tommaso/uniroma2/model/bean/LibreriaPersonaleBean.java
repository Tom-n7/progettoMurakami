package it.tommaso.uniroma2.model.bean;

import it.tommaso.uniroma2.model.LibreriaPersonale;

import java.util.ArrayList;
import java.util.List;

public class LibreriaPersonaleBean {

    public LibreriaPersonaleBean(List<ScaffaleBean> scaffaliLibreria){
        this.scaffaliLibreria = scaffaliLibreria;
    }

    private List<ScaffaleBean> scaffaliLibreria;

    public List<ScaffaleBean> getScaffaliLibreria() {
        return scaffaliLibreria;
    }

    /*
    Restituisce tutti i nomi degli scaffali presenti nella libreria.
     */
    public List<String> getNomiScaffaliLibreria(){
        List<String> nomi = new ArrayList<>();

        for(ScaffaleBean scaffale: scaffaliLibreria ){

            nomi.add(scaffale.getNomeScaffale());

        }
        return nomi;
    }

}
