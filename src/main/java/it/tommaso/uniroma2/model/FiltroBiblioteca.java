package it.tommaso.uniroma2.model;

import it.tommaso.uniroma2.bean.FiltroBibliotecaBean;
import it.tommaso.uniroma2.exception.CriterioIllegaleException;
import it.tommaso.uniroma2.exception.MaxCaratteriException;
import it.tommaso.uniroma2.exception.QueryRicercaException;

public class FiltroBiblioteca {

    private final int MAX_LUNGHEZZA_FILTRO = 100;

    private TipoFiltroBiblioteca tipo;
    private String contenuto;

    public FiltroBiblioteca(TipoFiltroBiblioteca tipo, String contenuto) {
        this.tipo = tipo;
        this.contenuto = contenuto;
    }

    public FiltroBiblioteca(FiltroBibliotecaBean filtroBibliotecaBean) throws QueryRicercaException {

        String campoRicerca = filtroBibliotecaBean.getContenuto();

        for(TipoFiltroBiblioteca tf: TipoFiltroBiblioteca.values()){
            if(tf.toString().equals(filtroBibliotecaBean.getTipo())){
                this.tipo = tf;
                break;
            }
        }

        if(this.tipo == null){
            throw new CriterioIllegaleException(filtroBibliotecaBean.getTipo() + " non è un criterio valido" );
        }

        if(campoRicerca.length() > MAX_LUNGHEZZA_FILTRO) {
            throw new MaxCaratteriException("Il campo di ricerca inserito è troppo lungo.");
        }else {
            this.contenuto = filtroBibliotecaBean.getContenuto();
        }

    }
    public TipoFiltroBiblioteca getTipo() {
        return tipo;
    }

    public void setTipo(TipoFiltroBiblioteca tipo) {
        this.tipo = tipo;
    }

    public String getContenuto() {
        return contenuto;
    }

    public void setContenuto(String contenuto) {
        this.contenuto = contenuto;
    }
}
