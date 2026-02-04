package it.tommaso.uniroma2.controller;

import it.tommaso.uniroma2.bean.CredenzialiBean;
import it.tommaso.uniroma2.model.Ruolo;

public class LoginAppController {

    public void controlloCredenziali(CredenzialiBean credenziali){

        //stub reale meccanismo di contrilli
        credenziali.setVerificate(true);

        //sub meccanismo reale assegnazione ruolo.
        credenziali.setRuolo(Ruolo.LETTORE);

    }


}
