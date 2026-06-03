package it.tommaso.uniroma2.progettoISPW.dao.factory;

/*
La DAOFactory è un singleton questo poiché deve essere a disposizione di diverse parti del sistema (diversi controller applicativi)
i quali appartengono tutti allo stessto "strato" dell'applicazione ma spesso non comunicano tra loro.

Inoltre è adatto alla creazione bootstrap.

Nello specifico viene implementato come singleton polimorfico, in questa maniera, stabilita il tipo di factory rimarrà invariata
per tutto la durata dell'esecuzione.
 */

import it.tommaso.uniroma2.progettoISPW.dao.BibliotecaDAO;
import it.tommaso.uniroma2.progettoISPW.dao.LettoreDAO;
import it.tommaso.uniroma2.progettoISPW.dao.LibroDAO;
import it.tommaso.uniroma2.progettoISPW.dao.PrenotazioneDAO;

public abstract class DAOFactory {

    //é possibile ottenere ogni tipo di DAO esclusivamente attraverso la factory.
    public abstract BibliotecaDAO creaBibliotecaDAO();
    public abstract LettoreDAO creaLettoreDAO();
    public abstract PrenotazioneDAO creaPrenotazioneDAO();
    public abstract LibroDAO creaLibroDAO();

    //costruttore privato
    protected DAOFactory(){}
    /*
    Utilizza il principio secondo cui la JVM, garantisce che una classe interna statica venga inizializzata solo una volta,
     anche nel caso di chiamate simultanee.
     Ciò rende l'implementazione del sigleton thread-safe.
     */
    private static class ContenitoreFactory{
        private static  DAOFactory ISTANZA;
    }

    public static DAOFactory ottieniDAOFactory(){
        return ContenitoreFactory.ISTANZA;
    }

    public static void inizializzaDAOFactory(TipoPersistenzaSistema tipoPersistenzaScelto){

        if(ContenitoreFactory.ISTANZA == null){

            switch (tipoPersistenzaScelto){

                case DEMO : ContenitoreFactory.ISTANZA = new DemoDAOFactory();
                break;
                case DATABASE : ContenitoreFactory.ISTANZA = new DatabaseDAOFactory();
                break;
                case FILESYSTEM : ContenitoreFactory.ISTANZA = new FileDAOFactory();
                break;
                case null, default : throw new RuntimeException();

            }

        }

    }
}
