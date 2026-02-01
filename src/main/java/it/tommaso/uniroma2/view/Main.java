package it.tommaso.uniroma2.view;

import it.tommaso.uniroma2.App;


/*
Per qualche motivo, la definizione di "public static void main()" e "start()" devono essere divise in due classi differenti,
altrimenti si incorre nell'errore "missing javaFX runtime componet".
 */
public class Main {
    public static void main(String[] args){
        App.launch(App.class,args);
    }
}
