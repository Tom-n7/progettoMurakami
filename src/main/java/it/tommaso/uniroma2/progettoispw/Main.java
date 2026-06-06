package it.tommaso.uniroma2.progettoispw;



import it.tommaso.uniroma2.progettoispw.dao.factory.DAOFactory;
import it.tommaso.uniroma2.progettoispw.dao.factory.TipoPersistenzaSistema;
import it.tommaso.uniroma2.progettoispw.supporto.Sessione;
import it.tommaso.uniroma2.progettoispw.view.ControllerGrafico;
import it.tommaso.uniroma2.progettoispw.view.desktop.DesktopController;
import it.tommaso.uniroma2.progettoispw.view.mobile.MobileController;

/*
Classe controller del sistema; lancia l'applicazione in modalità GUI o CLI a seconda dell'impostazione
fornita.
 */

public class Main{
    public static void main(String... args){


        //poiché il login non è implementato.
        Sessione.inizializzaSessione(1, "ttesta99");


        //PROVVISORIAMENTE la factory è init. per restituire la versione "database" dei DAO
        DAOFactory.inizializzaDAOFactory(TipoPersistenzaSistema.DATABASE);



        ControllerGrafico controllerGrafico = new DesktopController();
        controllerGrafico.iniziaSessioneGrafica();


    }
}


