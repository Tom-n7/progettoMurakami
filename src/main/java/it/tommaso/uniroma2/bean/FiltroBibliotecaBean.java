package it.tommaso.uniroma2.bean;

import it.tommaso.uniroma2.model.TipoFiltroBiblioteca;

import java.util.ArrayList;
import java.util.List;

public class FiltroBibliotecaBean {
    private String tipo;
    private String contenuto;


    public FiltroBibliotecaBean(String tipo, String contenuto) {
        this.tipo = tipo;
        this.contenuto = contenuto;
    }

    public String getContenuto() {
        return contenuto;
    }

    public void setContenuto(String contenuto) {
        this.contenuto = contenuto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    //La view lo utilizza per conoscere tutti i tipi di filtri esistenti.
    public static List<String> getTuttiTipi(){

        List<String> tuttiTipi = new ArrayList<>();

       for(TipoFiltroBiblioteca t: TipoFiltroBiblioteca.values()){
           tuttiTipi.add(t.toString());
       }

       return tuttiTipi;
    }


}
