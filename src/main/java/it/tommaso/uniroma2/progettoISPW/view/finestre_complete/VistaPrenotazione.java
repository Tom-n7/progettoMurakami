package it.tommaso.uniroma2.progettoISPW.view.finestre_complete;

import it.tommaso.uniroma2.progettoISPW.bean.*;
import it.tommaso.uniroma2.progettoISPW.control.PrenotaLibroController;
import it.tommaso.uniroma2.progettoISPW.view.OrchestratoreFinestre;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class VistaPrenotazione implements VistaCompleta, Initializable {

    private final OrchestratoreFinestre controllerGrafico;
    private final PrenotaLibroController controllerApplicativo;

    private final SimpleObjectProperty<ObservableList<LibroBean>> listaLibriPrenotazioneProperty;
    private SimpleObjectProperty<PrenotazioneBean> bozzaPrenotazioneProperty;

    public ListView<LibroBean> listaLibri;
    public VBox infoBibliotecaVBox;
    public Label labelNomeBiblioteca;
    public Label labelIndirizzoBiblioteca;
    public Label labelMaxLibriBiblioteca;
    public Label labelOrarioSettimanaleBiblioteca;
    public Label labelNomeLettore;
    public Label labelEmailLettore;

    @FXML
    private HBox listaLibriPrenotazione;
    @FXML
    private StackPane schedaAggiuntaLibro;
    @FXML
    private Button bottoneAggiungiLibro;
    @FXML
    private Button bottoneConferma;
    @FXML
    private Button bottoneEsci;

    public VistaPrenotazione(OrchestratoreFinestre controller, IBean... beans)throws IllegalArgumentException {

        //🥸
        this.controllerGrafico = controller;
        controllerApplicativo = new PrenotaLibroController();
        /*
        Tutte le viste hanno la responsabilità di controllare che i dati necessari alla loro creazione siano forniti
        nel formato corretto.
         */
        PrenotazioneBean prenotazione;
        try {
            prenotazione = (PrenotazioneBean) beans[0];
        } catch (ClassCastException e) {
            String nomeClasseSbagliata = beans[0].getClass().toString();
            throw new IllegalArgumentException("La vista necessita di un'istanza di BibliotecaBean, invece viene fornita classe " + nomeClasseSbagliata);
        }

        bozzaPrenotazioneProperty = new SimpleObjectProperty<>();
        bozzaPrenotazioneProperty.setValue(prenotazione);

        listaLibriPrenotazioneProperty = new SimpleObjectProperty<>(FXCollections.observableArrayList());




    }


    public void clickSuAggiungi(ActionEvent actionEvent) {


    }

    public void clickSuConferma(ActionEvent actionEvent) {
    }

    public void clickSuEsci(ActionEvent actionEvent) {

        controllerGrafico.lanciaVistaCompleta("ricerca_biblioteca");

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        listaLibri.itemsProperty().bind(listaLibriPrenotazioneProperty);

        labelEmailLettore.setText(bozzaPrenotazioneProperty.get().getLettore().getEmail());



    }
}
