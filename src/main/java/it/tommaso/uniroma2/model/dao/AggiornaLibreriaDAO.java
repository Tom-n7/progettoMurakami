package it.tommaso.uniroma2.model.dao;

import it.tommaso.uniroma2.exeption.DAOException;

import java.sql.SQLException;

public abstract class AggiornaLibreriaDAO implements ProceduraGenericaDAO<String>{
    @Override
    public abstract String execute(Object... params) throws DAOException, SQLException;
}
