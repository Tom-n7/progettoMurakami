package it.tommaso.uniroma2.view.terminal;

/*
Classe deputata alla costruzione e gestione elementi grafici per effettuare
il login, in modalità TERMINALE
 */


import it.tommaso.uniroma2.bean.CredenzialiBean;
import it.tommaso.uniroma2.controller.LoginAppController;
import it.tommaso.uniroma2.view.FX.LibreriaPersonaleControllerGraficoJAvaFX;
import it.tommaso.uniroma2.view.LoginControllerGrafico;

import java.util.Scanner;

public class LoginControllerGraficoTerminale implements LoginControllerGrafico {

    private final LoginAppController controllerApplicativo = new LoginAppController();
    private CredenzialiBean credenzialiBean;

    public void vistaLogin() {

        catturaCredenziali();
        selettoreAzione();





    }

    private void selettoreAzione(){


        switch (credenzialiBean.getRuolo()){

            case LETTORE -> selettoreLettore();
            case BIBLIOTECARIO -> selettoreBibliotecario();

        }

    }



    private void selettoreBibliotecario(){

        int choice;
        Scanner input = new Scanner(System.in);

        do {
            System.out.println("----------DASHBOARD BIBLIOTECARIO------------");
            System.out.println("1. Pubblica Annuncio");
            System.out.println("2. Gestisci Appuntamenti");
            System.out.println("3. Valida Prenotazione");
            System.out.println("4. Prenota Libro");
            System.out.println("5. Valida Richiesta");

            choice = input.nextInt();

            switch (choice){
                case 1: new LibreriaPersonaleControllerGraficoTerminal().vistaLibreria();
                default:
                    if (choice > 5){
                        System.out.println("Scelta non valida");
                    }else{
                        System.out.println("Non ancora implementato");
                    }
            }



        }while(true);



    }



    private void selettoreLettore(){

        int choice;
        Scanner input = new Scanner(System.in);

        do {
            System.out.println("-----------DASHBOARD LETTORE--------------");
            System.out.println("1. Gestisci Libreria Personale");
            System.out.println("2. Gestisci Amici");
            System.out.println("3. Gestisci Aggiornamenti Biblioteche");
            System.out.println("4. Prenota Libro");
            System.out.println("5. Valida Richiesta");

            choice = input.nextInt();

            switch (choice){
                case 1: new LibreriaPersonaleControllerGraficoTerminal().vistaLibreria();
                default:
                    if (choice > 5){
                        System.out.println("Scelta non valida");
                    }else{
                        System.out.println("Non ancora implementato");
                    }
            }



        }while(true);



    }


    private void catturaCredenziali(){
        String choice;
        Scanner input = new Scanner(System.in);

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


            //PROVVISORIO---
            credenziali.setPassword("123");
            credenziali.setUsername("ziofolletto");
            //----------------

            controllerApplicativo.controlloCredenziali(credenziali);
            if(credenziali.getVerificate()){

                credenzialiBean = credenziali;

            }

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
