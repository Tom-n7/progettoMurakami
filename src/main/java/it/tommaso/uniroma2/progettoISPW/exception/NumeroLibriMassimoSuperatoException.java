package it.tommaso.uniroma2.progettoISPW.exception;

public class NumeroLibriMassimoSuperatoException extends RegoleBibliotecaException {

    private int numeroLibriInEccesso;


    public NumeroLibriMassimoSuperatoException(String message, int numeroLibriInEccesso){
        super(message);
        this.numeroLibriInEccesso = numeroLibriInEccesso;
    }

    public int getNumeroLibriInEccesso() {
        return numeroLibriInEccesso;
    }
}
