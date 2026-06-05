package it.tommaso.uniroma2.progettoISPW.view.mobile;

import it.tommaso.uniroma2.progettoISPW.bean.LibroBean;
import it.tommaso.uniroma2.progettoISPW.bean.PrenotazioneBean;
import it.tommaso.uniroma2.progettoISPW.control.ImportaMetadatiLibroController;
import it.tommaso.uniroma2.progettoISPW.view.desktop.OrchestratoreFinestre;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class VistaImportaMetadatiLibro implements VistaMobile, Initializable {

    private final  OrchestratoreFinestre controllerGrafico;
    private final ImportaMetadatiLibroController appController;

    private final SimpleObjectProperty<PrenotazioneBean> propertyPrenotazione;
    private final SimpleObjectProperty<ObservableList<LibroBean>> propertyLibriPrenotazione;
    private final SimpleObjectProperty<LibroBean> propertyLibroAcquisito;
    public Button bottoneModTitolo;
    public Label labelTitolo;
    public Label labelAutori;
    public Label labelEdizione;
    public Label labelEditore;
    public Label labelLingua;
    public Label labelISNB;


    public VistaImportaMetadatiLibro(OrchestratoreFinestre controller, SimpleObjectProperty... properties){
        controllerGrafico = controller;
        appController = new ImportaMetadatiLibroController();

        propertyLibroAcquisito = new SimpleObjectProperty<>();

        try {
            propertyPrenotazione = properties[0];
            propertyLibriPrenotazione = properties[1];
        } catch (ClassCastException e) {
            String nomeClasseSbagliata = properties[0].getClass().toString();
            throw new IllegalArgumentException("La vista necessita di un'istanza di BibliotecaBean, invece viene fornita classe " + nomeClasseSbagliata);
        }





    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {

        propertyLibroAcquisito.addListener(((observable, oldValue, newValue) ->{


            labelTitolo.setText(newValue.getTitolo());
            labelEditore.setText(newValue.getEditore());
            labelEdizione.setText(newValue.getEdizione());
            labelAutori.setText(newValue.getAutori().getFirst());
            labelLingua.setText(newValue.getLingua());
            labelISNB.setText(newValue.getCodiceISNB());

        }));

    }

    public void tapSuEsci(ActionEvent actionEvent) {

        ((MobileController) controllerGrafico).lanciaVistaCompletaProperty("dettagli_prenotazione", propertyPrenotazione, propertyLibriPrenotazione);

    }

    public void tapModTitolo(ActionEvent actionEvent) {
    }

    public void tapModAutori(ActionEvent actionEvent) {
    }

    public void tapModEdizione(ActionEvent actionEvent) {
    }

    public void tapModEditore(ActionEvent actionEvent) {
    }

    public void tapModLingua(ActionEvent actionEvent) {
    }

    public void tapModISNB(ActionEvent actionEvent) {
    }

    public void tapSuConferma(ActionEvent actionEvent) {
    }
}
