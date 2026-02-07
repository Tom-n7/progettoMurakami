package it.tommaso.uniroma2.model.bean;

import java.util.List;

public class ScaffaleBean {

    private String nomeScaffale;
    private List<LibroBean> libriContenuti;

    public ScaffaleBean(String nomeScaffale, List<LibroBean> libriContenuti){
        this.nomeScaffale = nomeScaffale;
        this.libriContenuti = libriContenuti;
    }



    public String getNomeScaffale() {
        return nomeScaffale;
    }

    public List<LibroBean> getLibriContenuti() {
        return libriContenuti;
    }
}
