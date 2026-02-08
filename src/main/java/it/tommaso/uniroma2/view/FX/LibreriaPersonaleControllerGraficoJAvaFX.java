package it.tommaso.uniroma2.view.FX;

/*
Oggeto che svolge costituisce il componente concreto del controller grafico della libreria personale, gestisce come evolve
la GUI durante la gestione della libreria personale da parte del lettore.
 */


import com.sun.javafx.collections.ObservableListWrapper;
import it.tommaso.uniroma2.controller.LibreriaPersonaleAppController;
import it.tommaso.uniroma2.model.LibreriaPersonale;
import it.tommaso.uniroma2.model.Libro;
import it.tommaso.uniroma2.model.bean.LibreriaPersonaleBean;
import it.tommaso.uniroma2.model.bean.LibroBean;
import it.tommaso.uniroma2.model.bean.ScaffaleBean;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class LibreriaPersonaleControllerGraficoJAvaFX extends ControllerGrafico implements Initializable {

    public void vistaLibreria() {

        disegnaFinestra("/it.tommaso.uniroma2/view/FX/libreriaPersonale.fxml");
        libreriaPersonale = new LibreriaPersonaleAppController().caricaLibreriaPersonale();
        //disegno la finestra dopo che compongo le lista con i contenuti.

    }

    private final LibreriaPersonaleAppController appController = new LibreriaPersonaleAppController();

    @FXML
    private ListView<String> vistaLibri;

    @FXML
    private ListView<String> vistaScaffali = new ListView<>();

    LibreriaPersonaleBean libreriaPersonale;
    private ObservableList<String> obsListScaffali;
    private List<ScaffaleBean> scaffaliLibreria;
    private List<LibroBean> contenutoScaffaleSelezionato;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        libreriaPersonale = new LibreriaPersonaleAppController().caricaLibreriaPersonale();
        List<String> nomiScaffali = libreriaPersonale.getNomiScaffaliLibreria();
        vistaScaffali.getItems().addAll(nomiScaffali);




    }
}
