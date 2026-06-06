package it.tommaso.uniroma2.progettoispw.view.desktop.finestre_popup;

import it.tommaso.uniroma2.progettoispw.view.desktop.OrchestratoreFinestre;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class VistaErrore implements VistaPopup, Initializable {


    private final OrchestratoreFinestre controllerGrafico;
    private final SimpleObjectProperty<String> propertyTestoErrore;

    @FXML
    private Label messaggioErrore;

    public VistaErrore(OrchestratoreFinestre controllerGrafico, SimpleObjectProperty... properties){

        this.controllerGrafico = controllerGrafico;
        propertyTestoErrore = properties[0];
    }






    @Override
    public void initialize(URL location, ResourceBundle resources) {
        messaggioErrore.setText(propertyTestoErrore.get());
    }

    public void clickSuOk(ActionEvent actionEvent) {
        controllerGrafico.chiudiFinestraPopup(this);
    }
}
