package it.tommaso.uniroma2.model.dao.base;


import it.tommaso.uniroma2.exeption.DAOException;
import it.tommaso.uniroma2.model.dao.ProceduraGenericaDAO;

import java.io.IOException;
import java.sql.SQLException;

/*
Incaricata di caricare l'immagine di copertina caricarla in un file disposto opportunamente
al fine di renderla raggiungibile al controller grafico.
Deve gestire IOException.
 */

public abstract class CaricaDettagliLibroDAO implements ProceduraGenericaDAO<String>{

    @Override
    public abstract String execute(Object... params) throws DAOException, SQLException;
}
