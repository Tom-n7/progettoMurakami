package it.tommaso.uniroma2.progettoISPW.view.finestre_complete;


import it.tommaso.uniroma2.progettoISPW.bean.IBean;
import it.tommaso.uniroma2.progettoISPW.view.DesktopController;
import it.tommaso.uniroma2.progettoISPW.view.OrchestratoreFinestre;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

public class VistaMenuPrincipale implements VistaCompleta {

    private final OrchestratoreFinestre CONTROLLER;

    @FXML
    private  Button bottonePrenotazione;

    @FXML
    private Button bottoneLibreria;

    public VistaMenuPrincipale(OrchestratoreFinestre controller, IBean... beans) {
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

}
