package it.tommaso.uniroma2.model.dao;

import it.tommaso.uniroma2.exeption.DAOException;
import it.tommaso.uniroma2.model.LibreriaPersonale;

import java.sql.SQLException;

public class DBCaricaLibreriaPersonaleDAO extends CaricaLibreriaPersonaleDAO {

    @Override
    public LibreriaPersonale execute(Object... params) throws DAOException, SQLException {

        LibreriaPersonale libreria = new LibreriaPersonale();
        return libreria;

    }
}
