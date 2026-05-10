package it.tommaso.uniroma2;


import it.tommaso.uniroma2.supporto.Sessione;
import it.tommaso.uniroma2.gestiscilp.model.dao.Modalita;
import it.tommaso.uniroma2.gestiscilp.view.FX.LoginControllerGraficoJavaFX;
import it.tommaso.uniroma2.view.CGFX;
import it.tommaso.uniroma2.gestiscilp.view.GUIType;
import it.tommaso.uniroma2.gestiscilp.view.LoginControllerGrafico;
import it.tommaso.uniroma2.supporto.SelettoreTerminale;
import it.tommaso.uniroma2.view.ControllerGrafico;
import it.tommaso.uniroma2.view.PLLettoreCGFX;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

import static com.sun.javafx.scene.control.skin.Utils.getResource;

/*
Classe controller del sistema; lancia l'applicazione in modalità GUI o CLI a seconda dell'impostazione
fornita.
 */

class Main{
    public static void main(String... args){

        Sessione sessione = Sessione.getSessione();

        System.out.println("Scegli modialità grafica");
        System.out.println("1. GUI");
        System.out.println("2. Terminale");


        if ((new SelettoreTerminale(2)).selezione() == 1){
            sessione.setModGrafica(GUIType.JAVAFX);
        } else {
            sessione.setModGrafica(GUIType.TERMINALE);
        }


        System.out.println("Scegli impostazione persistenza");
        System.out.println("1. FILESYSTEM");
        System.out.println("2. DATABASE");

        if ((new SelettoreTerminale(2)).selezione() == 1) {
            sessione.setModPersistenza(Modalita.FILESYSTEM);
        }else{
            sessione.setModPersistenza(Modalita.DATABASE);
        }
        FXApp.main(args);
    }
}
public class FXApp extends Application {

    Modalita persistenza;

    @Override
    public void init(){
        Sessione sessione = Sessione.getSessione();
        sessione.setModPersistenza(persistenza);
    }


    @Override
    public void start(Stage stage) {

        ControllerGrafico prenotaLibroCG = new PLLettoreCGFX();
        Scene finestra = prenotaLibroCG.lanciaVista();
        stage.setScene(finestra);
        stage.show();


    }
    public   Modalita getPersistenza(){return this.persistenza;}

    //devo fare così sennò errore JavaFX runtime
    public static void main(String... args) {
            launch(args);
        }
}

