package it.tommaso.uniroma2.progettoISPW.view.finestre_popup;

import it.tommaso.uniroma2.progettoISPW.bean.IBean;
import it.tommaso.uniroma2.progettoISPW.control.ImportaMetadatiLibroController;
import it.tommaso.uniroma2.progettoISPW.view.OrchestratoreFinestre;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class VistaImportaMetadatiLibro implements VistaPopup, Initializable {

    @FXML
    private TextField fieldTitolo;
    @FXML
    private TextField fieldAutore;
    @FXML
    private TextField fieldEditore;
    @FXML
    private TextField fieldEdizione;
    @FXML
    private TextField fieldISNB;

    private final OrchestratoreFinestre controllerGrafico;
    private final ImportaMetadatiLibroController appController <;
    public VistaImportaMetadatiLibro(OrchestratoreFinestre controller, IBean... beans){
        this.controllerGrafico = controller;
        this.appController = new ImportaMetadatiLibroController();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void clickSuEsci(ActionEvent actionEvent) {
        controllerGrafico.chiudiFinestraPopup(this);
    }

    public void clickSuConferma(ActionEvent actionEvent) {






    }
}
