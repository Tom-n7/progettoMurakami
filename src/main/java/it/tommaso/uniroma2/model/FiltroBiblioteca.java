package it.tommaso.uniroma2.model;

public class FiltroBiblioteca {

    private TipoFiltroBiblioteca tipo;
    private String contenuto;

    public FiltroBiblioteca(TipoFiltroBiblioteca tipo, String contenuto) {
        this.tipo = tipo;
        this.contenuto = contenuto;
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
