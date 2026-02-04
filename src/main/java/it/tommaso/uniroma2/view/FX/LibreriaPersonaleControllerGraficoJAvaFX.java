package it.tommaso.uniroma2.view.FX;

import it.tommaso.uniroma2.view.LibreriaPersonaleControllerGrafico;

public class LibreriaPersonaleControllerGraficoJAvaFX extends RootPane implements LibreriaPersonaleControllerGrafico {

    @Override
    public void vistaLibreria() {
        cambiaFinestra("/it.tommaso.uniroma2/view/FX/libreriaPersonale.fxml");
    }
}
