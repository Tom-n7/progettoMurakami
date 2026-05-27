package it.tommaso.uniroma2.progettoISPW.model;

import java.time.LocalTime;

public class Prenotazione {

    private final int id;
    private final Lettore lettore;
    private final Biblioteca biblioteca;

    private LocalTime giornoPrenotazione;
    private FaseDiPrenotazione stato;
}
