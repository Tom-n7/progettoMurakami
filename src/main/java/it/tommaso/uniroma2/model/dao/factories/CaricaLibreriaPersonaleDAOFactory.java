package it.tommaso.uniroma2.model.dao.factories;

import it.tommaso.uniroma2.model.Sessione;
import it.tommaso.uniroma2.model.dao.Modalita;

public abstract class CaricaLibreriaPersonaleDAOFactory {

    //a seconda della modalità di interazione con lo strato di persistenza, viene generata la factory adatta.
    public static CaricaLibreriaPersonaleDAOFactory getFactory(){

        Sessione sessione = Sessione.getSessione();

        if(sessione.getModPersistenza() == Modalita.DATABASE){
            return new CaricaLibreriaPersonaleDAOFactoryDB();
        }else{
            return new CaricaLibreriaPersonaleDAOFactoryFS();
        }
    }

}
