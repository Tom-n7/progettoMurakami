package it.tommaso.uniroma2.progettoispw.view.desktop;

import it.tommaso.uniroma2.progettoispw.bean.IBean;
import it.tommaso.uniroma2.progettoispw.view.desktop.finestre_popup.VistaPopup;
import javafx.beans.property.SimpleObjectProperty;

public interface OrchestratoreFinestre {
    public void lanciaVistaCompleta(String nomeVista, IBean... beans);
    public void lanciaVistaPopup(String nomeVista, SimpleObjectProperty... properties);

    public void ricaricaVista();

    public void chiudiFinestraPopup(VistaPopup vistaPopup);
}
