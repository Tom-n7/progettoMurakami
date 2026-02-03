package it.tommaso.uniroma2.controller;

import it.tommaso.uniroma2.bean.CredenzialiBean;

public class LoginAppController {

    public void controlloCredenziali(CredenzialiBean credenziali){

        //avviene il oontrollo
        credenziali.setVerificate(true);
    }


}
