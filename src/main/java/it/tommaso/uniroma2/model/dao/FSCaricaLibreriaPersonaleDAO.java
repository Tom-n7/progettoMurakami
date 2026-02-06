package it.tommaso.uniroma2.model.dao;

import it.tommaso.uniroma2.exeption.DAOException;
import it.tommaso.uniroma2.model.LibreriaPersonale;

import java.sql.SQLException;

public class FSCaricaLibreriaPersonaleDAO extends CaricaLibreriaPersonaleDAO{
    @Override
    public LibreriaPersonale execute(Object... params) throws DAOException, SQLException {
        return null;
    }
}
