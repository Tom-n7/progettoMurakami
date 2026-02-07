package it.tommaso.uniroma2.view.FX;

/*
Oggeto che svolge costituisce il componente concreto del controller grafico della libreria personale, gestisce come evolve
la GUI durante la gestione della libreria personale da parte del lettore.
 */


import it.tommaso.uniroma2.model.Libro;
import it.tommaso.uniroma2.model.bean.LibroBean;
import it.tommaso.uniroma2.model.bean.ScaffaleBean;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class LibreriaPersonaleControllerGraficoJAvaFX implements Initializable extends ControllerGrafico  {

    public void vistaLibreria() {
        disegnaFinestra("/it.tommaso.uniroma2/view/FX/libreriaPersonale.fxml");
    }

    @FXML
    private ListView<LibroBean> elencoLibri;

    private List<ScaffaleBean> scaffaliLibreria;
    private List<LibroBean> contenutoScaffaleSelezionato;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        elencoLibri.getItems().addAll(contenutoScaffaleSelezionato);
    }
}
