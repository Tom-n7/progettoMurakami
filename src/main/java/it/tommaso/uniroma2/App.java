package it.tommaso.uniroma2;



import it.tommaso.uniroma2.view.GUIManager;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

import java.io.IOException;
import java.util.Random;

public class App extends Application {

    Modalita modalita;
    @Override
    public void start(Stage stage) throws Exception {

        Random rand = new Random();
        if(rand.nextInt(9) > 5){
            modalita = Modalita.PC;
        }else{
            modalita = Modalita.PHONE;
        }

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(App.class.getResource("root.fxml"));
        try{

            StackPane rootPane;
            rootPane = loader.load();//uno stack pane di base costituisce il nodo radice dell'interfaccia.

            GUIManager guiManager = GUIManager.getGUIManager();

            Scene scene = new Scene(rootPane);
            guiManager.setRootPane(rootPane);
            stage.setScene(scene);
            stage.show();



        }catch (IOException e){
            e.printStackTrace();
        }

    }

}

