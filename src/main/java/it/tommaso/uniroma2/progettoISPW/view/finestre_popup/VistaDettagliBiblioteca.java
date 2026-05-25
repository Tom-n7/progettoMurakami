package it.tommaso.uniroma2.progettoISPW.view.finestre_popup;

import it.tommaso.uniroma2.progettoISPW.view.OrchestratoreFinestre;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class VistaDettagliBiblioteca implements VistaPopup{


    private final OrchestratoreFinestre controller;
    @FXML
    private Button bottoneEsci;
    @FXML
    private Label labelNome;
    @FXML
    private Label labelIndirizzo;
    @FXML
    private Label labelNumeroLibri;
    @FXML
    private Label orarioBiblioteca;

    public VistaDettagliBiblioteca (OrchestratoreFinestre controller){
        this.controller = controller;
    }

    public void clickBottoneEsci(ActionEvent actionEvent) {
        controller.chiudiFinestraPopup(this);
    }
}
