package it.tommaso.uniroma2.progettoispw.dao.factory;

/*
La DAOFactory è un singleton questo poiché deve essere a disposizione di diverse parti del sistema (diversi controller applicativi)
i quali appartengono tutti allo stessto "strato" dell'applicazione ma spesso non comunicano tra loro.

Inoltre è adatto alla creazione bootstrap.

Nello specifico viene implementato come singleton polimorfico, in questa maniera, stabilita il tipo di factory rimarrà invariata
per tutto la durata dell'esecuzione.
 */

import it.tommaso.uniroma2.progettoispw.dao.BibliotecaDAO;
import it.tommaso.uniroma2.progettoispw.dao.LettoreDAO;
import it.tommaso.uniroma2.progettoispw.dao.LibroDAO;
import it.tommaso.uniroma2.progettoispw.dao.PrenotazioneDAO;
import it.tommaso.uniroma2.progettoispw.exception.DAOException;

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
        private static   DAOFactory Istanza;
    }

    public static DAOFactory ottieniDAOFactory(){
        return ContenitoreFactory.Istanza;
    }

    public static void inizializzaDAOFactory(TipoPersistenzaSistema tipoPersistenzaScelto){

        if(ContenitoreFactory.Istanza == null){

            switch (tipoPersistenzaScelto){

                case DEMO : ContenitoreFactory.Istanza = new DemoDAOFactory();
                break;
                case DATABASE : ContenitoreFactory.Istanza = new DatabaseDAOFactory();
                break;
                case FILESYSTEM : ContenitoreFactory.Istanza = new FileDAOFactory();
                break;
                case null, default : throw new DAOException("Tipo persistenza non supportato!");

            }

        }

    }
}
