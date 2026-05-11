package it.tommaso.uniroma2;



import it.tommaso.uniroma2.init.view.InitGController;
import it.tommaso.uniroma2.supporto.SelettoreTerminale;
import it.tommaso.uniroma2.view.ControllerGrafico;

import it.tommaso.uniroma2.view.PLLettoreCGFX;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

import static com.sun.javafx.scene.control.skin.Utils.getResource;

/*
Classe controller del sistema; lancia l'applicazione in modalità GUI o CLI a seconda dell'impostazione
fornita.
 */

class Main{
    public static void main(String... args){


        System.out.println("Scegli modialità grafica");
        System.out.println("1. GUI");
        System.out.println("2. Terminale");





        System.out.println("Scegli impostazione persistenza");
        System.out.println("1. FILESYSTEM");
        System.out.println("2. DATABASE");

        FXApp.main(args);
    }
}
public class FXApp extends Application {

    private final ControllerGrafico VISTA_DI_ENTRATA = new InitGController();

    @Override
    public void start(Stage stage) {

        VISTA_DI_ENTRATA.lanciaVista();

    }

    /*
    Solo il thread Application può eseguire "Stage.show()", pertanto tutti i controller grafici si avvalgono
    di questa operazione per mostrare la scena che hanno costruito.
     */
    public static void mostraNuovoStage(Scene nuovaScene){

        Stage stage = new Stage();
        stage.setTitle("BiblioBuddy");
        stage.setScene(nuovaScene);
        stage.show();

    }


    //devo fare così sennò errore JavaFX runtime
    public static void main(String... args) {
            launch(args);
        }
}

