package it.tommaso.uniroma2.progettoispw.dao.database;

import it.tommaso.uniroma2.progettoispw.dao.LettoreDAO;
import it.tommaso.uniroma2.progettoispw.exception.DAOException;
import it.tommaso.uniroma2.progettoispw.model.*;
import it.tommaso.uniroma2.progettoispw.supporto.FactoryConnessioneDatabase;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DatabaseLettoreDAO implements LettoreDAO {
    @Override
    public List<Lettore> ottieniTutti() throws DAOException {
        return List.of();
    }

    @Override
    public List<Lettore> ottieniListaFiltrata(IFiltroTestuale<Lettore> filtro) throws DAOException {
        return List.of();
    }

    @Override
    public int salva(Lettore oggetto) throws DAOException {
        return 0;
    }

    @Override
    public void salvaTutti(List<Lettore> listaOggetti) throws DAOException {

    }

    @Override
    public Lettore ottieni(int id) throws DAOException {
        Lettore lettore = null;
        CallableStatement cs = null;
        try {
            Connection conn = FactoryConnessioneDatabase.getConnection();
            cs = conn.prepareCall("{call ottieni_lettore(?)}");

            cs.setInt(1,id);

            boolean status = cs.execute();

            if (status) {

                ResultSet rs = cs.getResultSet();
                rs.next();
                lettore = new Lettore(  rs.getInt("id"),
                                        rs.getString("nome"),
                                        rs.getString("indirizzo_email"),
                                        rs.getString("username")
                );

            }



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lettore;
    }

    @Override
    public void elimina(int id) throws DAOException {

    }
}
