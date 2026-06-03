package it.tommaso.uniroma2.progettoISPW.dao.database;

import it.tommaso.uniroma2.progettoISPW.dao.LibroDAO;
import it.tommaso.uniroma2.progettoISPW.exception.DAOException;
import it.tommaso.uniroma2.progettoISPW.model.IFiltroTestuale;
import it.tommaso.uniroma2.progettoISPW.model.Libro;
import it.tommaso.uniroma2.progettoISPW.supporto.FactoryConnessioneDatabase;

import java.sql.*;
import java.util.List;

public class DatabaseLibroDAO implements LibroDAO {
    @Override
    public List<Libro> ottieniTutti() throws DAOException {
        return List.of();
    }

    @Override
    public List<Libro> ottieniListaFiltrata(IFiltroTestuale<Libro> filtro) throws DAOException {
        return List.of();
    }

    @Override
    public int salva(Libro oggetto) throws DAOException {
        int id;
        try{

            Connection con = FactoryConnessioneDatabase.getConnection();
            CallableStatement cs = con.prepareCall("{call salva_libro(?,?,?,?,?,?,?)}");
            cs.setString("arg_titolo", oggetto.getTitolo());
            cs.setString("arg_lingua", oggetto.getLingua());
            cs.setString("arg_editore", oggetto.getEditore());
            cs.setBlob("arg_immagine_copertina", oggetto.getImmagineCopertina());
            cs.setString("arg_edizione", oggetto.getEdizione());
            cs.setString("arg_codice_ISNB", oggetto.getCodiceISNB());

            cs.registerOutParameter("id_libro", Types.NUMERIC);
            cs.executeQuery();
            id = cs.getInt("id_libro");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return id;
    }

    @Override
    public void salvaTutti(List<Libro> listaOggetti) throws DAOException {

    }

    @Override
    public Libro ottieni(int id) throws DAOException {
        return null;
    }

    @Override
    public void elimina(int id) throws DAOException {

    }
}
