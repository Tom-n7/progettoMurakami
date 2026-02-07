package it.tommaso.uniroma2.model.dao.factories;

import it.tommaso.uniroma2.model.dao.AggiornaLibreriaDAO;
import it.tommaso.uniroma2.model.dao.CaricaLibreriaPersonaleDAO;
import it.tommaso.uniroma2.model.dao.DBAggiornaLibreriaDAO;
import it.tommaso.uniroma2.model.dao.DBCaricaLibreriaPersonaleDAO;

public class DAOFactoryDB extends DAOFactory {

    @Override
    public AggiornaLibreriaDAO getAggiornaLibreriaDAO() {
        return new DBAggiornaLibreriaDAO();
    }

    @Override
    public CaricaLibreriaPersonaleDAO getCaricaLibreriaPersonaleDAO() {
        return new DBCaricaLibreriaPersonaleDAO();
    }
}
