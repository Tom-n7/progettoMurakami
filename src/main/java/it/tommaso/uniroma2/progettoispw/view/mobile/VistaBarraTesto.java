package it.tommaso.uniroma2.progettoispw.view.mobile;

import it.tommaso.uniroma2.progettoispw.view.desktop.OrchestratoreFinestre;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class VistaBarraTesto implements VistaMobilePopup, Initializable {


    private final OrchestratoreFinestre controllerGrafico;

    private final SimpleObjectProperty<String> propertyTestoImmesso;




    public TextField inputField;
    public Label labelInfo;

    public VistaBarraTesto(OrchestratoreFinestre controllerGrafico, SimpleObjectProperty... properties){

        this.controllerGrafico = controllerGrafico;

        try {
            propertyTestoImmesso = properties[0];
        } catch (ClassCastException e) {
            String nomeClasseSbagliata = properties[0].getClass().toString();
            throw new IllegalArgumentException("La vista necessita di un'istanza di BibliotecaBean, invece viene fornita classe " + nomeClasseSbagliata);
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void tapSuConferma(ActionEvent actionEvent) {
        if(!inputField.getText().isEmpty()) {

            propertyTestoImmesso.set(inputField.getText());
            controllerGrafico.chiudiFinestraPopup(this);


        }

    }

    public void tapSuEsci(ActionEvent actionEvent) {
    }
}
