package it.tommaso.uniroma2.gestiscilp.view.FX;

import it.tommaso.uniroma2.gestiscilp.view.DashboardBibliotecaControllerGrafico;

public class DashboardBibliotecaControllerGraficoJAvaFX extends ControllerGrafico implements DashboardBibliotecaControllerGrafico {
    @Override
    public void vistaDashboardBiblioteca() {
        disegnaFinestra("/it.tommaso.uniroma2/view/FX/dashboardBiblioteca.fxml");
    }
}
