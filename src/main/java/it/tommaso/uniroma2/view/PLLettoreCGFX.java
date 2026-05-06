package it.tommaso.uniroma2.view;


/*
Controller grafico interfaccia lettore del caso d'uso "prenota libro" in modalità che utilizza javaFX.
 */


import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class PLLettoreCGFX  extends CGFX implements ControllerGrafico  {

    public Button bottoneCentral;

    public Text titolo;
    public ListView listaBiblioteche;


    public void lanciaVista() {
        disegnaFinestra("/it.tommaso.uniroma2/plibFXML/ricerca_biblioteca.fxml");
    }


    public void click(ActionEvent actionEvent) {
        titolo.setText("Ecco i risultati!");
    }
}
