package it.tommaso.uniroma2.model.dao.base;

import it.tommaso.uniroma2.exeption.DAOException;
import it.tommaso.uniroma2.model.dao.ProceduraGenericaDAO;

import java.sql.SQLException;

public abstract class AggiornaLibreriaDAO implements ProceduraGenericaDAO<String> {
    @Override
    public abstract String execute(Object... params) throws DAOException, SQLException;
}
