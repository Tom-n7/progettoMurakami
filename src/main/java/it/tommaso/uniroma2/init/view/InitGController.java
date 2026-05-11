package it.tommaso.uniroma2.init.view;

import it.tommaso.uniroma2.supporto.CGFX;
import it.tommaso.uniroma2.view.ControllerGrafico;
import it.tommaso.uniroma2.view.EventoCambioUseCase;
import it.tommaso.uniroma2.view.PLLettoreCGFX;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class InitGController extends CGFX implements ControllerGrafico {


    @FXML
    private Text headLabel;

    @FXML
    private Button bottonePrenotazione;

    @FXML
    private Button bottoneLibreria;


    @FXML
    public void clickNuovaPrenotazione(ActionEvent e ){
        fireEvent(new Event(EventoCambioUseCase.GESTISCI_LIBRERIA));
    }

    @FXML
    public void clickGestisciLibreria(ActionEvent e){
        fireEvent(new Event(EventoCambioUseCase.GESTISCI_LIBRERIA));
    }


    private final EventHandler<EventoCambioUseCase> casoNonImplementatoHandler = new EventHandler<>(){
        @Override
        public void handle(EventoCambioUseCase event) {
            headLabel.setText("Non implementato!");
        }
    };


    private final EventHandler<EventoCambioUseCase> prenotaLibroHandler = new EventHandler<EventoCambioUseCase>() {
        @Override
        public void handle(EventoCambioUseCase event) {
            new PLLettoreCGFX(stage);
        }
    };



    public InitGController(Stage stage) {

        super(stage);

    }


    @Override
    public void lanciaVista() {
        this.addEventHandler(EventoCambioUseCase.ANY, casoNonImplementatoHandler);
        this.addEventHandler(EventoCambioUseCase.PRENOTA_LIBRO, prenotaLibroHandler);

        disegnaFinestra("/it.tommaso.uniroma2/init/view/init_layout.fxml");
    }
}
