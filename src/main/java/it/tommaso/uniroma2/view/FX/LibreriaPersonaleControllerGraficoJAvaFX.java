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
    }

    private final LibreriaPersonaleAppController appController = new LibreriaPersonaleAppController();

    private List<LibroBean> contenutoScaffaleSelezionato;

    @FXML
    private ListView<String> vistaLibri = new ListView<>();
    @FXML
    private ListView<String> vistaScaffali = new ListView<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        LibreriaPersonaleBean libreriaPersonale = appController.caricaLibreriaPersonale();
        List<ScaffaleBean> scaffaliLibreria = libreriaPersonale.getScaffaliLibreria();
        List<String> nomiScaffali = libreriaPersonale.getNomiScaffaliLibreria();

        ScaffaleBean scaffaleIniziale;


        nomiScaffali = libreriaPersonale.getNomiScaffaliLibreria();
        vistaScaffali.getItems().addAll(nomiScaffali);
        scaffaleIniziale = scaffaliLibreria.getFirst();

        mostraLibri(scaffaleIniziale);

    }

    private void mostraLibri(ScaffaleBean scaffale){
        vistaLibri.getItems().setAll(scaffale.getTitoliLibriScaffale());
    }


}
