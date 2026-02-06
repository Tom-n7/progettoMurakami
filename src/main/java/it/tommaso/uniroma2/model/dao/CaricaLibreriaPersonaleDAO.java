package it.tommaso.uniroma2.model.dao;

import it.tommaso.uniroma2.exeption.DAOException;
import it.tommaso.uniroma2.model.LibreriaPersonale;

import java.sql.SQLException;

public abstract class CaricaLibreriaPersonaleDAO implements ProceduraGenericaDAO<LibreriaPersonale> {

    @Override
    public abstract LibreriaPersonale execute(Object... params) throws DAOException, SQLException;

}
