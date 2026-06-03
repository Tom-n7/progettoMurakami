package it.tommaso.uniroma2.progettoISPW.control;

import it.tommaso.uniroma2.progettoISPW.bean.LibroBean;
import it.tommaso.uniroma2.progettoISPW.dao.LibroDAO;
import it.tommaso.uniroma2.progettoISPW.dao.factory.DAOFactory;
import it.tommaso.uniroma2.progettoISPW.exception.DAOException;
import it.tommaso.uniroma2.progettoISPW.model.Libro;

import java.util.List;

public class ImportaMetadatiLibroController {


    public LibroBean salvaLibro(LibroBean libroBean){


        LibroDAO libroDAO = DAOFactory.ottieniDAOFactory().creaLibroDAO();
        Libro libro = new Libro();

        libro.setTitolo(libroBean.getTitolo());
        libro.setAutori(libroBean.getAutori());
        libro.setEditore(libroBean.getEditore());
        libro.setEdizione(libroBean.getEdizione());
        libro.setCodiceISNB(libroBean.getCodiceISNB());
        libro.setLingua(libroBean.getLingua());

        try {
            libroBean.setId(libroDAO.salva(libro));
        } catch (DAOException e) {
            throw new RuntimeException(e);
        }
        return libroBean;
    }



}
