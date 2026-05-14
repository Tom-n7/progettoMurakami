package it.tommaso.uniroma2.dao;

public interface IDAOFactory<E>{

    public IDAO<E> fornisciDAO();
}
