package it.tommaso.uniroma2.gestiscilp.view.terminal;

import it.tommaso.uniroma2.gestiscilp.controller.LibreriaPersonaleAppController;

import java.util.Scanner;

public class LibreriaPersonaleControllerGraficoTerminal  {

    LibreriaPersonaleAppController appController;




    public void vistaLibreria() {
        appController = new LibreriaPersonaleAppController();

        System.out.println("---------LIBRERIA PERSONALE-------");





        Scanner input = new Scanner(System.in);
        int choice = 0;
        while (true) {
            System.out.println("Inserisci scelta:");
            choice = input.nextInt();
            if (choice >= 1 && choice <= 6) {
                break;
            }
            System.out.println("Scelta non valida");
        }
        //
    }
}
