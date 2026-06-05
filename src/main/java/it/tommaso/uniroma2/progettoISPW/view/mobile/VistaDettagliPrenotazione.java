package it.tommaso.uniroma2.progettoISPW.view.mobile;

import it.tommaso.uniroma2.progettoISPW.bean.BibliotecaBean;
import it.tommaso.uniroma2.progettoISPW.bean.IBean;
import it.tommaso.uniroma2.progettoISPW.bean.PrenotazioneBean;
import it.tommaso.uniroma2.progettoISPW.control.PrenotaLibroController;
import it.tommaso.uniroma2.progettoISPW.view.desktop.OrchestratoreFinestre;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class VistaDettagliPrenotazione implements VistaMobile, Initializable {

    private final OrchestratoreFinestre controllerGrafico;
    private final PrenotaLibroController controllerApplicativo;

    private final SimpleObjectProperty<BibliotecaBean> propertyBibliotecaPrenotazione;



    public Label labelNomeBiblioteca;
    public Label labelIndirizzoBiblioteca;
    public Label labelMaxLibriBiblioteca;
    public Label labelOrarioSettimanaleBiblioteca;


    public VistaDettagliPrenotazione(OrchestratoreFinestre controllerGrafico, IBean... beans){
        this.controllerGrafico = controllerGrafico;
        controllerApplicativo = new PrenotaLibroController();

        propertyBibliotecaPrenotazione = new SimpleObjectProperty<>();

        try {
            propertyBibliotecaPrenotazione.setValue((BibliotecaBean) beans[0]);
        } catch (ClassCastException e) {
            String nomeClasseSbagliata = beans[0].getClass().toString();
            throw new IllegalArgumentException("La vista necessita di un'istanza di BibliotecaBean, invece viene fornita classe " + nomeClasseSbagliata);
        }

    }





    @Override
    public void initialize(URL location, ResourceBundle resources) {

        labelNomeBiblioteca.setText(propertyBibliotecaPrenotazione.get().getNome());
        labelIndirizzoBiblioteca.setText(propertyBibliotecaPrenotazione.get().getIndirizzo());
        labelMaxLibriBiblioteca.setText(propertyBibliotecaPrenotazione.get().getRegolePrenotazione());


    }

    public void tapSuEsci(ActionEvent actionEvent) {
        controllerGrafico.lanciaVistaCompleta("ricerca_biblioteca");
    }

    public void tapSuAggiungi(ActionEvent actionEvent) {
    }

    public void tapSuConferma(ActionEvent actionEvent) {
    }
}
