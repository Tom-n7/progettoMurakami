package it.tommaso.uniroma2;


import it.tommaso.uniroma2.view.FX.LoginControllerGraficoJavaFX;
import it.tommaso.uniroma2.view.FX.ControllerGrafico;
import it.tommaso.uniroma2.view.LoginControllerGrafico;
import it.tommaso.uniroma2.view.terminal.LoginControllerGraficoTerminale;
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

    public static void main(String[] args) {startLogin(leggiImpostazioneGrafica());}


    private static void startLogin(GUIType tipoGUI, String... args)  {
        if (tipoGUI == GUIType.JAVAFX) {
            FXApp.main(args);
        } else {
            LoginControllerGrafico logContr = new LoginControllerGraficoTerminale();
            logContr.vistaLogin();
        }
    }

    //simula una lettura di un file di impostazioni, PROVVISORIA.
    private static GUIType leggiImpostazioneGrafica(){

        System.out.println("Scegli impostazione grafica");
        System.out.println("1. JAVAFX");
        System.out.println("2. Terminale");

        Scanner input = new Scanner(System.in);
        int choice = 0;
        while (true) {
            System.out.print("Please enter your choice: ");
            choice = input.nextInt();
            if (choice >= 1 && choice <= 2) {
                break;
            }
            System.out.println("scelta non valida");
        }

        if (choice == 1) {
            return GUIType.JAVAFX;
        }else{
            return GUIType.TERMINALE;
        }
    }
}




public class FXApp extends Application {

    public static void main(String... args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) {

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


}
