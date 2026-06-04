package it.tommaso.uniroma2.progettoISPW.view.finestre_complete;


import it.tommaso.uniroma2.progettoISPW.bean.IBean;
import it.tommaso.uniroma2.progettoISPW.bean.PrenotazioneBean;
import it.tommaso.uniroma2.progettoISPW.control.MenuPrincipaleController;
import it.tommaso.uniroma2.progettoISPW.view.OrchestratoreFinestre;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class VistaMenuPrincipale implements VistaCompleta, Initializable {


    private SimpleObjectProperty<ObservableList<PrenotazioneBean>> propertyRichiestePrenotazioni;

    private final OrchestratoreFinestre controllerGrafico;
    private final MenuPrincipaleController controllerApplivativo;
    @FXML
    private ListView<PrenotazioneBean> listaPrenotazioni;
    @FXML
    private  Button bottonePrenotazione;
    @FXML
    private Button bottoneLibreria;

    public VistaMenuPrincipale(OrchestratoreFinestre controller, IBean... beans) {

        controllerGrafico = controller;
        controllerApplivativo = new MenuPrincipaleController();
    }

    //Gestori evento iaterazione con bottoni.
    @FXML
    public void clickNuovaPrenotazione(ActionEvent e ){
        controllerGrafico.lanciaVistaCompleta("ricerca_biblioteca");
    }

    @FXML
    public void clickGestisciLibreria(ActionEvent e){

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        propertyRichiestePrenotazioni = new SimpleObjectProperty<>(FXCollections.observableArrayList());

        listaPrenotazioni.itemsProperty().bind(propertyRichiestePrenotazioni);

        propertyRichiestePrenotazioni.get().addAll(
                controllerApplivativo.ottieniPrenotazioneUtente()
        );





    }
}
