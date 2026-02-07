package it.tommaso.uniroma2.model.dao.factories;

import it.tommaso.uniroma2.model.dao.base.AggiornaLibreriaDAO;
import it.tommaso.uniroma2.model.dao.base.CaricaDettagliLibroDAO;
import it.tommaso.uniroma2.model.dao.base.CaricaLibreriaPersonaleDAO;
import it.tommaso.uniroma2.model.dao.db.DBAggiornaLibreriaDAO;
import it.tommaso.uniroma2.model.dao.db.DBCaricaDettagliLibroDAO;
import it.tommaso.uniroma2.model.dao.db.DBCaricaLibreriaPersonaleDAO;

public class DAOFactoryDB extends DAOFactory {

    @Override
    public AggiornaLibreriaDAO getAggiornaLibreriaDAO() {
        return new DBAggiornaLibreriaDAO();
    }

    @Override
    public CaricaLibreriaPersonaleDAO getCaricaLibreriaPersonaleDAO() {
        return new DBCaricaLibreriaPersonaleDAO();
    }

    @Override
    public CaricaDettagliLibroDAO getCaricaDettagliLibroDAO() {
        return new DBCaricaDettagliLibroDAO();
    }
}
