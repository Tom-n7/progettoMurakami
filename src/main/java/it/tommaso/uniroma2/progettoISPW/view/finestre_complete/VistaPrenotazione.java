package it.tommaso.uniroma2.progettoISPW.view.finestre_complete;

import it.tommaso.uniroma2.progettoISPW.bean.BibliotecaBean;
import it.tommaso.uniroma2.progettoISPW.bean.IBean;
import it.tommaso.uniroma2.progettoISPW.view.DesktopController;
import it.tommaso.uniroma2.progettoISPW.view.OrchestratoreFinestre;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ResourceBundle;

public class VistaPrenotazione implements VistaCompleta, Initializable {


    private final BibliotecaBean biblioteca;
    private final OrchestratoreFinestre controller;

    private double altezzaScheda;
    private double larghezzaScheda;

    @FXML
    private HBox listaLibriPrenotazione;
    @FXML
    private StackPane schedaAggiuntaLibro;
    @FXML
    private Button bottoneAggiungiLibro;
    @FXML
    private Button bottoneConferma;
    @FXML
    private Button bottoneEsci;

    public VistaPrenotazione(OrchestratoreFinestre controller, IBean... beans){

       this.controller = controller;
       biblioteca = (BibliotecaBean) beans[0];

    }


    public void clickSuAggiungi(ActionEvent actionEvent) {

        larghezzaScheda = schedaAggiuntaLibro.getWidth();
        altezzaScheda = schedaAggiuntaLibro.getHeight();

        StackPane schedaLibro = new StackPane();
        schedaLibro.setBackground(Background.fill(Color.RED));
        schedaLibro.setPrefWidth(20);
        schedaLibro.setPrefHeight(30);

        listaLibriPrenotazione.getChildren().add(schedaLibro);
        controller.ricaricaVista();

    }

    public void clickSuConferma(ActionEvent actionEvent) {
    }

    public void clickSuEsci(ActionEvent actionEvent) {

        controller.lanciaVistaCompleta("ricerca_biblioteca");

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
