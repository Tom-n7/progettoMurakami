package it.tommaso.uniroma2.progettoispw;



import it.tommaso.uniroma2.progettoispw.dao.factory.DAOFactory;
import it.tommaso.uniroma2.progettoispw.dao.factory.TipoPersistenzaSistema;
import it.tommaso.uniroma2.progettoispw.supporto.Sessione;
import it.tommaso.uniroma2.progettoispw.view.ControllerGrafico;
import it.tommaso.uniroma2.progettoispw.view.mobile.MobileController;

/*
Classe controller del sistema; lancia l'applicazione in modalità GUI o CLI a seconda dell'impostazione
fornita.
 */

public class Main{
    public static void main(String... args){


        System.out.println("Scegli modialità grafica");
        System.out.println("1. GUI");
        System.out.println("2. Terminale");





        System.out.println("Scegli impostazione persistenza");
        System.out.println("1. FILESYSTEM");
        System.out.println("2. DATABASE");


        //poiché il login non è implementato.
        Sessione.inizializzaSessione(1, "ttesta99");


        //PROVVISORIAMENTE la factory è init. per restituire la versione "database" dei DAO
        DAOFactory.inizializzaDAOFactory(TipoPersistenzaSistema.DATABASE);



        ControllerGrafico controllerGrafico = new MobileController();
        controllerGrafico.iniziaSessioneGrafica();


    }
}


