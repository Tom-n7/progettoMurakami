package it.tommaso.uniroma2.progettoISPW.view;

import it.tommaso.uniroma2.progettoISPW.init.VistaMenuPrincipale;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ControllerGrafico extends Application {
    private final String NOME_VISTA_DI_ENTRATA = "menu_principale";


    private final double DEFAULT_WIDTH = 1280;
    private final double DEFAULT_HEIGHT = 720;

    private final Map<String,VistaCompleta> NOMI_VISTE = new HashMap<>();

    private Stage primaryStage;

    public ControllerGrafico(){

        NOMI_VISTE.put("menu_principale", new VistaMenuPrincipale(this));
        NOMI_VISTE.put("ricerca_biblioteca", new VistaCercaBiblioteca(this) );


        System.out.println("ecco!");
    }

    @Override
    public void start(Stage stage) {

        primaryStage = stage;
        primaryStage.setWidth(DEFAULT_WIDTH);
        primaryStage.setHeight(DEFAULT_HEIGHT);

        lanciaVistaCompleta(NOME_VISTA_DI_ENTRATA);

    }

    public void lanciaVistaCompleta(String nomeVista){

        try {
            Parent radice = NOMI_VISTE.get(nomeVista).ottieniRadice().load();
            Scene scene = new Scene(radice);
            primaryStage.setScene(scene);
            primaryStage.show();
        }catch (IOException e){
            throw new RuntimeException(e);
        }

    }
}
