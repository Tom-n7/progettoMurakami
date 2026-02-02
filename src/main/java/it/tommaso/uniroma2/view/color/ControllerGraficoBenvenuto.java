package it.tommaso.uniroma2.view.color;

import it.tommaso.uniroma2.view.GUIManager;
import javafx.event.ActionEvent;

public class ControllerGraficoBenvenuto {

    public void click(ActionEvent e){
        GUIManager.getGUIManager().cambiaFinestra("color/dashboardLP.fxml");
    }


}
