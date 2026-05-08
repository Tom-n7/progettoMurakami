package it.tommaso.uniroma2.view;


import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

import static com.sun.javafx.scene.control.skin.Utils.getResource;

public abstract class CGFX {

    protected static StackPane rootPane ;


    protected void disegnaFinestra(String path) {
        Window window = rootPane.getScene().getWindow();
        double x = window.getX();
        double y = window.getY();
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource(path));

        ObservableList<Node> childrenList = rootPane.getChildren();
        removeAllIncludedChildren(childrenList);

        try{
            rootPane.getChildren().add(loader.load());
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


    protected void decoraPane(String path, AnchorPane pane){

        FXMLLoader loader = new FXMLLoader(this.getClass().getResource(path));

        ObservableList<Node> childrenList = pane.getChildren();
        removeAllIncludedChildren(childrenList);

        try{
            pane.getChildren().add(loader.load());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void removeAllIncludedChildren(ObservableList<Node> childrenList) {
        for (int childIndex = 0; childIndex < childrenList.size(); childIndex++) {
            childrenList.remove(childIndex);
        }
    }

    public static void setRootPane (Stage stage){
        FXMLLoader loader = new FXMLLoader();
        java.net.URL pippo = getResource("/root.fxml");
         loader.setLocation(pippo);
        try {
            CGFX.rootPane = loader.load();//uno stack pane di base costituisce il nodo radice dell'interfaccia.
            Scene scene = new Scene(rootPane);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}
