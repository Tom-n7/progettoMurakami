package it.tommaso.uniroma2.gestiscilp.view.FX;

import it.tommaso.uniroma2.gestiscilp.view.DashboardBibliotecaControllerGrafico;
import it.tommaso.uniroma2.view.CGFX;

public class DashboardBibliotecaControllerGraficoJAvaFX extends CGFX implements DashboardBibliotecaControllerGrafico {
    @Override
    public void vistaDashboardBiblioteca() {
        disegnaFinestra("/it.tommaso.uniroma2/view/FX/dashboardBiblioteca.fxml");
    }
}
