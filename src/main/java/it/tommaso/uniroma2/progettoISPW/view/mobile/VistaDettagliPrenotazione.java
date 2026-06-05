package it.tommaso.uniroma2.progettoISPW.view.mobile;

import it.tommaso.uniroma2.progettoISPW.bean.BibliotecaBean;
import it.tommaso.uniroma2.progettoISPW.bean.IBean;
import it.tommaso.uniroma2.progettoISPW.bean.LibroBean;
import it.tommaso.uniroma2.progettoISPW.bean.PrenotazioneBean;
import it.tommaso.uniroma2.progettoISPW.control.PrenotaLibroController;
import it.tommaso.uniroma2.progettoISPW.exception.RegoleBibliotecaException;
import it.tommaso.uniroma2.progettoISPW.view.desktop.OrchestratoreFinestre;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class VistaDettagliPrenotazione implements VistaMobile, Initializable {

    private final OrchestratoreFinestre controllerGrafico;
    private final PrenotaLibroController controllerApplicativo;

    private final SimpleObjectProperty<BibliotecaBean> propertyBibliotecaPrenotazione;

    private final SimpleObjectProperty<ObservableList<LibroBean>> propertyLibriPrenotazione;
    private final SimpleObjectProperty<PrenotazioneBean> propertyPrenotazione;



    public Label labelNomeBiblioteca;
    public Label labelIndirizzoBiblioteca;
    public Label labelMaxLibriBiblioteca;
    public Label labelOrarioSettimanaleBiblioteca;
    public ListView<LibroBean> listViewLibri;


    public VistaDettagliPrenotazione(OrchestratoreFinestre controllerGrafico, SimpleObjectProperty... properties){
        this.controllerGrafico = controllerGrafico;
        controllerApplicativo = new PrenotaLibroController();

        propertyBibliotecaPrenotazione = new SimpleObjectProperty<>();

        try {
            propertyPrenotazione = properties[0];
            propertyLibriPrenotazione = properties[1];
        } catch (ClassCastException e) {
            String nomeClasseSbagliata = properties[0].getClass().toString();
            throw new IllegalArgumentException("La vista necessita di un'istanza di BibliotecaBean, invece viene fornita classe " + nomeClasseSbagliata);
        }

        propertyBibliotecaPrenotazione.set(propertyPrenotazione.get().getBiblioteca());

    }





    @Override
    public void initialize(URL location, ResourceBundle resources) {

        labelNomeBiblioteca.setText(propertyBibliotecaPrenotazione.get().getNome());
        labelIndirizzoBiblioteca.setText(propertyBibliotecaPrenotazione.get().getIndirizzo());
        labelMaxLibriBiblioteca.setText(propertyBibliotecaPrenotazione.get().getRegolePrenotazione());

        //bind listview ai libri della prenotazione.
        listViewLibri.itemsProperty().bind(propertyLibriPrenotazione);

    }

    public void tapSuEsci(ActionEvent actionEvent) {
        controllerGrafico.lanciaVistaCompleta("ricerca_biblioteca");
    }

    public void tapSuAggiungi(ActionEvent actionEvent) {
        ((MobileController) controllerGrafico).lanciaVistaCompletaProperty("importa_metadati_libro", propertyPrenotazione, propertyLibriPrenotazione);
    }

    public void tapSuConferma(ActionEvent actionEvent) {

        try {
            if (!propertyLibriPrenotazione.get().isEmpty()) {
                controllerApplicativo.validaPrenotazione(propertyPrenotazione.get());
            }
        } catch (RegoleBibliotecaException e) {
            throw new RuntimeException(e);
        }

    }
}
