package it.tommaso.uniroma2.view.terminal;

import it.tommaso.uniroma2.controller.LibreriaAppController;
import it.tommaso.uniroma2.view.LibreriaPersonaleControllerGrafico;

public class LibreriaPersonaleControllerGraficoTerminal implements LibreriaPersonaleControllerGrafico {

    LibreriaAppController appController;




    @Override
    public void vistaLibreria() {
        appController = new LibreriaAppController();


        //
    }
}
