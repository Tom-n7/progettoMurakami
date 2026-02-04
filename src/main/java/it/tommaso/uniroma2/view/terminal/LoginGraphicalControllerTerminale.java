package it.tommaso.uniroma2.view.terminal;

/*
Classe deputata alla costruzione e gestione elementi grafici per effettuare
il login, in modalità TERMINALE
 */


import it.tommaso.uniroma2.bean.CredenzialiBean;
import it.tommaso.uniroma2.controller.LoginAppController;
import it.tommaso.uniroma2.view.LoginGraphicalController;

import java.util.Scanner;

public class LoginGraphicalControllerTerminale implements LoginGraphicalController {

    private final LoginAppController controllerApplicativo = new LoginAppController();

    public void vistaLogin() {



        Scanner input = new Scanner(System.in);
        String choice;

        do {
            do {
                System.out.println("--------------------Book Buddy-------------------");
                System.out.println("I tuoi libri, la tua community, in un unico posto");
                System.out.println("Premi invio per iniziare");

                choice = input.nextLine();
                if (choice.isEmpty()) {
                    break;
                }
                pulisciSchermo();
            } while (true);
            System.out.println("Controllo le credenziali...");

            CredenzialiBean credenziali = new CredenzialiBean();

            credenziali.setPassword("123");
            credenziali.setUsername("ziofolletto");
            controllerApplicativo.controlloCredenziali(credenziali);

            if (credenziali.getVerificate()) {
                break;
            }
            System.out.println("Credenziali errate!");
        }while (true);
    }


    private void pulisciSchermo() {
        for(int i = 0; i < 21; i++){
            System.out.println();
        }
    }



}
