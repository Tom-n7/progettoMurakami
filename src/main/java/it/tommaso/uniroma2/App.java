package it.tommaso.uniroma2;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

public class App extends Application {


    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(App.class.getResource("root.fxml"));

        try{
            StackPane rootPane;
            rootPane = loader.load(); //uno stack pane di base costituisce il nodo radice dell'interfaccia.
            GUIManager guiManager = GUIManager.getGUIManager();
            guiManager.setRootPane(rootPane);
            Scene scene = new Scene(rootPane);
            stage.show();



        }catch (IOException e){
            e.printStackTrace();
        }

    }

}

