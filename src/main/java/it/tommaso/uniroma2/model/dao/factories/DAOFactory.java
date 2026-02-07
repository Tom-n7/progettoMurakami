package it.tommaso.uniroma2.model.dao.factories;

import it.tommaso.uniroma2.model.Sessione;
import it.tommaso.uniroma2.model.dao.base.AggiornaLibreriaDAO;
import it.tommaso.uniroma2.model.dao.base.CaricaDettagliLibroDAO;
import it.tommaso.uniroma2.model.dao.base.CaricaLibreriaPersonaleDAO;
import it.tommaso.uniroma2.model.dao.Modalita;

public abstract class DAOFactory {

    protected DAOFactory(){}

    //a seconda della modalità di interazione con lo strato di persistenza, viene generata la factory adatta.
    public static DAOFactory getFactory(){

        Sessione sessione = Sessione.getSessione();

        if(sessione.getModPersistenza() == Modalita.DATABASE){
            return new DAOFactoryDB();
        }else{
            return new DAOFactoryFS();
        }
    }

    public abstract AggiornaLibreriaDAO getAggiornaLibreriaDAO();

    public abstract CaricaLibreriaPersonaleDAO getCaricaLibreriaPersonaleDAO();

    public abstract CaricaDettagliLibroDAO getCaricaDettagliLibroDAO();
}
