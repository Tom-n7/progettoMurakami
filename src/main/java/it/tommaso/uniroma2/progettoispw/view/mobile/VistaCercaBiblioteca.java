package it.tommaso.uniroma2.progettoispw.view.mobile;

import it.tommaso.uniroma2.progettoispw.bean.*;
import it.tommaso.uniroma2.progettoispw.control.PrenotaLibroController;
import it.tommaso.uniroma2.progettoispw.view.desktop.OrchestratoreFinestre;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ResourceBundle;

public class VistaCercaBiblioteca implements VistaMobile, Initializable {

    private final OrchestratoreFinestre controllerGrafico;
    private final PrenotaLibroController controllerApplicativo;

    private final SimpleObjectProperty<ObservableList<BibliotecaBean>> propertyBibliotecheCaricate;
    private final SimpleObjectProperty<BibliotecaBean> propertyBibliotecaScelta;

    private final SimpleObjectProperty<FiltroBibliotecaBean> propertyFiltroBiblioteca;
    private final ChangeListener<BibliotecaBean> handlerSelezioneBiblioteca = new ChangeListener<BibliotecaBean>() {
        @Override
        public void changed(ObservableValue<? extends BibliotecaBean> observable, BibliotecaBean oldValue, BibliotecaBean newValue) {
            propertyBibliotecaScelta.setValue(listViewBiblioteche.getSelectionModel().getSelectedItem());

            bottoneRicerca.setVisible(false);
            bottoneConferma.setVisible(true);
            bottoneDeselezione.setVisible(true);
        }
    };

    private final SimpleObjectProperty<PrenotazioneBean> propertyBozzaPrenotazione;


    public HBox HBoxAlta;
    public ListView<BibliotecaBean> listViewBiblioteche;
    public Button bottoneDeselezione;
    public Button bottoneRicerca;
    public Button bottoneConferma;

    public VistaCercaBiblioteca(OrchestratoreFinestre controllerGrafico, IBean... beans) {
        this.controllerGrafico = controllerGrafico;
        this.controllerApplicativo = new PrenotaLibroController();

        this.propertyBibliotecheCaricate = new SimpleObjectProperty<>(FXCollections.observableArrayList());
        this.propertyBibliotecaScelta = new SimpleObjectProperty<>();
        this.propertyBozzaPrenotazione = new SimpleObjectProperty<>();
        this.propertyFiltroBiblioteca = new SimpleObjectProperty<>();
    }

    public void clickSuEsci(ActionEvent actionEvent) {
        controllerGrafico.lanciaVistaCompleta("menu_principale");
    }

    public void tapSuCerca(ActionEvent actionEvent) {
        //lancio il menù ricerca bibliteca e fornisco la property che contiene il filtro della biblioteca
        controllerGrafico.lanciaVistaPopup("menu_ricerca", propertyFiltroBiblioteca);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //la listView cambia quando cambia la property contenente le biblioteche caricate.
        listViewBiblioteche.itemsProperty().bind(propertyBibliotecheCaricate);
        listViewBiblioteche.getSelectionModel().selectedItemProperty().addListener(handlerSelezioneBiblioteca);

        //listener che, nel momento in cui il lettore conferma i criteri di ricerca, richiede al sistema di caricare le biblioteche
        //e mostra i risultati.
        propertyFiltroBiblioteca.addListener((obs, old, newval)->{
            propertyBibliotecheCaricate.get().clear();
            propertyBibliotecheCaricate.get().addAll(
                    controllerApplicativo.caricaBibliotecheRegistrate(newval)
            );

        });

        //quando non si è ancora selezionata una biblioteca, i bottoni sono nascosti.
        bottoneConferma.setVisible(false);
        bottoneDeselezione.setVisible(false);

    }

    public void tapSuDeselezione(ActionEvent actionEvent) {
        propertyBibliotecaScelta.setValue(null);
        bottoneDeselezione.setVisible(false);
        bottoneConferma.setVisible(false);
        bottoneRicerca.setVisible(true);
    }


    /*
    Il lettore sceglie la biblioteca, la vista richiede quindi la creazione della bozza di prenotazione,
     */
    public void tapSuConferma(ActionEvent actionEvent) {

        if(propertyBibliotecaScelta.get() != null){

            propertyBozzaPrenotazione.setValue(controllerApplicativo.bozzaPrenotazione(propertyBibliotecaScelta.get()));
            ((MobileController)this.controllerGrafico).lanciaVistaCompletaProperty("dettagli_prenotazione", propertyBozzaPrenotazione,
                    (new SimpleObjectProperty<>(FXCollections.observableArrayList()))
            );

        }else {
            //questo meglio trasformarlo in eccezione.
        }


    }
}
