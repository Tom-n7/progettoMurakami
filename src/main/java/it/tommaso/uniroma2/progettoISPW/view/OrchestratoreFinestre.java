package it.tommaso.uniroma2.progettoISPW.view;

import it.tommaso.uniroma2.progettoISPW.bean.IBean;
import it.tommaso.uniroma2.progettoISPW.view.finestre_popup.VistaPopup;
import javafx.beans.property.SimpleObjectProperty;

public interface OrchestratoreFinestre {
    public void lanciaVistaCompleta(String nomeVista, IBean... beans);
    public void lanciaVistaPopup(String nomeVista, SimpleObjectProperty... properties);

    public void ricaricaVista();

    public void chiudiFinestraPopup(VistaPopup vistaPopup);
}
