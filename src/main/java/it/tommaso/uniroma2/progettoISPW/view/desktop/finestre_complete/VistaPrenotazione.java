package it.tommaso.uniroma2.progettoISPW.view.desktop.finestre_complete;

import it.tommaso.uniroma2.progettoISPW.bean.*;
import it.tommaso.uniroma2.progettoISPW.control.PrenotaLibroController;
import it.tommaso.uniroma2.progettoISPW.view.desktop.OrchestratoreFinestre;
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
    private final SimpleObjectProperty<PrenotazioneBean> bozzaPrenotazioneProperty;
    private final SimpleObjectProperty<LibroBean> libroDaAggiungereProperty;

    @FXML
    private ListView<LibroBean> listaLibri;

    //dettagli biblioteca
    @FXML
    private VBox infoBibliotecaVBox;
    @FXML
    private Label labelNomeBiblioteca;
    @FXML
    private Label labelIndirizzoBiblioteca;
    @FXML
    private Label labelMaxLibriBiblioteca;
    @FXML
    private Label labelOrarioSettimanaleBiblioteca;

    //avatar
    @FXML
    private Label labelNomeLettore;
    @FXML
    private Label labelEmailLettore;

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
        controllerGrafico.lanciaVistaCompleta("menu_principale");


        bozzaPrenotazioneProperty = new SimpleObjectProperty<>();
        bozzaPrenotazioneProperty.setValue(prenotazione);

        listaLibriPrenotazioneProperty = new SimpleObjectProperty<>(FXCollections.observableArrayList());

        /*
        questa prorpietà contiene il libro che va aggiunto alla prenotazione, viene inizializzato il valore contenuto.
         */
        libroDaAggiungereProperty = new SimpleObjectProperty<>();
        libroDaAggiungereProperty.setValue(new LibroBean());


    }


    /*
    Quando l'utente clicca su
     */
    public void clickSuAggiungi(ActionEvent actionEvent) {

        controllerGrafico.lanciaVistaPopup("importa_metadati_libro",libroDaAggiungereProperty);


    }

    public void clickSuConferma(ActionEvent actionEvent) {
        controllerApplicativo.validaPrenotazione(bozzaPrenotazioneProperty.get());
        controllerGrafico.lanciaVistaCompleta("menu_principale");



    }

    public void clickSuEsci(ActionEvent actionEvent) {
        controllerApplicativo.eliminaPrenotazione(bozzaPrenotazioneProperty.get());
        controllerGrafico.lanciaVistaCompleta("menu_principale");


    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        listaLibri.itemsProperty().bind(listaLibriPrenotazioneProperty);

        //quando la vista importa metadati libro rinnova il valore della property, vuol dire che il lettore
        //ha confermato il libro inserito, quindi questo va aggiunto alla prenotazione.
        libroDaAggiungereProperty.addListener((obs,val,newval)->{
            LibroBean nuovoLibro = newval;
            PrenotazioneBean prenotazioneBean = bozzaPrenotazioneProperty.get();
            prenotazioneBean.addLibro(nuovoLibro);
            bozzaPrenotazioneProperty.set(
                   controllerApplicativo.aggiungiLibroAllaPrenotazione(prenotazioneBean,nuovoLibro)
           );

            //pulisco la lista libri e la aggiorno.
            listaLibriPrenotazioneProperty.set(FXCollections.observableArrayList());
            listaLibriPrenotazioneProperty.get().addAll(bozzaPrenotazioneProperty.get().getLibri());


        });


        //inizializzazione avatar
        labelEmailLettore.setText("Email: " + bozzaPrenotazioneProperty.get().getLettore().getEmail());
        labelNomeLettore.setText(("Nome: "+ bozzaPrenotazioneProperty.get().getLettore().getNome()));

        //inizializzazione dettagli biblioteca
        labelNomeBiblioteca.setText("Nome: " + bozzaPrenotazioneProperty.get().getBiblioteca().getNome());
        labelIndirizzoBiblioteca.setText("Indirizzo: " + bozzaPrenotazioneProperty.get().getBiblioteca().getIndirizzo());
        labelMaxLibriBiblioteca.setText("Max libri prenotazione: " + bozzaPrenotazioneProperty.get().getBiblioteca().getRegolePrenotazione());



    }
}
