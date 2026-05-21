package it.tommaso.uniroma2.view;


/*
Controller grafico interfaccia lettore del caso d'uso "prenota libro" in modalità che utilizza javaFX.
 */


import it.tommaso.uniroma2.bean.BibliotecaBean;
import it.tommaso.uniroma2.bean.FiltroBibliotecaBean;
import it.tommaso.uniroma2.control.PrenotaLibroController;
import it.tommaso.uniroma2.model.TipoFiltroBiblioteca;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class PLLettoreCGFX  extends CGFX {


    public Button bottoneConfermaBiblioteca;
    public Button BottoneEsci;
    //Bottone "cerca", textfield con input del lettore e relativo controller per OnAction
    @FXML
    private Button bottoneRicerca;

    @FXML
    private TextField criterioRicercaTextField;

    /*
    definisce come filtro l'input del lettore, che influisce sulle biblioteche visibili seconda del
    criterio selezionato e del testo immesso.
    */
    @FXML
    private void clickSuCerca(ActionEvent e){
        String queryLettore = criterioRicercaTextField.getText();
        if(!queryLettore.isBlank()){
            filtroBibliotecaBeanProperty.get().setTestoRicerca(queryLettore);
        }

        bibliotecheProperty.get().setAll(plc.caricaBibliotecheRegistrate(filtroBibliotecaBeanProperty.get()));
    }

    /*
    Handler cambiamento oggetto selezionato nella ListView.
    Nello specifico la biblioteca selezionata dal lettore viene salvata e utilizzata quando il lettore conferma la scelta.
     */
    private ChangeListener<BibliotecaBean> handlerSelezioneBiblioteca = new ChangeListener<BibliotecaBean>() {
        @Override
        public void changed(ObservableValue<? extends BibliotecaBean> observable, BibliotecaBean oldValue, BibliotecaBean newValue) {
            bibliotecaScelta = listaBibliotecheVisibile.getSelectionModel().getSelectedItem();
        }
    };

    @FXML
    private void clickSuConfermaBiblioteca(ActionEvent e){



        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/it.tommaso.uniroma2/plibFXML/provvisorioSceltaBiblioteca.fxml"));


        Stage stage = new Stage();
        try{

            stage.setScene(new Scene(loader.load()));
            ((FinestraProvvisoriaSceltaBiblioteca)loader.getController()).setBiblioteca(bibliotecaScelta);




            stage.show();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

    }

    @FXML
    private void clickSuEsci(ActionEvent e){

    }

    @FXML
    private HBox criteriRicercaHBox;

    @FXML
    private Text titolo;

    @FXML
    private ListView<BibliotecaBean> listaBibliotecheVisibile;


    private ReadOnlyObjectProperty<List<String>> tipiFiltroProperty;
    private ReadOnlyObjectProperty<ObservableList<BibliotecaBean>> bibliotecheProperty;
    //l'inserimento di una lista filtrata è da valutare, perchè le biblioteche arrivano già filtrate dai criteri inseriti dal lettore.
    //scelto una prorpietà NON readonly così che il bottone criterio e bottone ricerca lo modifichibo in due momenti diversi, da valutare.
    private ObjectProperty<FiltroBibliotecaBean> filtroBibliotecaBeanProperty;

    private PrenotaLibroController plc;

    private BibliotecaBean bibliotecaScelta;



    public void lanciaVista() {

        Scene layoutProdotto = disegnaFinestra("/it.tommaso.uniroma2/plibFXML/ricerca_biblioteca.fxml");
        mostraNuovoStage(layoutProdotto);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        super.initialize(location, resources);


        this.plc = new PrenotaLibroController();

        //creo proprietà contenente le biblioteche ottenute dalla view quando invia la richiesta al controller.
        bibliotecheProperty = new SimpleObjectProperty<>(FXCollections.observableArrayList());
        //faccio bind della lista delle biblioteche con la ListView.
        listaBibliotecheVisibile.itemsProperty().bind(bibliotecheProperty);

        //init di vettore contenete tutti i criteri selezionabili dal lettore per cercare la biblioteca.
        tipiFiltroProperty = new SimpleObjectProperty<>(new ArrayList<String>());
        tipiFiltroProperty.get().addAll(FiltroBibliotecaBean.getTuttiTipi());

        //il filtro viene costruito senza specificare valore dei campi, se rimangono immutati, l'app richiede tutte le biblioteche (opportuno inserire un limite?)
        filtroBibliotecaBeanProperty = new SimpleObjectProperty<>(new FiltroBibliotecaBean());

        //questa parte aggiunge i bottoni per selezionare il criterio ricerca biblioteche.
        //NOTA: potrebbe diventare un metodo privato del controller.
        for(String s : tipiFiltroProperty.get()){
            Button bottoneCriterio = new Button(s);
            bottoneCriterio.setPrefHeight(26);
            criteriRicercaHBox.getChildren().add(bottoneCriterio);


            //assegno handler bottone criterio
            bottoneCriterio.setOnAction( event -> {
                criterioRicercaTextField.setPromptText("Cerca per: " + s);
                filtroBibliotecaBeanProperty.get().setTipoSelezionato(s);
                }
            );
        }
        //di default la ricerca è per nome.
        filtroBibliotecaBeanProperty.get().setTipoSelezionato(TipoFiltroBiblioteca.NOME.toString());
        criterioRicercaTextField.setPromptText("Cerca per: " + TipoFiltroBiblioteca.NOME);

        //assegno comportamento a seguito di selezione della biblioteca.
        /*
        Selection model mantiene la reference dell'oggetto selezionato nella lista, che otteniamo come ObservableProperty
        tramite il metodo ".selectedItemProperty.

        Essendo quindi l'ogetto selezionato una implementazione di Observable, è possibile a segnare a questo un InvalidationListener,
        ovvero un metodo che viene chiamato ogni qual volta il valore dell'oggetto cambia, ovvero quando il lettore seleziona un elemento
        della ListView.

         */
        listaBibliotecheVisibile.getSelectionModel().selectedItemProperty().addListener(handlerSelezioneBiblioteca);




    }


}
