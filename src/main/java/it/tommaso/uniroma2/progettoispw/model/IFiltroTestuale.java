package it.tommaso.uniroma2.progettoispw.model;

import java.util.List;

public interface IFiltroTestuale <T>{


    public void impostaTestoRicerca(String testoRicerca);

    public void impostaTipoDaNome(String nomeTipo);

    public List<String> ottieniTuttiNomiTipi();

    public String ottieniNomeTipoFiltro();

    public String ottieniTestoRicerca();



}
