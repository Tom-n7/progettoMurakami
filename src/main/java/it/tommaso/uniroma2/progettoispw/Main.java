package it.tommaso.uniroma2.progettoispw;



import it.tommaso.uniroma2.progettoispw.dao.factory.DAOFactory;
import it.tommaso.uniroma2.progettoispw.dao.factory.TipoPersistenzaSistema;
import it.tommaso.uniroma2.progettoispw.supporto.Sessione;
import it.tommaso.uniroma2.progettoispw.view.ControllerGrafico;
import it.tommaso.uniroma2.progettoispw.view.desktop.DesktopController;

import java.io.*;

/*
Classe controller del sistema; lancia l'applicazione in modalità GUI o CLI a seconda dell'impostazione
fornita.
 */

public class Main{
    private static String leggiRigaConfig(FileReader readerFileConfigurazione) throws IOException {

        int carattere;
        while ((carattere = readerFileConfigurazione.read()) != -1 ){
            if(carattere == ':'){
                break;
            }
        }

        StringBuilder rigaConfigsb = new StringBuilder();
        while ((carattere = readerFileConfigurazione.read()) != -1 ){
            if(carattere == ';'){
                break;
            }
            rigaConfigsb.append((char) carattere);
        }
        return rigaConfigsb.toString();

    }

    public static void main(String... args) {

        String idUtente;
        String usernameUtente;
        String nomeModPersistenza;
        String nomeModEsecuzione;





        try {
            FileReader readerFileConfigurazione = new FileReader("resources/avvio.config");

            nomeModEsecuzione = leggiRigaConfig(readerFileConfigurazione);
            nomeModPersistenza = leggiRigaConfig(readerFileConfigurazione);
            usernameUtente = leggiRigaConfig(readerFileConfigurazione);
            idUtente = leggiRigaConfig(readerFileConfigurazione);

        }catch (IOException _){
            return;
        }


        //poiché il login non è implementato.
        Sessione.inizializzaSessione(Integer.valueOf(idUtente), usernameUtente);


        //PROVVISORIAMENTE la factory è init. per restituire la versione "database" dei DAO
        DAOFactory.inizializzaDAOFactory(TipoPersistenzaSistema.valueOf(nomeModPersistenza));



        ControllerGrafico controllerGrafico = new DesktopController();
        controllerGrafico.iniziaSessioneGrafica();


    }
}


