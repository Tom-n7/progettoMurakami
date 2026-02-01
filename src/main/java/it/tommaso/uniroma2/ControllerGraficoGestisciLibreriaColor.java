package it.tommaso.uniroma2;


import it.tommaso.uniroma2.controller.ControllerGraficoGestisciLibreria;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ControllerGraficoGestisciLibreriaColor extends Application implements ControllerGraficoGestisciLibreria {


    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/finestraprincipale.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),1280, 720);
        stage.setScene(scene);

        stage.show();


    }


    @Override
    public void mostraLibreriaPrincipale() {
        Application.launch();
    }
}
