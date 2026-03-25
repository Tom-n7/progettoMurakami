package it.tommaso.uniroma2.gestiscilp.model.bean;

import java.util.ArrayList;
import java.util.List;

public class ScaffaleBean {

    private final String nomeScaffale;
    private final List<LibroBean> LibriScaffale;

    public ScaffaleBean(String nomeScaffale, List<LibroBean> libriScaffale){
        this.nomeScaffale = nomeScaffale;
        this.LibriScaffale = libriScaffale;
    }

    public String getNomeScaffale() {
        return nomeScaffale;
    }

    public List<LibroBean> getLibriScaffale() {
        return this.LibriScaffale;
    }

    public List<String> getTitoliLibriScaffale(){
        List<String> nomi = new ArrayList<>();
        for(LibroBean libro: LibriScaffale){
            nomi.add(libro.getTitolo());
        }
        return nomi;
    }

}
