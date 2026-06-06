package it.tommaso.uniroma2.progettoispw.model;

import it.tommaso.uniroma2.progettoispw.bean.FiltroBibliotecaBean;
import it.tommaso.uniroma2.progettoispw.exception.CriterioIllegaleException;
import it.tommaso.uniroma2.progettoispw.exception.MaxCaratteriException;
import it.tommaso.uniroma2.progettoispw.exception.RicercaException;

import java.util.ArrayList;
import java.util.List;

public class FiltroBiblioteca implements IFiltroTestuale{

    private static final int MAX_LUNGHEZZA_FILTRO = 100;

    private TipoFiltroBiblioteca tipo;
    private String testoRicerca;

    public FiltroBiblioteca(TipoFiltroBiblioteca tipo, String testoRicerca) {
        this.tipo = tipo;
        this.testoRicerca = testoRicerca;
    }

    public FiltroBiblioteca() {

    }

    public TipoFiltroBiblioteca getTipo() {
        return tipo;
    }

    public void setTipo(TipoFiltroBiblioteca tipo) {
        this.tipo = tipo;
    }

    public String getTestoRicerca() {
        return testoRicerca;
    }

    public void setTestoRicerca(String testoRicerca) {
        this.testoRicerca = testoRicerca;
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
    public void impostaTipoDaNome(String nomeTipo) throws CriterioIllegaleException{

        try {
            this.tipo = TipoFiltroBiblioteca.valueOf(nomeTipo);
        } catch (IllegalArgumentException _) {
            //se il nome tipo non coincide con uno dei tipi consentiti, o è vuoto, oppure un nome non vialido.
            if(nomeTipo.isEmpty()){
                this.tipo = TipoFiltroBiblioteca.NESSUNO;
            }else {
                throw new CriterioIllegaleException("Nome tipo filtro per le biblioteche errato!");
            }
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
