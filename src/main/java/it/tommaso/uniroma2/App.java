package it.tommaso.uniroma2;



import it.tommaso.uniroma2.view.GUIManager;
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
            rootPane = loader.load();//uno stack pane di base costituisce il nodo radice dell'interfaccia.

            GUIManager GuiManager = GUIManager.getGUIManager();

            Scene scene = new Scene(rootPane);
            GuiManager.setRootPane(rootPane);
            stage.setScene(scene);
            stage.show();
            GuiManager.cambiaFinestra("color/schermatabenvenuto.fxml");

        }catch (IOException e){
            e.printStackTrace();
        }

    }

}

