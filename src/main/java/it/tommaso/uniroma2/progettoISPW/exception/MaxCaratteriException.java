package it.tommaso.uniroma2.progettoISPW.exception;

public class MaxCaratteriException extends RicercaException {
    public MaxCaratteriException(String message) {
        super(message);
    }
    public MaxCaratteriException(String message, Throwable cause){super(message, cause);}
}
