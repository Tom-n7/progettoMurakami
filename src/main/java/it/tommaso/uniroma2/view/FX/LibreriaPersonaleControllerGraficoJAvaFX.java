package it.tommaso.uniroma2.view.FX;

/*
Oggeto che svolge costituisce il componente concreto del controller grafico della libreria personale, gestisce come evolve
la GUI durante la gestione della libreria personale da parte del lettore.
 */


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class LibreriaPersonaleControllerGraficoJAvaFX extends ControllerGrafico  {

    @FXML
    private AnchorPane socketPane;



    public void vistaLibreria() {
        disegnaFinestra("/it.tommaso.uniroma2/view/FX/libreriaPersonale.fxml");
    }


    public void click(ActionEvent e){

        decoraPane("/it.tommaso.uniroma2/view/FX/dettaglioLibro.fxml", socketPane);


    }


}
