package it.tommaso.uniroma2.progettoISPW.view;

import it.tommaso.uniroma2.progettoISPW.bean.BibliotecaBean;
import it.tommaso.uniroma2.progettoISPW.bean.FiltroBibliotecaBean;
import javafx.beans.NamedArg;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class VistaCercaBiblioteca extends StackPane implements VistaCompleta, Initializable {

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

    private final ControllerGrafico controller;

    public VistaCercaBiblioteca(ControllerGrafico controller) {
        this.controller = controller;
    }

    public FXMLLoader ottieniRadice(){
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("ricerca_biblioteca.fxml"));
        loader.setRoot(this);
        loader.setControllerFactory(c->{
            return this;
        });

        return loader;
    }

    public void clickSuCerca(ActionEvent actionEvent) {
        if (controller != null){
            System.out.println("Che ti aspettavi?");
        }
    }

    public void clickSuConfermaBiblioteca(ActionEvent actionEvent) {
    }

    public void clickSuEsci(ActionEvent actionEvent) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        List<String> nomiCriteriRicercaEsistenti = new ArrayList<>(new FiltroBibliotecaBean().getTuttiTipi());

        for(String n: nomiCriteriRicercaEsistenti) {

            Button bottoneCriterio = new Button();
            bottoneCriterio.setText(n);



            criteriRicercaHBox.getChildren().add(bottoneCriterio);

        }

    }
}
