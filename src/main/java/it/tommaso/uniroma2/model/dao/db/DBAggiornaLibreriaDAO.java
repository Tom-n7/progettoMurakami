package it.tommaso.uniroma2.model.dao.db;

import it.tommaso.uniroma2.exeption.DAOException;
import it.tommaso.uniroma2.model.dao.base.AggiornaLibreriaDAO;

import java.sql.SQLException;

public class DBAggiornaLibreriaDAO extends AggiornaLibreriaDAO {
    @Override
    public String execute(Object... params) throws DAOException, SQLException {
        return "";
    }
}
