package it.tommaso.uniroma2.progettoISPW;



import it.tommaso.uniroma2.progettoISPW.dao.factory.DAOFactory;
import it.tommaso.uniroma2.progettoISPW.dao.factory.TipoPersistenzaSistema;
import it.tommaso.uniroma2.progettoISPW.view.ControllerGrafico;
import it.tommaso.uniroma2.progettoISPW.view.DesktopController;

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


        //PROVVISORIAMENTE la factory è init. per restituire la versione "database" dei DAO
        DAOFactory.inizializzaDAOFactory(TipoPersistenzaSistema.DATABASE);



        ControllerGrafico controllerGrafico = new DesktopController();
        controllerGrafico.iniziaSessioneGrafica();


    }
}


