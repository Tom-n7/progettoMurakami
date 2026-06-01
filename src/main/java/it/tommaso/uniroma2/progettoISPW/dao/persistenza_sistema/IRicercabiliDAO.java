package it.tommaso.uniroma2.progettoISPW.dao.persistenza_sistema;

import it.tommaso.uniroma2.progettoISPW.exception.DAOException;
import it.tommaso.uniroma2.progettoISPW.model.IFiltroTestuale;

import java.util.List;

public interface IRicercabiliDAO<T>{

    public List<T> ottieniTutti() throws DAOException;
    public List<T> ottieniListaFiltrata(IFiltroTestuale<T> filtro) throws DAOException;
    public int salva(T oggetto) throws DAOException;
    public void salvaTutti(List<T> listaOggetti) throws DAOException;
    public T ottieni(int id) throws DAOException;
    public void elimina(int id) throws DAOException;
}
