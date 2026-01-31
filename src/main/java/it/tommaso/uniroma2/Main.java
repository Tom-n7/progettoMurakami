package it.tommaso.uniroma2;



import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

public class Main extends Application{


    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(""));
        Scene scene = new Scene(fxmlLoader.load(),400, 400);
        stage.setScene(scene);

        stage.show();


    }

    public static void main(String[] args) {
        Application.launch();
    }


}
