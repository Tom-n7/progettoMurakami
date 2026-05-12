package it.tommaso.uniroma2.init.view;


import it.tommaso.uniroma2.FXApp;
import it.tommaso.uniroma2.view.CGFX;
import it.tommaso.uniroma2.view.ControllerGrafico;
import it.tommaso.uniroma2.view.EventoCambioUseCase;
import it.tommaso.uniroma2.view.PLLettoreCGFX;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class InitGController extends CGFX {


    @FXML
    private Text c;

    @FXML
    private  Button bottonePrenotazione;

    @FXML
    private Button bottoneLibreria;


    //Gestori evento iaterazione con bottoni.
    @FXML
    public void clickNuovaPrenotazione(ActionEvent e ){
        ((Node) e.getSource()).fireEvent(new EventoCambioUseCase(EventoCambioUseCase.PRENOTA_LIBRO));
    }

    @FXML
    public void clickGestisciLibreria(ActionEvent e){
        ((Node) e.getSource()).fireEvent(new EventoCambioUseCase(EventoCambioUseCase.GESTISCI_LIBRERIA));
    }

    @Override
    public void lanciaVista() {

        Scene layoutProdotto  = disegnaFinestra("/it.tommaso.uniroma2/init/view/init_layout.fxml");

        addEventHandler(EventoCambioUseCase.PRENOTA_LIBRO,
                event -> {
                    (new PLLettoreCGFX()).lanciaVista();
                    ((Stage) getScene().getWindow()).close();
                    event.consume();
                });
        addEventHandler(EventoCambioUseCase.ANY,
                event -> {
            if(!event.isConsumed()){

            }
        });

        FXApp.mostraNuovoStage(layoutProdotto);
    }
}
