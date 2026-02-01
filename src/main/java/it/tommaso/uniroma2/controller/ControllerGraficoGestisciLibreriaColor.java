package it.tommaso.uniroma2.controller;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ControllerGraficoGestisciLibreriaColor extends Application implements ControllerGrafico {


    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/it/tommaso/uniroma2/controller/mannaggiacristo.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),1280, 720);
        stage.setScene(scene);

        stage.show();


    }


    @Override
    public void start() {
        Application.launch();
    }
}
