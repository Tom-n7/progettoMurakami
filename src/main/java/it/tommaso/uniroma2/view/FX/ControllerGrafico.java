package it.tommaso.uniroma2.view.FX;


import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public abstract class ControllerGrafico {

    private static StackPane rootPane ;


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

    public static void setRootPane (StackPane pane){rootPane = pane;}




}
