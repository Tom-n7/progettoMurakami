package it.tommaso.uniroma2.view;


/*
Controller grafico interfaccia lettore del caso d'uso "prenota libro" in modalità che utilizza javaFX.
 */


import it.tommaso.uniroma2.FXApp;
import it.tommaso.uniroma2.bean.BibliotecaBean;
import it.tommaso.uniroma2.control.PrenotaLibroController;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class PLLettoreCGFX  extends CGFX {

    @FXML
    private Button bottoneCentral;

    @FXML
    private Text titolo;

    @FXML
    private ListView<BibliotecaBean> listaBiblioteche = new ListView<>();

    private ReadOnlyObjectProperty<ObservableList<BibliotecaBean>> bibliotecheProperty = new SimpleObjectProperty<>(FXCollections.observableArrayList());

    private PrenotaLibroController appController;



    public void lanciaVista() {

        Scene layoutProdotto = disegnaFinestra("/it.tommaso.uniroma2/plibFXML/ricerca_biblioteca.fxml");


        /*
        Caricamento dati biblioteche che la vista deve mostrare.
         */


        mostraNuovoStage(layoutProdotto);

    }

    public void click(ActionEvent actionEvent) {
        titolo.setText("Ecco i risultati!");
        ((Node) actionEvent.getSource()).fireEvent(new EventoCambioUseCase(EventoCambioUseCase.PRENOTA_LIBRO));
    }



}
