package it.tommaso.uniroma2.progettoISPW.supporto;

import java.util.Scanner;

public class SelettoreTerminale {

    int numeroOpzioni;

    public SelettoreTerminale( int numeroOpzioni){
        this.numeroOpzioni = numeroOpzioni;
    }

    public int selezione(){

        Scanner input = new Scanner(System.in);
        int choice = 0;
        while (true) {
            System.out.print("Please enter your choice: ");
            choice = input.nextInt();
            if (choice >= 1 && choice <= numeroOpzioni) {
                break;
            }
            System.out.println("scelta non valida");
        }

        return choice;

    }




}
