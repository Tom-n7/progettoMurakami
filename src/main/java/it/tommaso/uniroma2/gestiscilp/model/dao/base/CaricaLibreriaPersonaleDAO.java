package it.tommaso.uniroma2.gestiscilp.model.dao.base;

import it.tommaso.uniroma2.gestiscilp.exeption.DAOException;
import it.tommaso.uniroma2.gestiscilp.model.LibreriaPersonale;
import it.tommaso.uniroma2.gestiscilp.model.dao.ProceduraGenericaDAO;

import java.sql.SQLException;

public abstract class CaricaLibreriaPersonaleDAO implements ProceduraGenericaDAO<LibreriaPersonale> {

    @Override
    public abstract LibreriaPersonale execute(Object... params) throws DAOException, SQLException;

}
