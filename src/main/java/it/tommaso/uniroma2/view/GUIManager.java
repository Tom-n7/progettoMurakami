package it.tommaso.uniroma2.view;

import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

/*
* Classe deputata alla gestione delle viste del sistema, ogni controller grafico usufruisce di questo oggetto nel
* momento in cui il caso d'uso associato termina ed inizia il successivo.
*/
public class GUIManager {

    private static GUIManager istanza;
    private StackPane rootPane;


    //metodo per ottenere reference del GUI manager.
    public static GUIManager getGUIManager(){

        if(istanza == null){
            istanza = new GUIManager();
        }

        return istanza;
    }

    public void cambiaFinestra(String path) {
        cambiaFinestra(rootPane, path, this);
    }

    public void cambiaFinestra(Pane pane, String path, Object caller) {
        Window window = pane.getScene().getWindow();
        double x = window.getX();
        double y = window.getY();
        FXMLLoader loader = new FXMLLoader(caller.getClass().getResource(path));

        ObservableList<Node> childrenList = pane.getChildren();
        removeAllIncludedChildren(childrenList);

        try{
            pane.getChildren().add(loader.load());
            Stage stage = (Stage) window;
            stage.setMinHeight(0);
            stage.setMinWidth(0);
            window.sizeToScene();
            stage.setX(x);
            stage.setY(y);
            stage.setMinHeight(window.getHeight());
            stage.setMinWidth(window.getWidth());
        }catch (IOException e){
            e.printStackTrace();
        }


    }

    public void setRootPane(StackPane pane){
        rootPane = pane;
    }

    private static void removeAllIncludedChildren(ObservableList<Node> childrenList) {
        for (int childIndex = 0; childIndex < childrenList.size(); childIndex++) {
            childrenList.remove(childIndex);
        }
    }

}
