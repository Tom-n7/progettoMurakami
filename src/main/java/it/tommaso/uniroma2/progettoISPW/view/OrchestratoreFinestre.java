package it.tommaso.uniroma2.progettoISPW.view;

import it.tommaso.uniroma2.progettoISPW.view.finestre_popup.VistaPopup;

public interface OrchestratoreFinestre {
    public void lanciaVistaCompleta(String nomeVista);
    public void lanciaVistaPopup(String nomeVista);


    void chiudiFinestraPopup(VistaPopup vistaPopup);
}
