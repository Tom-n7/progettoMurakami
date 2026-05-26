package it.tommaso.uniroma2.progettoISPW.view.finestre_popup;

import it.tommaso.uniroma2.progettoISPW.bean.BibliotecaBean;
import it.tommaso.uniroma2.progettoISPW.bean.IBean;
import it.tommaso.uniroma2.progettoISPW.model.Biblioteca;
import it.tommaso.uniroma2.progettoISPW.model.Indirizzo;
import it.tommaso.uniroma2.progettoISPW.model.RegolaPrenotazione;
import it.tommaso.uniroma2.progettoISPW.view.OrchestratoreFinestre;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class VistaDettagliBiblioteca implements VistaPopup, Initializable {


    private final OrchestratoreFinestre controller;
    private SimpleObjectProperty<BibliotecaBean> popertyBiblioteca;
    @FXML
    private Button bottoneEsci;
    @FXML
    private Label labelNome;
    @FXML
    private Label labelIndirizzo;
    @FXML
    private Label labelNumeroLibri;
    @FXML
    private Label orarioBiblioteca;

    public VistaDettagliBiblioteca (OrchestratoreFinestre controller, IBean biblioteca){
        this.controller = controller;
        this.popertyBiblioteca = new SimpleObjectProperty<>();


        popertyBiblioteca.set((BibliotecaBean) biblioteca);

    }

    public void clickBottoneEsci(ActionEvent actionEvent) {
        controller.chiudiFinestraPopup(this);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        labelNome.setText( popertyBiblioteca.get().getNome() );
        labelIndirizzo.setText( popertyBiblioteca.get().getIndirizzo() );
        labelNumeroLibri.setText( popertyBiblioteca.get().getRegolePrenotazione() );

    }
}
