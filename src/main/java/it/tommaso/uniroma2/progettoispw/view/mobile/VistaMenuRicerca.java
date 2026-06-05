package it.tommaso.uniroma2.progettoispw.view.mobile;

import it.tommaso.uniroma2.progettoispw.bean.FiltroBibliotecaBean;
import it.tommaso.uniroma2.progettoispw.control.PrenotaLibroController;
import it.tommaso.uniroma2.progettoispw.model.TipoFiltroBiblioteca;
import it.tommaso.uniroma2.progettoispw.view.desktop.OrchestratoreFinestre;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


/*
Vista attraverso la quale il lettore inserisce i criteri di ricerca delle biblioteche.
 */
public class VistaMenuRicerca implements VistaMobilePopup, Initializable {

    public TextField fieldRicerca;
    public VBox VBoxBottoni;

    private final OrchestratoreFinestre controllerGrafico;
    private final PrenotaLibroController controllerApplicativo;

    private final SimpleObjectProperty<FiltroBibliotecaBean> propertyFiltroBiblioteca;

    private FiltroBibliotecaBean filtroProvvisorio;


    public VistaMenuRicerca(OrchestratoreFinestre controllerGrafico, SimpleObjectProperty... properties){

        this.controllerGrafico = controllerGrafico;
        controllerApplicativo = new PrenotaLibroController();


        try {
            propertyFiltroBiblioteca = (SimpleObjectProperty<FiltroBibliotecaBean>) properties[0];
        } catch (ClassCastException e) {
            String nomeClasseSbagliata = properties[0].getClass().toString();
            throw new IllegalArgumentException("La vista necessita di un'istanza di BibliotecaBean, invece viene fornita classe " + nomeClasseSbagliata);
        }

        filtroProvvisorio = new FiltroBibliotecaBean();

    }



    public void clickSuEsci(ActionEvent actionEvent) {
        controllerGrafico.chiudiFinestraPopup( this);
    }

    public void clickSuConferma(ActionEvent actionEvent) {


        filtroProvvisorio.setTestoRicerca(fieldRicerca.getText());
        //passo il filtro bean alla property condivisa con la vista CercaBiblioteca.
        propertyFiltroBiblioteca.set(filtroProvvisorio);
        controllerGrafico.chiudiFinestraPopup(this);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //costruzione strumento selezione criterio ricerca.
        List<String> nomiCriteriRicercaEsistenti = new ArrayList<>(new FiltroBibliotecaBean().getTuttiTipi());
        for(String n: nomiCriteriRicercaEsistenti) {
            //aspetto di ciascun bottone
            Button bottoneCriterio = new Button();
            bottoneCriterio.setText(n);
            //assegno handler bottone criterio
            bottoneCriterio.setOnAction( event -> {
                        fieldRicerca.setPromptText("Cerca per: " + n);
                        filtroProvvisorio.setTipoSelezionato(n);
                    }
            );
            // Non voglio che il tipo "NESSUNO" sia mostrato come selezionabile.
            if(!n.equals("NESSUNO")) {
                VBoxBottoni.getChildren().add(bottoneCriterio);
            }
        }

        //voglio che di base il tipo di filtro sia per nome
        filtroProvvisorio.setTipoSelezionato(TipoFiltroBiblioteca.NOME.toString());
        fieldRicerca.setPromptText("Cerca per: NOME");

    }
}
