package it.tommaso.uniroma2.dao;

import it.tommaso.uniroma2.exception.DAOException;

import java.util.List;

public interface IDAO<E>{

    public E get(int id) throws DAOException;

    public void set() throws DAOException;

    public List<E> getAll() throws DAOException;

    public List<E> getFiltered(Object filtro) throws DAOException;
}
