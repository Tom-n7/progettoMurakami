package it.tommaso.uniroma2.progettoispw.dao.database;

import it.tommaso.uniroma2.progettoispw.dao.BibliotecaDAO;
import it.tommaso.uniroma2.progettoispw.exception.DAOException;
import it.tommaso.uniroma2.progettoispw.model.*;
import it.tommaso.uniroma2.progettoispw.supporto.FactoryConnessioneDatabase;

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
                    indirizzoBiblioteca.setCap(rs.getString("CAP"));

                    biblioteca.setIndirizzo(indirizzoBiblioteca);
                    RegolaPrenotazione regola = new RegolaPrenotazione(rs.getInt("regola_prenotazione"));
                    biblioteca.setRegolaPrenotazione(regola);


                    listaBiblioteche.add(biblioteca);

                }
            }
        } catch (SQLException e) {
            throw new DAOException("Errore caricamento: " + e.getMessage());
        }
        return listaBiblioteche;
    }

    private void filtraBiblioteca(IFiltroTestuale<Biblioteca> filtro, Biblioteca b, List<Biblioteca> listaBibliotecheFiltrata ){

        switch (TipoFiltroBiblioteca.valueOf(filtro.ottieniNomeTipoFiltro())){

            case CITTA -> valutaCitta(b,filtro,listaBibliotecheFiltrata);

            case INDIRIZZO -> valutaIndirizzo(b,filtro,listaBibliotecheFiltrata);

            default -> valutaNome(b,filtro,listaBibliotecheFiltrata);
        }

    }


    private void valutaNome(Biblioteca b, IFiltroTestuale<Biblioteca> filtro, List<Biblioteca> listaBibliotecheFiltrata){
        if(b.getNome().contains(filtro.ottieniTestoRicerca())){
            listaBibliotecheFiltrata.add(b);
        }
    }

    private void valutaCitta(Biblioteca b, IFiltroTestuale<Biblioteca> filtro, List<Biblioteca> listaBibliotecheFiltrata){
        if(b.getIndirizzo().getCitta().contains(filtro.ottieniTestoRicerca())){
            listaBibliotecheFiltrata.add(b);
        }
    }


    private void valutaIndirizzo(Biblioteca b, IFiltroTestuale<Biblioteca> filtro, List<Biblioteca> listaBibliotecheFiltrata){
        if(b.getIndirizzo().toString().contains(filtro.ottieniTestoRicerca())){
            listaBibliotecheFiltrata.add(b);
        }
    }

    @Override
    public List<Biblioteca> ottieniListaFiltrata(IFiltroTestuale<Biblioteca> filtro) throws DAOException {
        List<Biblioteca> listaBibliotecheFiltrata = new ArrayList<>();

        for(Biblioteca b : this.ottieniTutti()){
           filtraBiblioteca(filtro,b,listaBibliotecheFiltrata);
        }

        return listaBibliotecheFiltrata;
    }

    @Override
    public int salva(Biblioteca oggetto) throws DAOException {
        return 0;
    }

    @Override
    public void salvaTutti(List<Biblioteca> listaOggetti) throws DAOException {

        /*
        Ancora da implementare.
         */
        throw new UnsupportedOperationException();
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
            throw new DAOException("Errore recupero biblioteca dal database",e);
        }
        return biblioteca;
    }

    @Override
    public void elimina(int id) throws DAOException {
        /*
        Operazione che potrebbe rivelarsi necessaria ancora non implementata.
         */

        throw new UnsupportedOperationException();
    }
}
