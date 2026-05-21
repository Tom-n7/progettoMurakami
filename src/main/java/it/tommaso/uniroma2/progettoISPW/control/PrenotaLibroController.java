package it.tommaso.uniroma2.progettoISPW.control;


import it.tommaso.uniroma2.progettoISPW.bean.BibliotecaBean;
import it.tommaso.uniroma2.progettoISPW.bean.FiltroBibliotecaBean;
import it.tommaso.uniroma2.progettoISPW.dao.BibliotecaDAO;
import it.tommaso.uniroma2.progettoISPW.exception.DAOException;
import it.tommaso.uniroma2.progettoISPW.exception.RicercaException;
import it.tommaso.uniroma2.progettoISPW.model.*;

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

