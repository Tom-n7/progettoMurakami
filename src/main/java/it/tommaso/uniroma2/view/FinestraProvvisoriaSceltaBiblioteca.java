package it.tommaso.uniroma2.view;

import it.tommaso.uniroma2.bean.BibliotecaBean;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class FinestraProvvisoriaSceltaBiblioteca extends CGFX{

    public VBox nomeBiblioteca;
    public Label labelNome;
    public Label labelIndirizzo;
    public Label orarioBiblioteca;
    public Label labelNumeroLibri;

    private BibliotecaBean biblioteca;


    public void setBiblioteca(BibliotecaBean biblioteca){
        this.biblioteca = biblioteca;
        labelNome.setText(biblioteca.getNome());
        labelIndirizzo.setText(biblioteca.getIndirizzo());
        labelNumeroLibri.setText(biblioteca.getRegolePrenotazione());

    }
    @Override
    public void lanciaVista() {

    }


    public FinestraProvvisoriaSceltaBiblioteca(){

    }
}
