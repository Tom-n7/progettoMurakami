package it.tommaso.uniroma2.control;


import it.tommaso.uniroma2.bean.BibliotecaBean;
import it.tommaso.uniroma2.model.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/*
Controller applicativo del caso d'uso prenota libro.
 */
public class PrenotaLibroController {


    /*
    Questo metodo realizza il primo step del caso d'uso: caricare li biblioteche registrate nel sistema.
     */
    public void caricaBibliotecheRegistrate(List<BibliotecaBean> biblioteche){


        //

        for(Biblioteca b : dummyGenerazioneDatiBiblioteche() ){
            biblioteche.add(new BibliotecaBean(b));
        }



    }


    public List<BibliotecaBean> caricaBibliotecheRegistrate(){


        List<BibliotecaBean> lista = new ArrayList<>();
        //

        for(Biblioteca b : dummyGenerazioneDatiBiblioteche() ){
            lista.add(new BibliotecaBean(b));
        }
        return lista;

    }




    public void cercaBiblioteca(String nome){

    }


    private Collection<Biblioteca> dummyGenerazioneDatiBiblioteche(){


        List<Biblioteca> bibliotecheRegistrate = new ArrayList<>(Arrays.stream(new Biblioteca[]{new Biblioteca("1", "Biblioteca Casa della Memoria e della Storia", new Indirizzo("Via di San Francesco di Sales,5", "Roma", "00165"),
                null, List.of(new RegolaPrenotazione[]{(new RegolaPrenotazione(5))}), null),
                new Biblioteca("2", "Biblioteca Casa delle Letterature", new Indirizzo("Piazza dell'Orologio,3", "Roma", "00186"),
                        null, List.of(new RegolaPrenotazione[]{(new RegolaPrenotazione(5))}), null),
                new Biblioteca("3", "Biblioteca Casa delle Traduzioni", new Indirizzo("Via degli Avignonesi,32", "Roma", "00187"),
                        null, List.of(new RegolaPrenotazione[]{(new RegolaPrenotazione(5))}), null)}).toList());

        return bibliotecheRegistrate;


    }

}
