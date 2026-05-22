package it.tommaso.uniroma2.progettoISPW.init;


import it.tommaso.uniroma2.progettoISPW.view.ControllerGrafico;
import it.tommaso.uniroma2.progettoISPW.view.VistaCompleta;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class VistaMenuPrincipale extends StackPane implements VistaCompleta {

    private final ControllerGrafico CONTROLLER;

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
        CONTROLLER.lanciaVistaCompleta("ricerca_biblioteca");
    }

    @FXML
    public void clickGestisciLibreria(ActionEvent e){

    }

    @Override
    public FXMLLoader ottieniRadice() {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("init_layout.fxml"));
        loader.setRoot(this);
        loader.setController(this);

        return loader;
    }
}
