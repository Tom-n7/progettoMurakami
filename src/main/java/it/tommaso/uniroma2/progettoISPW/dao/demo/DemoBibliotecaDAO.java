package it.tommaso.uniroma2.progettoISPW.dao.demo;

import it.tommaso.uniroma2.progettoISPW.dao.BibliotecaDAO;
import it.tommaso.uniroma2.progettoISPW.dao.IRicercabiliDAO;
import it.tommaso.uniroma2.progettoISPW.exception.DAOException;
import it.tommaso.uniroma2.progettoISPW.model.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class DemoBibliotecaDAO implements BibliotecaDAO {

    //provvisorio.
    private Collection<Biblioteca> dummyGenerazioneDatiBiblioteche(){


        List<Biblioteca> bibliotecheRegistrate = new ArrayList<>(Arrays.stream(new Biblioteca[]{new Biblioteca(1, "Biblioteca Casa della Memoria e della Storia", new Indirizzo("Via di San Francesco di Sales,5", "Roma", "00165"),
                null, List.of(new RegolaPrenotazione[]{(new RegolaPrenotazione(5))}), null),
                new Biblioteca(2, "Biblioteca Casa delle Letterature", new Indirizzo("Piazza dell'Orologio,3", "Roma", "00186"),
                        null, List.of(new RegolaPrenotazione[]{(new RegolaPrenotazione(5))}), null),
                new Biblioteca(3, "Biblioteca Casa delle Traduzioni", new Indirizzo("Via degli Avignonesi,32", "Roma", "00187"),
                        null, List.of(new RegolaPrenotazione[]{(new RegolaPrenotazione(5))}), null),
                new Biblioteca(4, "Biblioteca Nazionale Centrale di Firenze", new Indirizzo("Piazza dei Cavalleggeri, 1","Firenze", "50122"),
                        null, List.of(new RegolaPrenotazione[]{(new RegolaPrenotazione(5))}), null),
                new Biblioteca(5, "Biblioteca Nazionale Centrale di Roma", new Indirizzo("Via Castro Pretorio, 105", "Roma", "00185"),
                        null, List.of(new RegolaPrenotazione[]{(new RegolaPrenotazione(5))}), null)

        }).toList());
        return bibliotecheRegistrate;
    }

    @Override
    public List<Biblioteca> ottieniTutti() throws DAOException {
        return dummyGenerazioneDatiBiblioteche().stream().toList();
    }

    @Override
    public List<Biblioteca> ottieniListaFiltrata(IFiltroTestuale<Biblioteca> filtro) throws DAOException {

        List<Biblioteca> listaBibliotecheFiltrata = new ArrayList<>();


        String tipoFiltro = filtro.ottieniNomeTipoFiltro();
        for(Biblioteca b : dummyGenerazioneDatiBiblioteche()){
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

        //provvisorio
        Biblioteca bibliotecaOttenuta;
        for(Biblioteca b : dummyGenerazioneDatiBiblioteche()){
            if(b.getId() == id){
                return b;
            }
        }
        return null;
    }

    @Override
    public void elimina(int id) throws DAOException {

    }
}
