package it.tommaso.uniroma2.progettoISPW.view.mobile;

import it.tommaso.uniroma2.progettoISPW.bean.IBean;
import it.tommaso.uniroma2.progettoISPW.view.ControllerGrafico;
import it.tommaso.uniroma2.progettoISPW.view.desktop.OrchestratoreFinestre;
import it.tommaso.uniroma2.progettoISPW.view.desktop.finestre_complete.VistaCercaBiblioteca;
import it.tommaso.uniroma2.progettoISPW.view.desktop.finestre_complete.VistaCompleta;
import it.tommaso.uniroma2.progettoISPW.view.desktop.finestre_complete.VistaPrenotazione;
import it.tommaso.uniroma2.progettoISPW.view.desktop.finestre_popup.VistaDettagliBiblioteca;
import it.tommaso.uniroma2.progettoISPW.view.desktop.finestre_popup.VistaImportaMetadatiLibro;
import it.tommaso.uniroma2.progettoISPW.view.desktop.finestre_popup.VistaPopup;
import javafx.application.Application;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class MobileController extends Application implements ControllerGrafico, OrchestratoreFinestre {

    private final String NOME_VISTA_DI_ENTRATA = "menu_principale";
    private final double DEFAULT_WIDTH = 720;
    private final double DEFAULT_HEIGHT = 1080;
    private final Map<String, Class> NOMI_VISTE_CONTROLLER = new HashMap<>();

    private Stage primaryStage;
    private Pane radicePrimaryStage;

    public MobileController(){

        NOMI_VISTE_CONTROLLER.put("menu_principale", VistaMenuPrincipale.class);
        NOMI_VISTE_CONTROLLER.put("ricerca_biblioteca", VistaCercaBiblioteca.class);
        NOMI_VISTE_CONTROLLER.put("dettagli_biblioteca", VistaDettagliBiblioteca.class);
        NOMI_VISTE_CONTROLLER.put("dettagli_prenotazione", VistaPrenotazione.class);
        NOMI_VISTE_CONTROLLER.put("importa_metadati_libro", VistaImportaMetadatiLibro.class);
    }


    @Override
    public void iniziaSessioneGrafica(String... args) {launch(args);

    }

    @Override
    public void start(Stage stage) throws Exception {
        primaryStage = stage;
        primaryStage.setWidth(DEFAULT_WIDTH);
        primaryStage.setHeight(DEFAULT_HEIGHT);
        lanciaVistaCompleta(NOME_VISTA_DI_ENTRATA);
    }


    public void lanciaVistaCompleta(String nomeVista, IBean... beans){

        //Il loader costruisce ricostruisce la posizione della risorsa a partire dal suo nome e dalla posizione del
        //pacchetto dell'inerfaccia, tutte le finestre che chiamano questo metodo si trovano nello stesso pacchetto
        //dell'inerfaccia.
        FXMLLoader loader = new FXMLLoader(VistaMobile.class.getResource(nomeVista + ".fxml"));
        try {
            VistaMobile controllerVista =
                    (VistaMobile) NOMI_VISTE_CONTROLLER.get(nomeVista).getDeclaredConstructor(OrchestratoreFinestre.class, IBean[].class).newInstance(this, beans);
            loader.setControllerFactory(c->{
                return controllerVista;
            });
        }catch (NoSuchMethodException e){
            throw new RuntimeException();
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        try {
            //ogni vista completa ha come radicePrimaryStage uno StackPane
            radicePrimaryStage = loader.load();

            //ogni vista completa uno stackpane "sopra" i figli che ospitano finestre.

            Scene scene = new Scene(radicePrimaryStage);

            primaryStage.setScene(scene);
            primaryStage.show();
        }catch (IOException e){
            throw new RuntimeException(e);
        }

    }

    @Override
    public void lanciaVistaPopup(String nomeVista, SimpleObjectProperty... properties) {

    }

    @Override
    public void ricaricaVista() {

    }

    @Override
    public void chiudiFinestraPopup(VistaPopup vistaPopup) {

    }


}
