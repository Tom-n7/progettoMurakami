package it.tommaso.uniroma2.progettoISPW.model;

import it.tommaso.uniroma2.progettoISPW.bean.FiltroBibliotecaBean;
import it.tommaso.uniroma2.progettoISPW.exception.CriterioIllegaleException;
import it.tommaso.uniroma2.progettoISPW.exception.MaxCaratteriException;
import it.tommaso.uniroma2.progettoISPW.exception.RicercaException;

import java.util.ArrayList;
import java.util.List;

public class FiltroBiblioteca implements IFiltroTestuale<Biblioteca>{

    private final int MAX_LUNGHEZZA_FILTRO = 100;

    private TipoFiltroBiblioteca tipo;
    private String testoRicerca;

    public FiltroBiblioteca(TipoFiltroBiblioteca tipo, String testoRicerca) {
        this.tipo = tipo;
        this.testoRicerca = testoRicerca;
    }

    public FiltroBiblioteca(FiltroBibliotecaBean filtroBibliotecaBean) throws RicercaException {

        try{
            impostaTipo(filtroBibliotecaBean.getTipoSelezionato());
            impostaTestoRicerca(filtroBibliotecaBean.getTestoRicerca());
        } catch (CriterioIllegaleException e) {
            throw new RicercaException("Errore criterio nella creazione del filtro",e);
        }catch (MaxCaratteriException e){
            throw new RicercaException("Errore testo ricerca nella creazione del fitro",e);
        }

    }

    @Override
    public void impostaTestoRicerca(String testoRicerca) throws MaxCaratteriException{
        if(testoRicerca.length() > MAX_LUNGHEZZA_FILTRO) {
            throw new MaxCaratteriException("Il campo di ricerca inserito è troppo lungo.");
        }else {
            this.testoRicerca = testoRicerca;
        }
    }

    @Override
    public void impostaTipo(String nomeTipo) throws CriterioIllegaleException{

        try {
            this.tipo = TipoFiltroBiblioteca.valueOf(nomeTipo);
        } catch (IllegalArgumentException e) {
            throw new CriterioIllegaleException("Nome tipo filtro per le biblioteche errato!");
        }

    }

    @Override
    public List<String> ottieniTuttiNomiTipi() {
        List<String> listaTipi;
        listaTipi = new ArrayList<>();
        for(TipoFiltroBiblioteca tf: TipoFiltroBiblioteca.values()){
            listaTipi.add(tf.toString());
        }
        return listaTipi;
    }


    @Override
    public String ottieniNomeTipoFiltro() {

        return this.tipo.toString();

    }

    @Override
    public String ottieniTestoRicerca() {
        return this.testoRicerca;
    }
}
