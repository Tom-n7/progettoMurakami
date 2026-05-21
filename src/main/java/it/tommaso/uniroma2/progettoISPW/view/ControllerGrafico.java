package it.tommaso.uniroma2.progettoISPW.view;

import it.tommaso.uniroma2.progettoISPW.init.VistaMenuPrincipale;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerGrafico extends Application {
    private final String NOME_VISTA_DI_ENTRATA = "init_layout.fxml";
    private final Class CLASSE_CONTROLLER_VISTA_ENTRATA = VistaMenuPrincipale.class;






    public ControllerGrafico(){
        System.out.println("ecco!");
    }


    @Override
    public void start(Stage stage) {

        FXMLLoader loader = new FXMLLoader(CLASSE_CONTROLLER_VISTA_ENTRATA.getResource(NOME_VISTA_DI_ENTRATA));
        loader.setControllerFactory(c->{
            return new VistaMenuPrincipale(5);
        });
        try{
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
