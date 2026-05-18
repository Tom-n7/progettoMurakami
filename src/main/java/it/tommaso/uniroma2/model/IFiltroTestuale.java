package it.tommaso.uniroma2.model;

import java.util.List;

public interface IFiltroTestuale <T>{


    public void impostaTestoRicerca(String testoRicerca);

    public void impostaTipo(String nomeTipo);

    public List<String> ottieniTuttiNomiTipi();

    public String ottieniNomeTipoFiltro();

    public String ottieniTestoRicerca();



}
