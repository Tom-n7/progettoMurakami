package it.tommaso.uniroma2.progettoISPW.view.mobile;

import it.tommaso.uniroma2.progettoISPW.bean.IBean;
import it.tommaso.uniroma2.progettoISPW.view.desktop.OrchestratoreFinestre;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class VistaMenuPrincipale implements VistaMobile {
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

    public VistaMenuPrincipale(OrchestratoreFinestre controllerGrafico, IBean... beans){}

    public void clickSuPrenotazione(ActionEvent actionEvent) {
    }

    public void clickSuEsci(ActionEvent actionEvent) {
    }
}
