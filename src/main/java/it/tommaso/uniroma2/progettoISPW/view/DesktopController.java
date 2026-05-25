package it.tommaso.uniroma2.progettoISPW.view;

import it.tommaso.uniroma2.progettoISPW.view.finestre_complete.VistaCercaBiblioteca;
import it.tommaso.uniroma2.progettoISPW.view.finestre_complete.VistaCompleta;
import it.tommaso.uniroma2.progettoISPW.view.finestre_complete.VistaMenuPrincipale;
import it.tommaso.uniroma2.progettoISPW.view.finestre_popup.VistaDettagliBiblioteca;
import it.tommaso.uniroma2.progettoISPW.view.finestre_popup.VistaPopup;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class DesktopController extends Application implements ControllerGrafico, OrchestratoreFinestre{

    private final String NOME_VISTA_DI_ENTRATA = "menu_principale";
    private final double DEFAULT_WIDTH = 1280;
    private final double DEFAULT_HEIGHT = 720;
    private final Map<String, Class> NOMI_VISTE_CONTROLLER = new HashMap<>();


    private Stage primaryStage;
    private Pane radice;

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
            StackPane socketPopup = new StackPane();
            socketPopup.setBackground(Background.fill(Color.GREY));
            socketPopup.setOpacity(.40);
            socketPopup.setId("socket_popup");

            radice.getChildren().add(socketPopup);


            StackPane radicePopup = loader.load();
            socketPopup.getChildren().add(radicePopup);
        }catch (IOException e){
            throw new RuntimeException(e);
        }

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
            //ogni vista completa ha come radice uno StackPane
            radice = loader.load();

            //ogni vista completa uno stackpane "sopra" i figli che ospitano finestre.

            Scene scene = new Scene(radice);

            primaryStage.setScene(scene);
            primaryStage.show();
        }catch (IOException e){
            throw new RuntimeException(e);
        }

    }
}
