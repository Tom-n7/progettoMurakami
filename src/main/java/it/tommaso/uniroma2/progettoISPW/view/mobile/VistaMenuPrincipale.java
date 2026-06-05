package it.tommaso.uniroma2.progettoISPW.view.mobile;

import it.tommaso.uniroma2.progettoISPW.bean.IBean;
import it.tommaso.uniroma2.progettoISPW.view.desktop.OrchestratoreFinestre;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ResourceBundle;

public class VistaMenuPrincipale implements VistaMobile, Initializable {
    @FXML
    private Button bottoneNuovaPrenotazione;
    @FXML
    private Button bottoneGestisciLbreria;
    @FXML
    private HBox HBoxAlta;
    @FXML
    private HBox HBoxCentrale;
    @FXML
    private HBox HBoxBassa;

    private final OrchestratoreFinestre controllerGrafico;


    public VistaMenuPrincipale(OrchestratoreFinestre controllerGrafico, IBean... beans){
        this.controllerGrafico = controllerGrafico;
    }

    public void clickSuPrenotazione(ActionEvent actionEvent) {
        controllerGrafico.lanciaVistaCompleta("ricerca_biblioteca");
    }

    public void clickSuEsci(ActionEvent actionEvent) {
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


}
