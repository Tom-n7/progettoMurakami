package it.tommaso.uniroma2.view;


import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

import static com.sun.javafx.scene.control.skin.Utils.getResource;

public abstract class CGFX extends StackPane {

    private final double DEFAULT_X = 1024.0;
    private final double DEFAULT_Y = 720.0;

    //Forse è bene creare una variante di questa operazione in cui specifichiamo anche x e y.
    protected Scene disegnaFinestra(String path) {

        double x = DEFAULT_X;
        double y = DEFAULT_Y;
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource(path));
        loader.setRoot(this);
        loader.setController(this);

        /*
        ObservableList<Node> newChildrenList;
        ObservableList<Node> oldChildrenList = this.getChildren();
        removeAllIncludedChildren(oldChildrenList);
         */
        try{
            loader.load();

        }catch (IOException e){
            e.printStackTrace();
        }

        Scene scene = new Scene(this);
        return scene;

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

}
