package it.tommaso.uniroma2.dao;

import it.tommaso.uniroma2.bean.IBean;
import it.tommaso.uniroma2.exception.DAOException;
import it.tommaso.uniroma2.model.IFiltroTestuale;

import java.util.List;

public interface IRicercabiliDAO<T>{

    public List<T> ottieniTutti() throws DAOException;
    public List<T> ottieniListaFiltrata(IFiltroTestuale<T> filtro) throws DAOException;
    public void salva(T oggetto) throws DAOException;
    public void salvaTutti(List<T> listaOggetti) throws DAOException;
    public T ottieni(int id) throws DAOException;
}
