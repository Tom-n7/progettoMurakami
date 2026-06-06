package it.tommaso.uniroma2.progettoispw.dao.demo;

import it.tommaso.uniroma2.progettoispw.dao.BibliotecaDAO;
import it.tommaso.uniroma2.progettoispw.exception.DAOException;
import it.tommaso.uniroma2.progettoispw.model.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class DemoBibliotecaDAO implements BibliotecaDAO {

    //provvisorio.
    private Collection<Biblioteca> dummyGenerazioneDatiBiblioteche(){


         return new ArrayList<>(Arrays.stream(new Biblioteca[]{new Biblioteca(1, "Biblioteca Casa della Memoria e della Storia", new Indirizzo("Via di San Francesco di Sales,5", "Roma", "00165"),
                null, new RegolaPrenotazione(5), null),
                new Biblioteca(2, "Biblioteca Casa delle Letterature", new Indirizzo("Piazza dell'Orologio,3", "Roma", "00186"),
                        null, new RegolaPrenotazione(5), null),
                new Biblioteca(3, "Biblioteca Casa delle Traduzioni", new Indirizzo("Via degli Avignonesi,32", "Roma", "00187"),
                        null, new RegolaPrenotazione(5), null),
                new Biblioteca(4, "Biblioteca Nazionale Centrale di Firenze", new Indirizzo("Piazza dei Cavalleggeri, 1","Firenze", "50122"),
                        null, new RegolaPrenotazione(5), null),
                new Biblioteca(5, "Biblioteca Nazionale Centrale di Roma", new Indirizzo("Via Castro Pretorio, 105", "Roma", "00185"),
                        null, new RegolaPrenotazione(5), null)

        }).toList());

    }

    @Override
    public List<Biblioteca> ottieniTutti() throws DAOException {
        return dummyGenerazioneDatiBiblioteche().stream().toList();
    }


    private void valutaNome(Biblioteca b, IFiltroTestuale filtro, List<Biblioteca> listaBibliotecheFiltrata){
        if(b.getNome().contains(filtro.ottieniTestoRicerca())){
            listaBibliotecheFiltrata.add(b);
        }
    }

    private void valutaCitta(Biblioteca b, IFiltroTestuale filtro, List<Biblioteca> listaBibliotecheFiltrata){
        if(b.getIndirizzo().getCitta().contains(filtro.ottieniTestoRicerca())){
            listaBibliotecheFiltrata.add(b);
        }
    }


    private void valutaIndirizzo(Biblioteca b, IFiltroTestuale filtro, List<Biblioteca> listaBibliotecheFiltrata){
        if(b.getIndirizzo().toString().contains(filtro.ottieniTestoRicerca())){
            listaBibliotecheFiltrata.add(b);
        }
    }

    @Override
    public List<Biblioteca> ottieniListaFiltrata(IFiltroTestuale filtro) throws DAOException {


        //Provvisoriamente filtra il DAO, verrà sostituato da procedura db opportuna.
        List<Biblioteca> listaBibliotecheFiltrata = new ArrayList<>();

        for(Biblioteca b : dummyGenerazioneDatiBiblioteche()){

            switch (TipoFiltroBiblioteca.valueOf(filtro.ottieniNomeTipoFiltro())){

                case CITTA -> valutaCitta(b,filtro,listaBibliotecheFiltrata);

                case INDIRIZZO -> valutaIndirizzo(b,filtro,listaBibliotecheFiltrata);

                default -> valutaNome(b,filtro,listaBibliotecheFiltrata);
            }
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
        Potrebbe essere utile implementarlo in futuro
         */

        throw new UnsupportedOperationException();

    }

    @Override
    public Biblioteca ottieni(int id) throws DAOException {

        for(Biblioteca b : dummyGenerazioneDatiBiblioteche()){
            if(b.getId() == id){
                return b;
            }
        }
        return null;
    }

    @Override
    public void elimina(int id) throws DAOException {

        /*
        Potrebbe essere utile implementarlo in futuro
         */

        throw new UnsupportedOperationException();

    }
}
