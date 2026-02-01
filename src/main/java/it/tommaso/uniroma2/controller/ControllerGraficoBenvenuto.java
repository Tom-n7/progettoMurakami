package it.tommaso.uniroma2.controller;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ControllerGraficoBenvenuto extends Application implements ControllerGrafico {

    Stage stage;
    @Override
    public void start(Stage stage) throws Exception {

        String css = this.getClass().getResource("/it/tommaso/uniroma2/controller/benvenuto.css").toExternalForm();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/it/tommaso/uniroma2/controller/schermatabenvenuto.fxml"));

        Scene scene = new Scene(fxmlLoader.load(),600, 400);
        scene.getStylesheets().add(css);




        stage.setScene(scene);
        stage.show();



    }

    @Override
    public void start() {
        Application.launch();
    }


    public void click(ActionEvent e){
        System.out.println("click!");

    }
}
