package it.tommaso.uniroma2.gestiscilp.controller;

import it.tommaso.uniroma2.gestiscilp.model.bean.CredenzialiBean;
import it.tommaso.uniroma2.gestiscilp.model.Ruolo;

public class LoginAppController {

    public void controlloCredenziali(CredenzialiBean credenziali){

        //stub reale meccanismo di contrilli
        credenziali.setVerificate(true);

        //sub meccanismo reale assegnazione ruolo.
        credenziali.setRuolo(Ruolo.LETTORE);

    }


}
