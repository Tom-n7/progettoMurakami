package it.tommaso.uniroma2.view;


/*
Controller grafico interfaccia lettore del caso d'uso "prenota libro" in modalità che utilizza javaFX.
 */


import it.tommaso.uniroma2.bean.BibliotecaBean;
import it.tommaso.uniroma2.bean.FiltroBibliotecaBean;
import it.tommaso.uniroma2.control.PrenotaLibroController;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class PLLettoreCGFX  extends CGFX {

    //Bottone "cerca", textfield con input del lettore e relativo controller per OnAction



    @FXML
    private Button ricercaButton;

    @FXML
    private TextField criterioRicercaTextField;

    /*
    Viene impostato come filtro l'input del lettore, che influisce sulle biblioteche visibili seconda del
    criterio selezionato e del testo immesso.
    */
    @FXML
    private void clickSuCerca(ActionEvent e){

        /*
        Qui la lista filtrata viene aggiornata, a partire dalla lista delle biblioteche registrate, a cui viene
        applicato il filtro immesso dal lettore sul criterio selezionato.
        */

    }

    @FXML
    private HBox criteriRicercaHBox;

    @FXML
    private Text titolo;

    @FXML
    private ListView<BibliotecaBean> listaBibliotecheVisibile;


    private ReadOnlyObjectProperty<List<String>> tipiFiltroProperty;
    private ReadOnlyObjectProperty<ObservableList<BibliotecaBean>> bibliotecheProperty;
    private PrenotaLibroController appController;



    public void lanciaVista() {

        Scene layoutProdotto = disegnaFinestra("/it.tommaso.uniroma2/plibFXML/ricerca_biblioteca.fxml");



        //((HBox) layoutProdotto.lookup("#criteriRicercaHBox")).getChildren().add(new Rectangle(10,10, Color.GOLD));

        /*
        Caricamento dati biblioteche che la vista deve mostrare.
         */


        mostraNuovoStage(layoutProdotto);



    }

    public void click(ActionEvent actionEvent) {
        titolo.setText("Ecco i risultati!");
        ((Node) actionEvent.getSource()).fireEvent(new EventoCambioUseCase(EventoCambioUseCase.PRENOTA_LIBRO));
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        super.initialize(location, resources);



        //creo proprietà contenente tutte le biblioteche registrate nel sistema.
        bibliotecheProperty = new SimpleObjectProperty<>(FXCollections.observableArrayList());

        tipiFiltroProperty = new SimpleObjectProperty<>(new ArrayList<String>());
        tipiFiltroProperty.get().addAll(FiltroBibliotecaBean.getTuttiTipi());



        for(String s : tipiFiltroProperty.get()){
            Button bottoneCriterio = new Button(s);
            bottoneCriterio.setPrefHeight(26);

            bottoneCriterio.setOnAction( event -> {
                criterioRicercaTextField.setText("Cerca per: " + s);

                }
            );



            criteriRicercaHBox.getChildren().add(bottoneCriterio);
        }


    }


}
