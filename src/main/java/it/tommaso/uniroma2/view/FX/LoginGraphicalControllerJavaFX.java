package it.tommaso.uniroma2.view.FX;

import it.tommaso.uniroma2.controller.LoginAppController;
import it.tommaso.uniroma2.view.LoginGraphicalController;

public class LoginGraphicalControllerJavaFX extends RootPane implements LoginGraphicalController  {

    private final LoginAppController controllerApplicativo = new LoginAppController();

    public void vistaLogin(){
        cambiaFinestra("/it.tommaso.uniroma2/view/FX/login.fxml");
    }
}
