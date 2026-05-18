package it.tommaso.uniroma2.bean;

import it.tommaso.uniroma2.model.TipoFiltroBiblioteca;

import java.util.ArrayList;
import java.util.List;

public class FiltroBibliotecaBean {
    private String tipoSelezionato;
    private String testoRicerca;



    public FiltroBibliotecaBean(String tipoSelezionato, String testoRicerca) {
        this.tipoSelezionato = tipoSelezionato;
        this.testoRicerca = testoRicerca;
    }

    public FiltroBibliotecaBean(String tipoSelezionato) {
        this.tipoSelezionato = tipoSelezionato;
        testoRicerca = "";
    }

    public FiltroBibliotecaBean() {
        tipoSelezionato = "";
        testoRicerca = "";
    }

    public String getTestoRicerca() {
        return testoRicerca;
    }

    public void setTestoRicerca(String testoRicerca) {
        this.testoRicerca = testoRicerca;
    }

    public String getTipoSelezionato() {
        return tipoSelezionato;
    }

    public void setTipoSelezionato(String tipoSelezionato) {
        this.tipoSelezionato = tipoSelezionato;
    }

    //La view lo utilizza per conoscere tutti i tipi di filtri esistenti.
    //PROVVISORIO
    public static List<String> getTuttiTipi(){

        List<String> tuttiTipi = new ArrayList<>();

       for(TipoFiltroBiblioteca t: TipoFiltroBiblioteca.values()){
           tuttiTipi.add(t.toString());
       }

       return tuttiTipi;
    }


}
