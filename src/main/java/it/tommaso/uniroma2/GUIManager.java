package it.tommaso.uniroma2;

import javafx.scene.layout.StackPane;

/*
* Classe deputata alla gestione delle viste del sistema, ogni controller grafico usufruisce di questo oggetto nel
* momento in cui il caso d'uso associato termina ed inizia il successivo.
*/
public class GUIManager {

    private static GUIManager istanza;
    private StackPane rootPane;





    //metodo per ottenere reference del GUI manager.
    static public GUIManager getGUIManager(){

        if(istanza == null){
            istanza = new GUIManager();
        }

        return istanza;
    }

    public void setRootPane(StackPane pane){
        rootPane = pane;
    }
}
