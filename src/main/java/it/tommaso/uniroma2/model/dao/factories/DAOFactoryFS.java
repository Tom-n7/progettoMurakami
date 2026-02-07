package it.tommaso.uniroma2.model.dao.factories;

import it.tommaso.uniroma2.model.dao.AggiornaLibreriaDAO;
import it.tommaso.uniroma2.model.dao.CaricaLibreriaPersonaleDAO;
import it.tommaso.uniroma2.model.dao.FSAggiornaLibreriaDAO;
import it.tommaso.uniroma2.model.dao.FSCaricaLibreriaPersonaleDAO;

public class DAOFactoryFS extends DAOFactory {

    @Override
    public CaricaLibreriaPersonaleDAO getCaricaLibreriaPersonaleDAO() {
        return new FSCaricaLibreriaPersonaleDAO();
    }

    @Override
    public AggiornaLibreriaDAO getAggiornaLibreriaDAO() {
        return new FSAggiornaLibreriaDAO();
    }
}
