package it.tommaso.uniroma2.gestiscilp.view.FX;

/*
Oggeto che svolge costituisce il componente concreto del controller grafico della libreria personale, gestisce come evolve
la GUI durante la gestione della libreria personale da parte del lettore.
 */


import it.tommaso.uniroma2.gestiscilp.controller.LibreriaPersonaleAppController;
import it.tommaso.uniroma2.gestiscilp.model.bean.LibreriaPersonaleBean;
import it.tommaso.uniroma2.gestiscilp.model.bean.LibroBean;
import it.tommaso.uniroma2.gestiscilp.model.bean.ScaffaleBean;
import it.tommaso.uniroma2.view.CGFX;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class LibreriaPersonaleControllerGraficoJAvaFX extends CGFX implements Initializable {

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
