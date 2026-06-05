package it.tommaso.uniroma2.progettoispw.control;

import it.tommaso.uniroma2.progettoispw.bean.LibroBean;
import it.tommaso.uniroma2.progettoispw.dao.LibroDAO;
import it.tommaso.uniroma2.progettoispw.dao.factory.DAOFactory;
import it.tommaso.uniroma2.progettoispw.exception.DAOException;
import it.tommaso.uniroma2.progettoispw.model.Libro;

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
