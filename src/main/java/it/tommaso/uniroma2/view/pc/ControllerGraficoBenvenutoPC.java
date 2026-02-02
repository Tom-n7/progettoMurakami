package it.tommaso.uniroma2.view.pc;

import it.tommaso.uniroma2.view.ControllerGraficoBenvenuto;
import it.tommaso.uniroma2.view.GUIManager;
import javafx.event.ActionEvent;

public class ControllerGraficoBenvenutoPC implements ControllerGraficoBenvenuto {



    public void click(ActionEvent e){
        GUIManager.getGUIManager().cambiaFinestra("pc/dashboardLP.fxml");
    }


}
