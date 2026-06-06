package it.tommaso.uniroma2.progettoispw.dao.demo;

import it.tommaso.uniroma2.progettoispw.dao.LibroDAO;
import it.tommaso.uniroma2.progettoispw.exception.DAOException;
import it.tommaso.uniroma2.progettoispw.model.IFiltroTestuale;
import it.tommaso.uniroma2.progettoispw.model.Libro;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DemoLibroDAO implements LibroDAO {


    private static final Map<Integer, Libro> archivioLibriSessione = new HashMap<Integer, Libro>();
    private static int ultimoIdAssegnato = 1;


    private static int assegnaId(){
        ultimoIdAssegnato++;
        return ultimoIdAssegnato;
    }

    @Override
    public List<Libro> ottieniTutti() throws DAOException {
        return List.of();
    }

    @Override
    public List<Libro> ottieniListaFiltrata(IFiltroTestuale filtro) throws DAOException {
        return List.of();
    }

    @Override
    public int salva(Libro oggetto) throws DAOException {

        oggetto.setId(assegnaId());
        archivioLibriSessione.put(oggetto.getId(), oggetto);
        return oggetto.getId();
    }

    @Override
    public void salvaTutti(List<Libro> listaOggetti) throws DAOException {
        /*
        Potrebbe essere utile implementarlo in futuro
         */

        throw new UnsupportedOperationException();
    }

    @Override
    public Libro ottieni(int id) throws DAOException {
        return archivioLibriSessione.get(id);
    }

    @Override
    public void elimina(int id) throws DAOException {
        archivioLibriSessione.remove(id);
    }
}
