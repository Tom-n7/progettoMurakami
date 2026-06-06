package it.tommaso.uniroma2.progettoispw.model;

import java.util.List;

public class FiltroPrenotazione implements IFiltroTestuale{

    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public void impostaTestoRicerca(String testoRicerca) {
        username = testoRicerca;
    }

    @Override
    public void impostaTipoDaNome(String nomeTipo) {
        /*
        Per ora non ci sono tipi filtri prenotazione.
         */

        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> ottieniTuttiNomiTipi() {
        return List.of();
    }

    @Override
    public String ottieniNomeTipoFiltro() {
        return "";
    }

    @Override
    public String ottieniTestoRicerca() {
        return username;
    }
}
