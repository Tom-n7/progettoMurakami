package it.tommaso.uniroma2.gestiscilp.model;

import it.tommaso.uniroma2.gestiscilp.model.dao.Modalita;
import it.tommaso.uniroma2.gestiscilp.view.GUIType;

public class Sessione {

    private Modalita modPersistenza;
    private GUIType modGrafica;
    private static Sessione istanza;


    private Sessione() {
        super();
    }

    public static Sessione getSessione() {
        if (istanza == null) {
            istanza = new Sessione();
        }
        return istanza;

    }
        public void setModPersistenza (Modalita mod) {
            modPersistenza = mod;
        }

        public void setModGrafica(GUIType mod){
            modGrafica = mod;
        }

    public GUIType getModGrafica() {
        return modGrafica;
    }

    public Modalita getModPersistenza() {
        return modPersistenza;
    }
}

