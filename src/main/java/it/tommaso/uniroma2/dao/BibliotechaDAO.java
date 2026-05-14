package it.tommaso.uniroma2.dao;

import it.tommaso.uniroma2.exception.DAOException;
import it.tommaso.uniroma2.model.Biblioteca;
import it.tommaso.uniroma2.model.FiltroBiblioteca;
import it.tommaso.uniroma2.model.Indirizzo;
import it.tommaso.uniroma2.model.RegolaPrenotazione;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class BibliotechaDAO implements IDAO<Biblioteca> {
    @Override
    public Biblioteca get(int id) throws DAOException {
        return null;
    }

    @Override
    public void set() throws DAOException {

    }

    @Override
    public List<Biblioteca> getAll() throws DAOException {
        return dummyGenerazioneDatiBiblioteche().stream().toList();
    }

    @Override
    public List<Biblioteca> getFiltered(Object filtro) throws DAOException {

        //per ora non fa filtro

        return dummyGenerazioneDatiBiblioteche().stream().toList();



    }

    private Collection<Biblioteca> dummyGenerazioneDatiBiblioteche(){


        List<Biblioteca> bibliotecheRegistrate = new ArrayList<>(Arrays.stream(new Biblioteca[]{new Biblioteca("1", "Biblioteca Casa della Memoria e della Storia", new Indirizzo("Via di San Francesco di Sales,5", "Roma", "00165"),
                null, List.of(new RegolaPrenotazione[]{(new RegolaPrenotazione(5))}), null),
                new Biblioteca("2", "Biblioteca Casa delle Letterature", new Indirizzo("Piazza dell'Orologio,3", "Roma", "00186"),
                        null, List.of(new RegolaPrenotazione[]{(new RegolaPrenotazione(5))}), null),
                new Biblioteca("3", "Biblioteca Casa delle Traduzioni", new Indirizzo("Via degli Avignonesi,32", "Roma", "00187"),
                        null, List.of(new RegolaPrenotazione[]{(new RegolaPrenotazione(5))}), null)}).toList());

        return bibliotecheRegistrate;


    }
}
