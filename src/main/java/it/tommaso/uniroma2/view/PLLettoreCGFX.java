package it.tommaso.uniroma2.view;


/*
Controller grafico interfaccia lettore del caso d'uso "prenota libro" in modalità che utilizza javaFX.
 */


import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class PLLettoreCGFX  extends CGFX implements ControllerGrafico  {


    @FXML
    private StackPane popupSocket;
    @FXML
    private Button bottoneCentral;

    @FXML
    private Text titolo;
    @FXML
    private ListView listaBiblioteche;

    private  EventHandler<EnventoCambioUseCase> eventHandler = new EventHandler<>() {
        @Override
        public void handle(EnventoCambioUseCase event) {

            /*
            PROVA: voglio che i cambi di use case siano eventi, devo approfondire meglio quali nodi devono gestire tali eventi,
            approfondire bene come avviene la propagazione e chi avrà la responsabilità di disegnare li vista del caso d'uso
             */
            ObservableList<Node> childrenList = popupSocket.getChildren();
            childrenList.add(new Rectangle(50,50, Color.GREENYELLOW));
        }
    };







    public void lanciaVista() {


        disegnaFinestra("/it.tommaso.uniroma2/plibFXML/ricerca_biblioteca.fxml");





    }

    public void click(ActionEvent actionEvent) {
        titolo.setText("Ecco i risultati!");
        popupSocket.addEventHandler(EnventoCambioUseCase.ANY,eventHandler);
        popupSocket.fireEvent(new EnventoCambioUseCase(EnventoCambioUseCase.ANY));
    }




}
