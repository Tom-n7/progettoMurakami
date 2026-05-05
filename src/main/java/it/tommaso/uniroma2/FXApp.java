package it.tommaso.uniroma2;


import it.tommaso.uniroma2.gestiscilp.model.Sessione;
import it.tommaso.uniroma2.gestiscilp.model.dao.Modalita;
import it.tommaso.uniroma2.gestiscilp.view.FX.LoginControllerGraficoJavaFX;
import it.tommaso.uniroma2.gestiscilp.view.FX.ControllerGrafico;
import it.tommaso.uniroma2.gestiscilp.view.GUIType;
import it.tommaso.uniroma2.gestiscilp.view.LoginControllerGrafico;
import it.tommaso.uniroma2.gestiscilp.view.terminal.LoginControllerGraficoTerminale;
import it.tommaso.uniroma2.supporto.SelettoreTerminale;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Scanner;

import static com.sun.javafx.scene.control.skin.Utils.getResource;







/*
Classe controller del sistema; lancia l'applicazione in modalità GUI o CLI a seconda dell'impostazione
fornita.
 */

class Main{
    public static void main(String... args){
        FXApp.main(args);
    }
}
public class FXApp extends Application {

    Modalita persistenza;


    @Override
    public void start(Stage stage) {

        System.out.println("Scegli impostazione persistenza");
        System.out.println("1. FILESYSTEM");
        System.out.println("2. DATABASE");

        if ((new SelettoreTerminale(2)).selezione() == 1) {
            this.persistenza = Modalita.FILESYSTEM;
        }else{
            this.persistenza = Modalita.DATABASE;
        }

        Sessione sessione = Sessione.getSessione();
        sessione.setModGrafica(GUIType.JAVAFX);
        sessione.setModPersistenza(persistenza);

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getResource("/root.fxml"));
        try {
            StackPane rootPane = loader.load();//uno stack pane di base costituisce il nodo radice dell'interfaccia.
            ControllerGrafico.setRootPane(rootPane);
            Scene scene = new Scene(rootPane);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

        LoginControllerGrafico controller = new LoginControllerGraficoJavaFX();
        controller.vistaLogin();

    }
    public   Modalita getPersistenza(){return this.persistenza;}

    //devo fare così sennò errore JavaFX runtime
    public static void main(String... args) {
            launch(args);
        }
}

