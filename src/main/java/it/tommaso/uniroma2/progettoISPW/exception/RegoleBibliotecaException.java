package it.tommaso.uniroma2.progettoISPW.exception;

public class RegoleBibliotecaException extends RuntimeException {


    public RegoleBibliotecaException(String message) {
        super(message);

    }

    public RegoleBibliotecaException(String message, Throwable cause){
        super(message, cause);

    }
}
