package it.tommaso.uniroma2.progettoispw.exception;

public class CriterioIllegaleException extends RicercaException {
    public CriterioIllegaleException(String message) {
        super(message);
    }
    public CriterioIllegaleException(String message, Throwable cause){super(message, cause);}
}
