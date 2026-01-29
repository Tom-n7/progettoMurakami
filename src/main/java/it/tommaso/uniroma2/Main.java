package it.tommaso.uniroma2;



import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

public class Main extends Application{


    @Override
    public void start(Stage primaryStage) throws Exception {

        //Inizia esecuzione aprendo libreria personale.

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("src/main/resources/finestra1.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 720); //sostituisci numeri fissi
        primaryStage.setTitle("Progetto Murakami");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        Application.launch();
    }


}
