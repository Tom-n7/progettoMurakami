package it.tommaso.uniroma2.progettoISPW.view;

import it.tommaso.uniroma2.progettoISPW.init.VistaMenuPrincipale;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ControllerGrafico extends Application {
    private final String NOME_VISTA_DI_ENTRATA = "init_layout.fxml";
    private final Class CLASSE_CONTROLLER_VISTA_ENTRATA = VistaMenuPrincipale.class;


    private final double DEFAULT_WIDTH = 1280;
    private final double DEFAULT_HEIGHT = 720;

    private final Map<String,String> NOMI_VISTE = new HashMap<>();

    private Stage primaryStage;



    public ControllerGrafico(){

        NOMI_VISTE.put("ricerca_biblioteca", "ricerca_biblioteca.fxml");


        System.out.println("ecco!");
    }


    @Override
    public void start(Stage stage) {

        primaryStage = stage;
        FXMLLoader loader = new FXMLLoader(CLASSE_CONTROLLER_VISTA_ENTRATA.getResource(NOME_VISTA_DI_ENTRATA));
        loader.setControllerFactory(c-> {
                return new VistaMenuPrincipale(this);
        });
        try{
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void lanciaVista(String nomeVista){

        FXMLLoader loader = new FXMLLoader(this.getClass().getResource(NOMI_VISTE.get(nomeVista)));
        loader.get
        try{
            Scene scene = new Scene(loader.load(),DEFAULT_WIDTH,DEFAULT_HEIGHT);

            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }



    }
}
