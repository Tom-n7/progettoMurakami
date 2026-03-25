package it.tommaso.uniroma2.gestiscilp.model.dao.db;

import it.tommaso.uniroma2.gestiscilp.exeption.DAOException;
import it.tommaso.uniroma2.gestiscilp.model.LibreriaPersonale;
import it.tommaso.uniroma2.gestiscilp.model.Libro;
import it.tommaso.uniroma2.gestiscilp.model.Scaffale;
import it.tommaso.uniroma2.gestiscilp.model.dao.base.CaricaLibreriaPersonaleDAO;
import it.tommaso.uniroma2.gestiscilp.model.dao.dbconnect.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/*
Oggetto con la responsabilità di restituire la libreria personale del lettore memorizzata
all'interno del database locale del sistema.
 */
public class DBCaricaLibreriaPersonaleDAO extends CaricaLibreriaPersonaleDAO {

    LibreriaPersonale libreria = new LibreriaPersonale();
    List<Scaffale> scaffali = new ArrayList<>();
    List<Libro> lirbriScaffale = new ArrayList<>()

    @Override
    public LibreriaPersonale execute(Object... params) throws DAOException, SQLException {

        try{

            //tenta connessione a DB locale contenente la libreria personale.
            Connection conn = ConnectionFactory.getLibriConnection();
            CallableStatement cs = conn.prepareCall("{call get_scaffali_libreria_personale()}");
            boolean status = cs.execute();

            //il primo set è costituito dagli scaffali
            ResultSet rs = cs.getResultSet();

            //in questo loop viene recuperata la lista di scaffali che costituisce la libreria personale.
            while(rs.next()){
                Scaffale nuovoScaffale = new Scaffale();
                nuovoScaffale.setNomeScaffale(rs.getString(1));

                scaffali.add(nuovoScaffale);
            }

            libreria.setScaffaliLibreria(scaffali);

            //carico i libri del primo scaffale che possono essere mostrati subito.
            Scaffale primoScaffale = scaffali.getFirst();

            //se non ci sono ancora scaffali, non c'è bisogno di caricare i libri
            if(primoScaffale != null) {
                //carico contenuto libri primo scaffale
                cs = conn.prepareCall("{call get_libri_scaffale()}");

                //inserisco nome primo scaffale nella query sql
                cs.setString(1, primoScaffale.getNomeScaffale());
                status = cs.execute();
                rs = cs.getResultSet();
                List<Integer> idLibriContenuti = new ArrayList<>();

                while (rs.next()) {
                    idLibriContenuti.add(rs.getInt(1));
                }




                for(Integer idLibro: idLibriContenuti){

                    Libro libro = new Libro();

                    //di ogni libro importo i dettagli, esclusi copertina e autori.
                    cs = conn.prepareCall("{call get_dettagli_libro()}");
                    cs.setInt(1, idLibro );
                    cs.setString(2, primoScaffale.getNomeScaffale());
                    cs.execute();

                    rs = cs.getResultSet();

                    rs.

                }


            }
            } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return libreria;

    }
}
