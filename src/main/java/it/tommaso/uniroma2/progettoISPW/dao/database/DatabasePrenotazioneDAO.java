package it.tommaso.uniroma2.progettoISPW.dao.database;

import it.tommaso.uniroma2.progettoISPW.dao.PrenotazioneDAO;
import it.tommaso.uniroma2.progettoISPW.exception.DAOException;
import it.tommaso.uniroma2.progettoISPW.model.IFiltroTestuale;
import it.tommaso.uniroma2.progettoISPW.model.Libro;
import it.tommaso.uniroma2.progettoISPW.model.Prenotazione;
import it.tommaso.uniroma2.progettoISPW.supporto.FactoryConnessioneDatabase;

import java.sql.*;
import java.util.Collection;
import java.util.List;

public class DatabasePrenotazioneDAO implements PrenotazioneDAO {
    @Override
    public List<Prenotazione> ottieniTutti() throws DAOException {
        return List.of();
    }

    @Override
    public List<Prenotazione> ottieniListaFiltrata(IFiltroTestuale<Prenotazione> filtro) throws DAOException {
        return List.of();
    }

    @Override
    public int salva(Prenotazione oggetto) throws DAOException {

        int id;
        try{
            Connection con = FactoryConnessioneDatabase.getConnection();
            CallableStatement cs = con.prepareCall("{call salva_prenotazione(?,?,?,?,?)}");
            cs.setInt("arg_id_lettore", oggetto.getLettore().getId());
            cs.setInt("arg_id_biblioteca", oggetto.getBiblioteca().getId());
            cs.setDate("arg_data_creazione", new Date(oggetto.getGiornoPrenotazione().getTime()));
            cs.setString("arg_fase_prenotazione", oggetto.getStatoPrenotazione().toString());
            cs.registerOutParameter("id_prenotazione", Types.NUMERIC);
            cs.executeQuery();
            id = cs.getInt("id_prenotazione");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return id;
    }

    @Override
    public void salvaTutti(List<Prenotazione> listaOggetti) throws DAOException {

    }

    /*

     */
    @Override
    public Prenotazione ottieni(int id) throws DAOException {

        try{
            Connection con = FactoryConnessioneDatabase.getConnection();
            CallableStatement cs = con.prepareCall("{call ottieni_prenotazione(?)}");
            cs.setInt("arg_id", id);
            cs.executeQuery();






        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void elimina(int id) throws DAOException {

    }

    @Override
    public void aggiungiLibroAPrenotazione(Prenotazione prenotazione, Libro libro) throws DAOException {

        try {
            Connection con = FactoryConnessioneDatabase.getConnection();
            CallableStatement cs2 = con.prepareCall("{call abbina_libro_a_prenotazione(?,?)}");
            cs2.setInt("arg_id_libro", libro.getId());
            cs2.setInt("arg_id_prenotazione", prenotazione.getId());
            cs2.executeQuery();
        }catch (SQLException e){
            throw new DAOException("errore abbinamento libro a prenotazione!");
        }
    }
}
