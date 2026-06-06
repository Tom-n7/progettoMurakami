package it.tommaso.uniroma2.progettoispw.dao.file;

import it.tommaso.uniroma2.progettoispw.dao.LibroDAO;
import it.tommaso.uniroma2.progettoispw.exception.DAOException;
import it.tommaso.uniroma2.progettoispw.model.IFiltroTestuale;
import it.tommaso.uniroma2.progettoispw.model.Libro;
import it.tommaso.uniroma2.progettoispw.supporto.GeneratoreID;

import java.io.*;
import java.util.List;

public class FileLibroDAO implements LibroDAO {

    private static final String FILE_LIBRI = "resources/libri";

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
        try {
            int idLibro = GeneratoreID.ottieniGeneratore().generaId();
            oggetto.setId(idLibro);

            ObjectOutputStream streamOutputLibro = new ObjectOutputStream(new FileOutputStream(FILE_LIBRI,true));
            streamOutputLibro.writeObject(oggetto);
            streamOutputLibro.close();


        } catch (IOException e) {
            throw new DAOException("Impossibile salvare libro nel filesystem",e);
        }
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
        Libro libro = null;
        try {
           ObjectInputStream streamInputLibro = new ObjectInputStream(new FileInputStream(FILE_LIBRI));

           libro = (Libro) streamInputLibro.readObject();

           streamInputLibro.close();



        } catch (IOException | ClassNotFoundException e  ) {
            throw new DAOException("Impossibile recuperare libro nel filesystem",e);
        }
        return libro;
    }

    @Override
    public void elimina(int id) throws DAOException {
        /*
        Potrebbe essere utile implementarlo in futuro
         */

        throw new UnsupportedOperationException();
    }
}
