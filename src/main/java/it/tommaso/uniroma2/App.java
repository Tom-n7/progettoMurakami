package it.tommaso.uniroma2;

import it.tommaso.uniroma2.controller.ControllerGrafico;
import it.tommaso.uniroma2.controller.ControllerGraficoBenvenuto;
import it.tommaso.uniroma2.controller.ControllerGraficoGestisciLibreriaColor;

public class App {
    /*porzione di codice che lancia app */
    public static void main(String... args){

        //fase inizio applicazione

        ControllerGrafico conotrollerBenvenuto = new ControllerGraficoBenvenuto();
        conotrollerBenvenuto.start();

        //mostra libreria
        ControllerGrafico controllerGraficoGestisciLibreriaColor = new ControllerGraficoGestisciLibreriaColor();
        controllerGraficoGestisciLibreriaColor.start();


    }





}
