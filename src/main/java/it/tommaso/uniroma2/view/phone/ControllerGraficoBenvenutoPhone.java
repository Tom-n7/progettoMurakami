package it.tommaso.uniroma2.view.phone;

import it.tommaso.uniroma2.view.ControllerGraficoBenvenuto;
import it.tommaso.uniroma2.view.GUIManager;
import javafx.scene.input.MouseEvent;
import jexer.*;

import java.awt.event.ActionEvent;
import java.util.List;

public class ControllerGraficoBenvenutoPhone  implements ControllerGraficoBenvenuto {
    public void click(MouseEvent mouseEvent) {GUIManager.getGUIManager().cambiaFinestra("pc/dashboardLP.fxml");}
}
