package it.tommaso.uniroma2.progettoispw.dao.database;

import it.tommaso.uniroma2.progettoispw.dao.LibroDAO;
import it.tommaso.uniroma2.progettoispw.exception.DAOException;
import it.tommaso.uniroma2.progettoispw.model.IFiltroTestuale;
import it.tommaso.uniroma2.progettoispw.model.Libro;
import it.tommaso.uniroma2.progettoispw.supporto.FactoryConnessioneDatabase;

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

            CallableStatement cs2;
            cs2 = con.prepareCall("{call salva_autore_libro(?,?)}");
            cs2.setInt("arg_id_libro", id);
            for(String a: oggetto.getAutori()) {
                cs2.setString("arg_nome_autore", a);
                cs2.execute();
            }


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
