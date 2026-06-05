package it.tommaso.uniroma2.progettoispw.view.desktop.finestre_popup;

import it.tommaso.uniroma2.progettoispw.bean.LibroBean;
import it.tommaso.uniroma2.progettoispw.control.ImportaMetadatiLibroController;
import it.tommaso.uniroma2.progettoispw.view.desktop.OrchestratoreFinestre;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Popup;

import java.net.URL;
import java.util.*;

public class VistaImportaMetadatiLibro extends Popup implements VistaPopup, Initializable {

    @FXML
    private Button bottoneConferma;
    @FXML
    private TextField fieldLingua;
    @FXML
    private TextField fieldTitolo;
    @FXML
    private TextField fieldAutore;
    @FXML
    private TextField fieldEditore;
    @FXML
    private TextField fieldEdizione;
    @FXML
    private TextField fieldISNB;

    private final SimpleObjectProperty<LibroBean> libroBeanProperty;


    private final OrchestratoreFinestre controllerGrafico;
    private final ImportaMetadatiLibroController appController;

    public VistaImportaMetadatiLibro(OrchestratoreFinestre controller, SimpleObjectProperty... properties){
        this.controllerGrafico = controller;
        this.appController = new ImportaMetadatiLibroController();

        /*
        Tutte le viste hanno la responsabilità di controllare che i dati necessari alla loro creazione siano forniti
        nel formato corretto.
         */
        LibroBean libroBean;
        try {
            libroBeanProperty = (SimpleObjectProperty<LibroBean>) properties[0];
        } catch (ClassCastException e) {
            String nomeClasseSbagliata = properties[0].getClass().toString();
            throw new IllegalArgumentException("La vista necessita di un'istanza di LibroBean, invece viene fornita classe " + nomeClasseSbagliata);
        }
        /*
        Preparato il bean che viene popolato in fase di importazione matadaati.
         */

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }

    public void clickSuEsci(ActionEvent actionEvent) {
        controllerGrafico.chiudiFinestraPopup(this);
    }

    public void clickSuConferma(ActionEvent actionEvent) {

        String titolo = fieldTitolo.getText();
        String autore = fieldAutore.getText();
        String editore = fieldEditore.getText();
        String edizione = fieldEdizione.getText();
        String codiceISNB = fieldISNB.getText();
        String lingua = fieldLingua.getText();

        //controllo se dati obbligatori inseriti
        if(titolo != null && autore != null && editore != null && codiceISNB != null && lingua != null){

            //Scrivo sul libroBean passato i dati acquisiti
            LibroBean libroBean = new LibroBean();
            libroBean.setTitolo(titolo);
            libroBean.setAutori(List.of(autore));
            libroBean.setEditore(editore);
            libroBean.setEdizione(edizione);
            libroBean.setCodiceISNB(codiceISNB);
            libroBean.setLingua(lingua);

            //salvo il libro acquisito
            libroBean.setId(
                    (appController.salvaLibro(libroBean)).getId()
            );


            libroBeanProperty.set(libroBean);
            controllerGrafico.chiudiFinestraPopup(this);
        }





    }
}
