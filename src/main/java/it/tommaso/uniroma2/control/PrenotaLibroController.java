package it.tommaso.uniroma2.control;


import it.tommaso.uniroma2.bean.BibliotecaBean;
import it.tommaso.uniroma2.bean.FiltroBibliotecaBean;
import it.tommaso.uniroma2.dao.BibliotechaDAO;
import it.tommaso.uniroma2.exception.CriterioIllegaleException;
import it.tommaso.uniroma2.exception.MaxCaratteriException;
import it.tommaso.uniroma2.exception.QueryRicercaException;
import it.tommaso.uniroma2.model.*;

import java.util.ArrayList;
import java.util.List;

/*
Controller applicativo del caso d'uso prenota libro.
 */
public class PrenotaLibroController {

    public List<BibliotecaBean> caricaBibliotecheRegistrate(FiltroBibliotecaBean filtroBean){


        List<BibliotecaBean> lista = new ArrayList<>();
        FiltroBiblioteca filtro = null;
        try {
            filtro = new FiltroBiblioteca(filtroBean);
        }catch (CriterioIllegaleException e){
            e.printStackTrace();
        }catch (MaxCaratteriException e ){
            e.printStackTrace();
        }catch (QueryRicercaException e){
            e.printStackTrace();
        }

        //rivedere meglio a partire da blocco try.
        for(Biblioteca b : (new BibliotechaDAO()).getFiltered(filtro) ){
            lista.add(new BibliotecaBean(b));
        }
        return lista;

    }

}
