package it.tommaso.uniroma2.progettoispw.dao;

import it.tommaso.uniroma2.progettoispw.exception.DAOException;
import it.tommaso.uniroma2.progettoispw.model.IFiltroTestuale;

import java.util.List;

public interface IRicercabiliDAO<T>{

    public List<T> ottieniTutti() throws DAOException;
    public List<T> ottieniListaFiltrata(IFiltroTestuale filtro) throws DAOException;
    public int salva(T oggetto) throws DAOException;
    public void salvaTutti(List<T> listaOggetti) throws DAOException;
    public T ottieni(int id) throws DAOException;
    public void elimina(int id) throws DAOException;
}
