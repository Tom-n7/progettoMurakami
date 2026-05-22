package it.tommaso.uniroma2.progettoISPW.view.finestre_complete;

import it.tommaso.uniroma2.progettoISPW.bean.BibliotecaBean;
import it.tommaso.uniroma2.progettoISPW.bean.FiltroBibliotecaBean;
import it.tommaso.uniroma2.progettoISPW.model.TipoFiltroBiblioteca;
import it.tommaso.uniroma2.progettoISPW.view.DesktopController;
import it.tommaso.uniroma2.progettoISPW.view.OrchestratoreFinestre;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

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
    private ListView listaBibliotecheVisibile;

    private final OrchestratoreFinestre controller;
    private SimpleObjectProperty<FiltroBibliotecaBean> propertyFiltroBiblioteca;
    private SimpleObjectProperty<List<BibliotecaBean>> propertyBibliotecheCaricate;
    private SimpleObjectProperty<BibliotecaBean> propertyBibliotecaScelta;

    public VistaCercaBiblioteca(OrchestratoreFinestre controller) {
        this.controller = controller;
    }


    public void clickSuCerca(ActionEvent actionEvent) {

    }

    public void clickSuConfermaBiblioteca(ActionEvent actionEvent) {
    }

    public void clickSuEsci(ActionEvent actionEvent) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        propertyBibliotecheCaricate = new SimpleObjectProperty<>(FXCollections.observableArrayList());
        propertyFiltroBiblioteca = new SimpleObjectProperty<>(new FiltroBibliotecaBean());
        propertyBibliotecaScelta = new SimpleObjectProperty<>();



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
            criteriRicercaHBox.getChildren().add(bottoneCriterio);
        }
        //di default la ricerca è per nome.
        propertyFiltroBiblioteca.get().setTipoSelezionato(TipoFiltroBiblioteca.NOME.toString());
        criterioRicercaTextField.setPromptText("Cerca per: " + TipoFiltroBiblioteca.NOME);
    }
}
