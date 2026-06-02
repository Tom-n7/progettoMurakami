package it.tommaso.uniroma2.progettoISPW.view.finestre_complete;


import it.tommaso.uniroma2.progettoISPW.bean.IBean;
import it.tommaso.uniroma2.progettoISPW.view.OrchestratoreFinestre;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class VistaMenuPrincipale implements VistaCompleta {

    private final OrchestratoreFinestre controllerGrafico;

    @FXML
    private  Button bottonePrenotazione;

    @FXML
    private Button bottoneLibreria;

    public VistaMenuPrincipale(OrchestratoreFinestre controller, IBean... beans) {
        controllerGrafico = controller;
    }

    //Gestori evento iaterazione con bottoni.
    @FXML
    public void clickNuovaPrenotazione(ActionEvent e ){
        controllerGrafico.lanciaVistaCompleta("ricerca_biblioteca");
    }

    @FXML
    public void clickGestisciLibreria(ActionEvent e){

    }

}
