package it.tommaso.uniroma2.progettoispw.exception;

public class NumeroLibriMassimoSuperatoException extends RegoleBibliotecaException {

    private final int numeroLibriInEccesso;


    public NumeroLibriMassimoSuperatoException(String message, int numeroLibriInEccesso){
        super(message);
        this.numeroLibriInEccesso = numeroLibriInEccesso;
    }

    public int getNumeroLibriInEccesso() {
        return numeroLibriInEccesso;
    }
}
