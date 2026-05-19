package it.tommaso.uniroma2.control;


import it.tommaso.uniroma2.bean.BibliotecaBean;
import it.tommaso.uniroma2.bean.FiltroBibliotecaBean;
import it.tommaso.uniroma2.bean.PrenotazioneBean;
import it.tommaso.uniroma2.dao.BibliotecaDAO;
import it.tommaso.uniroma2.exception.CriterioIllegaleException;
import it.tommaso.uniroma2.exception.DAOException;
import it.tommaso.uniroma2.exception.MaxCaratteriException;
import it.tommaso.uniroma2.exception.RicercaException;
import it.tommaso.uniroma2.model.*;

import java.util.ArrayList;
import java.util.List;

/*
Controller applicativo del caso d'uso prenota libro.
 */
public class PrenotaLibroController {

    public List<BibliotecaBean> caricaBibliotecheRegistrate(FiltroBibliotecaBean filtroBean) throws RuntimeException {


        List<BibliotecaBean> lista = new ArrayList<>();

        try {
            FiltroBiblioteca filtro = new FiltroBiblioteca(filtroBean);

            List<Biblioteca> listaBiblioteche = new BibliotecaDAO().ottieniListaFiltrata(filtro);
            for(Biblioteca b : listaBiblioteche){
                lista.add(new BibliotecaBean(b));
            }
        } catch (DAOException | RicercaException e){
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        return lista;

    }




}

