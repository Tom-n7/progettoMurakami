package it.tommaso.uniroma2.view;

import it.tommaso.uniroma2.bean.BibliotecaBean;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class FinestraProvvisoriaSceltaBiblioteca extends CGFX implements Initializable {

    public VBox nomeBiblioteca;
    public Label labelNome;
    public Label labelIndirizzo;
    public Label orarioBiblioteca;
    public Label labelNumeroLibri;

    private BibliotecaBean biblioteca;

    FinestraProvvisoriaSceltaBiblioteca(BibliotecaBean biblioteca){
        this.biblioteca = biblioteca;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {





    }

    @Override
    public void lanciaVista() {
        Scene layoutProdotto = disegnaFinestra("/it.tommaso.uniroma2/plibFXML/provvisorioSceltaBiblioteca.fxml");


        labelNome.setText(biblioteca.getNome());
        labelIndirizzo.setText(biblioteca.getIndirizzo());
        labelNumeroLibri.setText(biblioteca.getRegolePrenotazione());

        mostraNuovoStage(layoutProdotto);
    }

    @Override
    public Node getStyleableNode() {
        return super.getStyleableNode();
    }
}
