package it.tommaso.uniroma2.progettoISPW.dao.database;

import it.tommaso.uniroma2.progettoISPW.dao.PrenotazioneDAO;
import it.tommaso.uniroma2.progettoISPW.exception.DAOException;
import it.tommaso.uniroma2.progettoISPW.model.*;
import it.tommaso.uniroma2.progettoISPW.supporto.FactoryConnessioneDatabase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabasePrenotazioneDAO implements PrenotazioneDAO {
    @Override
    public List<Prenotazione> ottieniTutti() throws DAOException {
        return List.of();
    }

    @Override
    public List<Prenotazione> ottieniListaFiltrata(IFiltroTestuale<Prenotazione> filtro) throws DAOException {
        try {
            Connection con = FactoryConnessioneDatabase.getConnection();
            CallableStatement cs = con.prepareCall("{call ottieni_tutte_prenotazioni_utente(?)}");
            cs.setString("arg_username_utente", filtro.ottieniTestoRicerca());

            boolean status = cs.execute();

            List<Prenotazione> listaPrenotazioni = new ArrayList<>();
            if (status) {

                int idPrenotazione;
                ResultSet rs = cs.getResultSet();
                while (rs.next()){

                    idPrenotazione = rs.getInt("id");
                    listaPrenotazioni.add(ottieni(idPrenotazione));

                }

            }
            return listaPrenotazioni;
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
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

    @Override
    public Prenotazione ottieni(int id) throws DAOException {

        Prenotazione prenotazione = new Prenotazione();
        try{
            Connection con = FactoryConnessioneDatabase.getConnection();
            CallableStatement cs = con.prepareCall("{call ottieni_prenotazione(?)}");
            cs.setInt("arg_id", id);

            boolean status = cs.execute();


            Lettore lettore = new Lettore();
            Biblioteca biblioteca = new Biblioteca();

            List<Libro> libri = new ArrayList<>();

            if(status){
               ResultSet rs = cs.getResultSet();
               rs.next();


               lettore.setId(rs.getInt("id_lettore"));
               lettore.setNome(rs.getString("nome_lettore"));
               lettore.setUsername(rs.getString("username"));
               lettore.setUsername(rs.getString("indirizzo_email"));

               biblioteca.setId(rs.getInt("id_biblioteca"));
               biblioteca.setRegolaPrenotazione(new RegolaPrenotazione(rs.getInt("regola_prenotazione")));
               biblioteca.setIndirizzo(new Indirizzo(rs.getString("via"),
                               rs.getString("citta"),
                               rs.getString("cap")));
               biblioteca.setImmagineAnteprima(rs.getBlob("immagine_anteprima"));
               biblioteca.setNome(rs.getString("nome_biblioteca"));


               prenotazione.setId(rs.getInt("id_prenotazione"));
               prenotazione.setBiblioteca(biblioteca);
               prenotazione.setLettore(lettore);
               prenotazione.setGiornoPrenotazione(rs.getDate("data_creazione"));
               prenotazione.setStatoPrenotazione(FaseDiPrenotazione.valueOf((rs.getString("fase_prenotazione")).toUpperCase()));

            }

            status = cs.getMoreResults();

            if(status){
                ResultSet rs = cs.getResultSet();

                /*
                Un libro può avere più autori, quando questo accade, vi sono diversi result set in cui i dati del libro
                sono identici e solo il nome autore differisce. Fino a quando l'id del libro in un rs è uguale al precedente,
                vuol dire che c'è un altro autore per lo stesso libro.
                 */
                Libro libro = new Libro();
                int scorsoLibroID = 0;
                while (rs.next()) {
                    if(rs.getInt("id") != scorsoLibroID) {
                        scorsoLibroID = rs.getInt("id");
                        libro = new Libro();

                        libro.setId(rs.getInt("id"));
                        libro.setImmagineCopertina(rs.getBlob("immagine_copertina"));
                        libro.setTitolo(rs.getString("titolo"));
                        libro.setEdizione(rs.getString("edizione"));
                        libro.setEditore(rs.getString("editore"));
                        libro.setImmagineCopertina(rs.getBlob("immagine_copertina"));
                        libro.setLingua(rs.getString("lingua"));
                        libro.setCodiceISNB("codice_ISNB");
                        libro.setAutori(new ArrayList<>());
                        libro.addAutore(rs.getString("nome_autore"));
                        libri.add(libro);
                    }else {
                        libro.addAutore(rs.getString("nome_autore"));
                    }
                }
                prenotazione.setLibri(libri);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return prenotazione;
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



    @Override
    public void aggiornaStatoPrenotazione(FaseDiPrenotazione nuovoStato, int idPrenotazione) {

        try{
            Connection con = FactoryConnessioneDatabase.getConnection();
            CallableStatement cs




        }catch (SQLException e) {
            throw new RuntimeException(e);
        }



    }


}
