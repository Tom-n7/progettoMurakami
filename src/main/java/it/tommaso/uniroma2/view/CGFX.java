package it.tommaso.uniroma2.view;


import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public abstract class CGFX extends StackPane implements ControllerGrafico, Initializable {

    private final double DEFAULT_X = 1024.0;
    private final double DEFAULT_Y = 720.0;

    //Forse è bene creare una variante di questa operazione in cui specifichiamo anche x e y.
    protected Scene disegnaFinestra(String path) {

        double x = DEFAULT_X;
        double y = DEFAULT_Y;
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource(path));
        loader.setRoot(this);

        try{
            loader.load();

        }catch (IOException e){
            e.printStackTrace();
        }

        Scene scene = new Scene(this);
        return scene;

    }


    public static void mostraNuovoStage(Scene nuovaScene){

        Stage stage = new Stage();
        stage.setTitle("BiblioBuddy");
        stage.setScene(nuovaScene);
        stage.show();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }

}
