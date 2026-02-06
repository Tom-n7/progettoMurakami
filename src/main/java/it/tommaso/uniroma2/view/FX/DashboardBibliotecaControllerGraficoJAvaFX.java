package it.tommaso.uniroma2.view.FX;

import it.tommaso.uniroma2.view.DashboardBibliotecaControllerGrafico;

public class DashboardBibliotecaControllerGraficoJAvaFX extends ControllerGrafico implements DashboardBibliotecaControllerGrafico {
    @Override
    public void vistaDashboardBiblioteca() {
        disegnaFinestra("/it.tommaso.uniroma2/view/FX/dashboardBiblioteca.fxml");
    }
}
