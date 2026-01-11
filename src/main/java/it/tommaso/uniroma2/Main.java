package it.tommaso.uniroma2;



import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

public class Main {
    public static void main(String[] args) {

        Application.launch(ProvaJavaFX.class,args);

    }

    public static class ProvaJavaFX extends Application {

        @Override
        public void start(Stage primaryStage) throws Exception {
            primaryStage.setTitle("JavaFX Welcome");

            primaryStage.show();
            GridPane grid = new GridPane();
            grid.setAlignment(Pos.CENTER);
            grid.setHgap(10);
            grid.setVgap(10);
            grid.setPadding(new Insets(25, 25, 25, 25));

            Scene scene = new Scene(grid, 300, 275);
            primaryStage.setScene(scene);
        }
    }
}
