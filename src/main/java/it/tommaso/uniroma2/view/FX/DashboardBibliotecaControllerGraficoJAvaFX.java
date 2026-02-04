package it.tommaso.uniroma2.view.FX;

import it.tommaso.uniroma2.view.DashboardBibliotecaControllerGrafico;

public class DashboardBibliotecaControllerGraficoJAvaFX extends RootPane implements DashboardBibliotecaControllerGrafico {
    @Override
    public void vistaDashboardBiblioteca() {
        cambiaFinestra("/it.tommaso.uniroma2/view/FX/dashboardBiblioteca.fxml");
    }
}
