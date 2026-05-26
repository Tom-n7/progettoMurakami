package it.tommaso.uniroma2.progettoISPW.view;

import it.tommaso.uniroma2.progettoISPW.bean.BibliotecaBean;
import it.tommaso.uniroma2.progettoISPW.bean.IBean;
import it.tommaso.uniroma2.progettoISPW.view.finestre_popup.VistaPopup;

import java.util.List;

public interface OrchestratoreFinestre {
    public void lanciaVistaCompleta(String nomeVista);
    public void lanciaVistaPopup(String nomeVista, IBean... beans);


    void chiudiFinestraPopup(VistaPopup vistaPopup);
}
