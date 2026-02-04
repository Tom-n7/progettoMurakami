package it.tommaso.uniroma2.view.FX;

import it.tommaso.uniroma2.bean.CredenzialiBean;
import it.tommaso.uniroma2.controller.LoginAppController;
import it.tommaso.uniroma2.view.DashboardBibliotecaControllerGrafico;
import it.tommaso.uniroma2.view.LoginControllerGrafico;
import javafx.event.ActionEvent;


/*
Oggetto con la responsabilità di gestire l'aspetto grafico della procedura di login.
 */
public class LoginControllerGraficoJavaFX extends RootPane implements LoginControllerGrafico {

    private final LoginAppController controllerApplicativo = new LoginAppController();

    public void vistaLogin(){
        cambiaFinestra("/it.tommaso.uniroma2/view/FX/login.fxml");
    }


    //gestisce la pressione del tasto accedi da parte dell'utente.
    public void accedi(ActionEvent e){

        CredenzialiBean credenziali = new CredenzialiBean();


        //PROVVISORIO---
        credenziali.setPassword("123");
        credenziali.setUsername("ziofolletto");
        //----------------


        //
        controllerApplicativo.controlloCredenziali(credenziali);
        if(credenziali.getVerificate()){

            switch (credenziali.getRuolo()){

                case LETTORE ->  new LibreriaPersonaleControllerGraficoJAvaFX().vistaLibreria();
                case BIBLIOTECARIO -> new DashboardBibliotecaControllerGraficoJAvaFX().vistaDashboardBiblioteca();


            }

        }

    }


}
