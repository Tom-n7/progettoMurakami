package it.tommaso.uniroma2.progettoISPW.exception;

public class RicercaException extends RuntimeException {
    public RicercaException(String message) {
        super(message);
    }

    public RicercaException(String message, Throwable cause){super(message, cause);}
}
