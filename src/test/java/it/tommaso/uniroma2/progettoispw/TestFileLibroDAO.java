package it.tommaso.uniroma2.progettoispw;

import it.tommaso.uniroma2.progettoispw.bean.LibroBean;
import it.tommaso.uniroma2.progettoispw.dao.file.FileLibroDAO;
import it.tommaso.uniroma2.progettoispw.model.Libro;
import it.tommaso.uniroma2.progettoispw.supporto.GeneratoreID;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestFileLibroDAO {


    @Test void testSalvaLibro() throws IOException {


        Libro libro = new Libro();
        libro.setAutori(List.of("prova"));
        libro.setEditore("prova editoer");
        libro.setEdizione("prova");
        libro.setLingua("italiano");
        libro.setTitolo("TITOLO PROVA");
        libro.setCodiceISNB("1234567890987");

        FileLibroDAO fileLibroDAO = new FileLibroDAO();
        libro.setId(fileLibroDAO.salva(libro));

        Libro libroOttenuto = fileLibroDAO.ottieni(libro.getId());
        assertEquals(libro.getTitolo(),libroOttenuto.getTitolo());






    }



}
