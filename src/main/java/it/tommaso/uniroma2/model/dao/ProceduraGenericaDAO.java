package it.tommaso.uniroma2.model.dao;

import it.tommaso.uniroma2.exeption.DAOException;

import java.sql.SQLException;

public interface ProceduraGenericaDAO<P> {

    P execute(Object... params) throws DAOException, SQLException;

}
