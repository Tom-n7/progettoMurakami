package it.tommaso.uniroma2.progettoISPW.view;

import it.tommaso.uniroma2.progettoISPW.view.finestre_complete.VistaCercaBiblioteca;
import it.tommaso.uniroma2.progettoISPW.view.finestre_complete.VistaCompleta;
import it.tommaso.uniroma2.progettoISPW.view.finestre_complete.VistaMenuPrincipale;
import it.tommaso.uniroma2.progettoISPW.view.finestre_popup.VistaDettagliBiblioteca;
import it.tommaso.uniroma2.progettoISPW.view.finestre_popup.VistaPopup;
import javafx.application.Application;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Popup;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import static javafx.event.Event.fireEvent;

public class DesktopController extends Application implements ControllerGrafico, OrchestratoreFinestre{

    private final String NOME_VISTA_DI_ENTRATA = "menu_principale";
    private final double DEFAULT_WIDTH = 1280;
    private final double DEFAULT_HEIGHT = 720;
    private final Map<String, Class> NOMI_VISTE_CONTROLLER = new HashMap<>();


    //elementi finestra vista completa attiva
    private Stage primaryStage;
    private Pane radicePrimaryStage;

    //popup attivo
    private Popup stagePopup;


    public DesktopController(){

        NOMI_VISTE_CONTROLLER.put("menu_principale", VistaMenuPrincipale.class);
        NOMI_VISTE_CONTROLLER.put("ricerca_biblioteca", VistaCercaBiblioteca.class);
        NOMI_VISTE_CONTROLLER.put("dettagli_biblioteca", VistaDettagliBiblioteca.class);

    }

    @Override
    public void start(Stage stage) {

        primaryStage = stage;
        primaryStage.setWidth(DEFAULT_WIDTH);
        primaryStage.setHeight(DEFAULT_HEIGHT);
        lanciaVistaCompleta(NOME_VISTA_DI_ENTRATA);

    }

    public void iniziaSessioneGrafica(String... args){
        launch(args);
    }

    public void lanciaVistaPopup(String nomeVista){


        FXMLLoader loader = new FXMLLoader(VistaPopup.class.getResource(nomeVista+ ".fxml"));
        try{
            VistaPopup controllerVista =
                    (VistaPopup) NOMI_VISTE_CONTROLLER.get(nomeVista).getDeclaredConstructor(OrchestratoreFinestre.class).newInstance(this);
            loader.setControllerFactory(c->
            {
                return controllerVista;
            });

        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        try {

            Pane mascheraPopup = new Pane();
            mascheraPopup.setId("maschera_popup");
            mascheraPopup.setBackground(Background.fill(Color.GREY));
            mascheraPopup.setOpacity(.40);

            radicePrimaryStage.getChildren().add(mascheraPopup);

            StackPane radicePopup = loader.load();
            stagePopup = (new Popup());
            stagePopup.getScene().setRoot(radicePopup);
            stagePopup.show(primaryStage);


        }catch (IOException e){
            throw new RuntimeException(e);
        }

    }

    @Override
    public void chiudiFinestraPopup(VistaPopup vistaPopup) {

        stagePopup.hide();
        radicePrimaryStage.getChildren().remove(radicePrimaryStage.lookup("#maschera_popup"));



    }


    public void lanciaVistaCompleta(String nomeVista){

        //Il loader costruisce ricostruisce la posizione della risorsa a partire dal suo nome e dalla posizione del
        //pacchetto dell'inerfaccia, tutte le finestre che chiamano questo metodo si trovano nello stesso pacchetto
        //dell'inerfaccia.
        FXMLLoader loader = new FXMLLoader(VistaCompleta.class.getResource(nomeVista + ".fxml"));
        try {
            VistaCompleta controllerVista =
                    (VistaCompleta) NOMI_VISTE_CONTROLLER.get(nomeVista).getDeclaredConstructor(OrchestratoreFinestre.class).newInstance(this);
            loader.setControllerFactory(c->{
                return controllerVista;
            });
        }catch (NoSuchMethodException e){
            throw new RuntimeException();
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        try {
            //ogni vista completa ha come radicePrimaryStage uno StackPane
            radicePrimaryStage = loader.load();

            //ogni vista completa uno stackpane "sopra" i figli che ospitano finestre.

            Scene scene = new Scene(radicePrimaryStage);

            primaryStage.setScene(scene);
            primaryStage.show();
        }catch (IOException e){
            throw new RuntimeException(e);
        }

    }
}
