package it.tommaso.uniroma2.progettoISPW.init;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class VistaMenuPrincipale implements Initializable {


    @FXML
    private Text c;

    @FXML
    private  Button bottonePrenotazione;

    @FXML
    private Button bottoneLibreria;


    public final  int ESEMPIOINT;

    public VistaMenuPrincipale(int esempioint) {
        ESEMPIOINT = esempioint;
    }

    //Gestori evento iaterazione con bottoni.
    @FXML
    public void clickNuovaPrenotazione(ActionEvent e ){

    }

    @FXML
    public void clickGestisciLibreria(ActionEvent e){

    }







    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
