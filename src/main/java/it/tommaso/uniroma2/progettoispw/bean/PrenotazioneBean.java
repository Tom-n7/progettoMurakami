package it.tommaso.uniroma2.progettoispw.bean;

import it.tommaso.uniroma2.progettoispw.model.Libro;
import it.tommaso.uniroma2.progettoispw.model.Prenotazione;

import java.util.ArrayList;
import java.util.List;

public class PrenotazioneBean implements IBean{


    private String faseDiPrenotazione;
    private BibliotecaBean biblioteca;
    private LettoreBean lettore;
    private List<LibroBean> libri;
    private int id;


    public PrenotazioneBean(BibliotecaBean biblioteca, LettoreBean lettore, int id, List<LibroBean> libri, String faseDiPrenotazione) {
        this.biblioteca = biblioteca;
        this.lettore = lettore;
        this.id = id;
        this.libri = libri;
        this.faseDiPrenotazione = faseDiPrenotazione;
    }


    public PrenotazioneBean(){}




    public  PrenotazioneBean(Prenotazione prenotazione){

        BibliotecaBean bibliotecaBean = new BibliotecaBean(prenotazione.getBiblioteca());
        LettoreBean lettoreBean = new LettoreBean(prenotazione.getLettore());
        List<LibroBean> libriBean = new ArrayList<>();

        for (Libro l : prenotazione.getLibri()) {
            libriBean.add(new LibroBean(l));
        }


        this.faseDiPrenotazione = prenotazione.getStatoPrenotazione().toString();
        this.biblioteca = bibliotecaBean;
        this.lettore = lettoreBean;
        this.id = prenotazione.getId();
        this.libri = libriBean;

    }

    public String getFaseDiPrenotazione() {
        return faseDiPrenotazione;
    }

    public void setFaseDiPrenotazione(String faseDiPrenotazione) {
        this.faseDiPrenotazione = faseDiPrenotazione;
    }

    public BibliotecaBean getBiblioteca() {
        return biblioteca;
    }

    public void setBiblioteca(BibliotecaBean biblioteca) {
        this.biblioteca = biblioteca;
    }

    public LettoreBean getLettore() {
        return lettore;
    }

    public void setLettore(LettoreBean lettore) {
        this.lettore = lettore;
    }

    public List<LibroBean> getLibri() {
        return libri;
    }

    public void setLibri(List<LibroBean> libri) {
        this.libri = libri;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void addLibro(LibroBean libroBean){
        this.libri.add(libroBean);
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder("");
        for(LibroBean l: this.libri){
            if(l == this.libri.getLast()){
                sb.append( l.getTitolo());
            }else {
                sb.append(", ");
                sb.append( l.getTitolo());
            }
        }

        sb.insert(0,"Libri: ");
        sb.append("\n");
        sb.append("Biblioteca: ");
        sb.append(biblioteca.getNome());
        sb.append("\n");
        sb.append("Stato Prenotazione: ");
        sb.append(faseDiPrenotazione);


        return sb.toString();
    }
}
