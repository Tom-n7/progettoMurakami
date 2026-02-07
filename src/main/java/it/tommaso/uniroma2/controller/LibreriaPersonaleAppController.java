package it.tommaso.uniroma2.controller;

import it.tommaso.uniroma2.model.LibreriaPersonale;
import it.tommaso.uniroma2.model.dao.base.CaricaLibreriaPersonaleDAO;
import it.tommaso.uniroma2.model.dao.factories.DAOFactory;

public class LibreriaPersonaleAppController {


    public LibreriaPersonale caricaLibreriaPersonale() {

        LibreriaPersonale libreriaPersonale = null;

        DAOFactory factory = DAOFactory.getFactory();
        CaricaLibreriaPersonaleDAO caricaLibreriaPersonaleDAO = factory.getCaricaLibreriaPersonaleDAO();

        try {
            libreriaPersonale = caricaLibreriaPersonaleDAO.execute();
        } catch (Exception e) {
            System.out.println("errore!");
        }


        return libreriaPersonale;
    }



}
