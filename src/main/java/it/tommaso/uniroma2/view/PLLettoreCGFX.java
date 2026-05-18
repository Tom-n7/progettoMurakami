package it.tommaso.uniroma2.view;


/*
Controller grafico interfaccia lettore del caso d'uso "prenota libro" in modalità che utilizza javaFX.
 */


import it.tommaso.uniroma2.bean.BibliotecaBean;
import it.tommaso.uniroma2.bean.FiltroBibliotecaBean;
import it.tommaso.uniroma2.control.PrenotaLibroController;
import it.tommaso.uniroma2.model.TipoFiltroBiblioteca;
import javafx.beans.property.ObjectProperty;
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
    private Button bottoneRicerca;

    @FXML
    private TextField criterioRicercaTextField;

    /*
    Viene impostato come filtro l'input del lettore, che influisce sulle biblioteche visibili seconda del
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

    }


}
