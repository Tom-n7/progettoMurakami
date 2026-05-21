package it.tommaso.uniroma2.progettoISPW.init;


import it.tommaso.uniroma2.progettoISPW.view.ControllerGrafico;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class VistaMenuPrincipale implements Initializable {

    private final ControllerGrafico CONTROLLER;

    @FXML
    private Text c;

    @FXML
    private  Button bottonePrenotazione;

    @FXML
    private Button bottoneLibreria;

    public VistaMenuPrincipale(ControllerGrafico controller) {
        CONTROLLER = controller;
    }

    //Gestori evento iaterazione con bottoni.
    @FXML
    public void clickNuovaPrenotazione(ActionEvent e ){
        CONTROLLER.lanciaVista("ricerca_biblioteca");
    }

    @FXML
    public void clickGestisciLibreria(ActionEvent e){

    }







    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
