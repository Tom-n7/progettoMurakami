package it.tommaso.uniroma2.progettoISPW.dao.database;

import it.tommaso.uniroma2.progettoISPW.dao.BibliotecaDAO;
import it.tommaso.uniroma2.progettoISPW.exception.DAOException;
import it.tommaso.uniroma2.progettoISPW.model.*;
import it.tommaso.uniroma2.progettoISPW.supporto.FactoryConnessioneDatabase;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseBibliotecaDAO implements BibliotecaDAO {


    @Override
    public List<Biblioteca> ottieniTutti() throws DAOException {

        List<Biblioteca> listaBiblioteche = new ArrayList<>();
        CallableStatement cs = null;
        try {
            Connection conn = FactoryConnessioneDatabase.getConnection();
            cs = conn.prepareCall("{call ottieni_tutte_biblioteche()}");

            // Esegui la stored procedure
            boolean status = cs.execute();

            // Controllo esecuzione
            if(status) {
                ResultSet rs = cs.getResultSet();

                // Itera attraverso il ResultSet e popola la lista di biblioteche
                while (rs.next()) {
                    Biblioteca biblioteca = new Biblioteca();
                    Indirizzo indirizzoBiblioteca = new Indirizzo();

                    biblioteca.setNome(rs.getString("nome"));
                    biblioteca.setId(rs.getInt("id"));

                    indirizzoBiblioteca.setVia(rs.getString("via"));
                    indirizzoBiblioteca.setCitta(rs.getString("citta"));
                    indirizzoBiblioteca.setCAP(rs.getString("CAP"));

                    biblioteca.setIndirizzo(indirizzoBiblioteca);
                    RegolaPrenotazione regola = new RegolaPrenotazione(rs.getInt("regola_prenotazione"));
                    biblioteca.setRegolePrenotazione(regola);


                    listaBiblioteche.add(biblioteca);

                }
            }
        } catch (SQLException e) {
            throw new DAOException("Errore caricamento: " + e.getMessage());
        }
        return listaBiblioteche;
    }

    @Override
    public List<Biblioteca> ottieniListaFiltrata(IFiltroTestuale<Biblioteca> filtro) throws DAOException {
        List<Biblioteca> listaBibliotecheFiltrata = new ArrayList<>();


        String tipoFiltro = filtro.ottieniNomeTipoFiltro();
        for(Biblioteca b : this.ottieniTutti()){
            switch (TipoFiltroBiblioteca.valueOf(tipoFiltro)){
                case NOME: {
                    if(b.getNome().contains(filtro.ottieniTestoRicerca())){
                        listaBibliotecheFiltrata.add(b);
                    }
                }; break;

                case CITTA: {
                    if(b.getIndirizzo().getCitta().contains(filtro.ottieniTestoRicerca())){
                        listaBibliotecheFiltrata.add(b);
                    }; break;
                }
                case INDIRIZZO: {
                    if(b.getIndirizzo().toString().contains(filtro.ottieniTestoRicerca())){
                        listaBibliotecheFiltrata.add(b);
                    }; break;
                }
            }
        };

        return listaBibliotecheFiltrata;
    }

    @Override
    public int salva(Biblioteca oggetto) throws DAOException {
        return 0;
    }

    @Override
    public void salvaTutti(List<Biblioteca> listaOggetti) throws DAOException {

    }

    @Override
    public Biblioteca ottieni(int id) throws DAOException {

        Biblioteca biblioteca = null;
        CallableStatement cs = null;
        try {
            Connection conn = FactoryConnessioneDatabase.getConnection();
            cs = conn.prepareCall("{call ottieni_biblioteca(?)}");

            cs.setInt(1,id);

            boolean status = cs.execute();

            if (status) {

                ResultSet rs = cs.getResultSet();
                rs.next();
                biblioteca = new Biblioteca(rs.getInt("id"),
                                            rs.getString("nome"),
                                            new Indirizzo(rs.getString("via"),
                                                          rs.getString("citta"),
                                                          rs.getString("cap")),
                                            rs.getBlob("immagine_anteprima"),
                                            new RegolaPrenotazione(rs.getInt("regola_prenotazione")),

                                            null);
            }



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return biblioteca;
    }

    @Override
    public void elimina(int id) throws DAOException {

    }
}
