package it.tommaso.uniroma2.model.dao.factories;

import it.tommaso.uniroma2.model.dao.base.AggiornaLibreriaDAO;
import it.tommaso.uniroma2.model.dao.base.CaricaDettagliLibroDAO;
import it.tommaso.uniroma2.model.dao.base.CaricaLibreriaPersonaleDAO;
import it.tommaso.uniroma2.model.dao.fs.FSAggiornaLibreriaDAO;
import it.tommaso.uniroma2.model.dao.fs.FSCaricaDettagliLibroDAO;
import it.tommaso.uniroma2.model.dao.fs.FSCaricaLibreriaPersonaleDAO;

public class DAOFactoryFS extends DAOFactory {

    @Override
    public CaricaLibreriaPersonaleDAO getCaricaLibreriaPersonaleDAO() {
        return new FSCaricaLibreriaPersonaleDAO();
    }

    @Override
    public AggiornaLibreriaDAO getAggiornaLibreriaDAO() {
        return new FSAggiornaLibreriaDAO();
    }

    @Override
    public CaricaDettagliLibroDAO getCaricaDettagliLibroDAO() {
        return new FSCaricaDettagliLibroDAO();
    }
}
