package it.tommaso.uniroma2.progettoISPW.view.finestre_complete;

import it.tommaso.uniroma2.progettoISPW.bean.*;
import it.tommaso.uniroma2.progettoISPW.control.PrenotaLibroController;
import it.tommaso.uniroma2.progettoISPW.model.Lettore;
import it.tommaso.uniroma2.progettoISPW.model.Prenotazione;
import it.tommaso.uniroma2.progettoISPW.view.DesktopController;
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
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class VistaPrenotazione implements VistaCompleta, Initializable {

    private final OrchestratoreFinestre controller;
    private final BibliotecaBean bibliotecaSelezionata;


    private final SimpleObjectProperty<BibliotecaBean> bibliotecaSceltaProperty;
    private final SimpleObjectProperty<LettoreBean> lettoreProperty;
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

    private double altezzaScheda;
    private double larghezzaScheda;

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

    public VistaPrenotazione(OrchestratoreFinestre controller, IBean... beans)throws IllegalArgumentException{

        //🥸
        this.controller = controller;

        /*
        Tutte le viste hanno la responsabilità di controllare che i dati necessari alla loro creazione siano forniti
        nel formato corretto.
         */
        try {
            this.bibliotecaSelezionata = (BibliotecaBean) beans[0];
        }catch (ClassCastException e){
            throw new IllegalArgumentException("La vista necessita di un'istanza di BibliotecaBean");
        }

        lettoreProperty = new SimpleObjectProperty<>();
        bibliotecaSceltaProperty = new SimpleObjectProperty<>();
        listaLibriPrenotazioneProperty = new SimpleObjectProperty<>(FXCollections.observableArrayList());
        bozzaPrenotazioneProperty = new SimpleObjectProperty<>();

        bozzaPrenotazioneProperty.setValue((new PrenotaLibroController()).bozzaPrenotazione(bibliotecaSelezionata));



    }


    public void clickSuAggiungi(ActionEvent actionEvent) {


    }

    public void clickSuConferma(ActionEvent actionEvent) {
    }

    public void clickSuEsci(ActionEvent actionEvent) {

        controller.lanciaVistaCompleta("ricerca_biblioteca");

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        listaLibri.itemsProperty().bind(listaLibriPrenotazioneProperty);

    }
}
