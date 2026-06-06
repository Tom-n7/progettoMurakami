package it.tommaso.uniroma2.progettoispw.view.desktop.finestre_complete;

import it.tommaso.uniroma2.progettoispw.bean.BibliotecaBean;
import it.tommaso.uniroma2.progettoispw.bean.FiltroBibliotecaBean;
import it.tommaso.uniroma2.progettoispw.bean.IBean;
import it.tommaso.uniroma2.progettoispw.bean.PrenotazioneBean;
import it.tommaso.uniroma2.progettoispw.control.PrenotaLibroController;
import it.tommaso.uniroma2.progettoispw.model.TipoFiltroBiblioteca;
import it.tommaso.uniroma2.progettoispw.view.desktop.OrchestratoreFinestre;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class VistaCercaBiblioteca implements VistaCompleta, Initializable {

    @FXML
    private HBox criteriRicercaHBox;
    @FXML
    private  Button bottoneRicerca;
    @FXML
    private TextField criterioRicercaTextField;
    @FXML
    private Button bottoneConfermaBiblioteca;
    @FXML
    private Button BottoneEsci;
    @FXML
    private ListView<BibliotecaBean> listaBibliotecheVisibile;

    private final OrchestratoreFinestre controllerGrafico;
    private final PrenotaLibroController controllerApplicativo;
    private SimpleObjectProperty<FiltroBibliotecaBean> propertyFiltroBiblioteca;
    private SimpleObjectProperty<ObservableList<BibliotecaBean>> propertyBibliotecheCaricate;
    private SimpleObjectProperty<BibliotecaBean> propertyBibliotecaScelta;

    public VistaCercaBiblioteca(OrchestratoreFinestre controller, IBean... beans) {
        this.controllerGrafico = controller;
        this.controllerApplicativo = new PrenotaLibroController();
    }


    //handler tasto ricerca usato dal lettore previo inserimento criterio.
    public void clickSuCerca(ActionEvent actionEvent) {

        String testoInserito = criterioRicercaTextField.getText();

        propertyFiltroBiblioteca.get().setTestoRicerca(testoInserito);
        //elimino eventuali biblioteche precendentemente caricate.
        propertyBibliotecheCaricate.get().clear();

        propertyBibliotecheCaricate.get().addAll(
                controllerApplicativo.caricaBibliotecheRegistrate(propertyFiltroBiblioteca.get()));
    }

    public void clickSuConfermaBiblioteca(ActionEvent actionEvent) throws InterruptedException {

        /*
        A seguito della scelta del lettore, il sistema crea una bozza della prenotazione, che restituisce in
        forma di bean alla vista, la vista quindi fornisce il bean della nuova prenotazione.
         */
        PrenotazioneBean bozzaPrenotazione = controllerApplicativo.bozzaPrenotazione(propertyBibliotecaScelta.get());
        this.controllerGrafico.lanciaVistaCompleta("dettagli_prenotazione", bozzaPrenotazione);

    }

    public void clickSuEsci(ActionEvent actionEvent) {
        controllerGrafico.lanciaVistaCompleta("menu_principale");
    }

    private final ChangeListener<BibliotecaBean> handlerSelezioneBiblioteca = new ChangeListener<BibliotecaBean>() {
        @Override
        public void changed(ObservableValue<? extends BibliotecaBean> observable, BibliotecaBean oldValue, BibliotecaBean newValue) {
           propertyBibliotecaScelta.setValue(listaBibliotecheVisibile.getSelectionModel().getSelectedItem());
        }
    };

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        propertyBibliotecheCaricate = new SimpleObjectProperty<>(FXCollections.observableArrayList());
        propertyFiltroBiblioteca = new SimpleObjectProperty<>(new FiltroBibliotecaBean());
        propertyBibliotecaScelta = new SimpleObjectProperty<>();

        //faccio bind della lista delle biblioteche con la ListView.
        listaBibliotecheVisibile.itemsProperty().bind(propertyBibliotecheCaricate);

        listaBibliotecheVisibile.getSelectionModel().selectedItemProperty().addListener(handlerSelezioneBiblioteca);


        //costruzione strumento selezione criterio ricerca.
        List<String> nomiCriteriRicercaEsistenti = new ArrayList<>(new FiltroBibliotecaBean().getTuttiTipi());
        for(String n: nomiCriteriRicercaEsistenti) {
            //aspetto di ciascun bottone
            Button bottoneCriterio = new Button();
            bottoneCriterio.setText(n);
            //assegno handler bottone criterio
            bottoneCriterio.setOnAction( event -> {
                        criterioRicercaTextField.setPromptText("Cerca per: " + n);
                        propertyFiltroBiblioteca.get().setTipoSelezionato(n);
                    }
            );
            // Non voglio che il tipo "NESSUNO" sia mostrato come selezionabile.
            if(!n.equals("NESSUNO")) {
                criteriRicercaHBox.getChildren().add(bottoneCriterio);
            }
        }
        //di default la ricerca è per nome.
        propertyFiltroBiblioteca.get().setTipoSelezionato(TipoFiltroBiblioteca.NOME.toString());
        criterioRicercaTextField.setPromptText("Cerca per: " + TipoFiltroBiblioteca.NOME);

    }
}
