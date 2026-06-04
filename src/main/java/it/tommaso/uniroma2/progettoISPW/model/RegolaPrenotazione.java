package it.tommaso.uniroma2.progettoISPW.model;

import it.tommaso.uniroma2.progettoISPW.exception.NumeroLibriMassimoSuperatoException;
import it.tommaso.uniroma2.progettoISPW.exception.RegoleBibliotecaException;

import java.util.List;

public class RegolaPrenotazione {
    private final int maxLibriConsentiti;

    public RegolaPrenotazione(int maxLibriConsentiti) {
        this.maxLibriConsentiti = maxLibriConsentiti;
    }


    /*
    Regola prenotazione ha la responsabilità di stabiblire se una lista di libri è conforme o meno
     */
    public void passaPrenotazione(List<Libro> libri) throws NumeroLibriMassimoSuperatoException {

        int libriInEccesso;
        if(libri.size() > maxLibriConsentiti){
            libriInEccesso = libri.size() - maxLibriConsentiti;
            throw new NumeroLibriMassimoSuperatoException("I libri richiesti eccedono il limite stabilito dalla biblioteca", libriInEccesso);
        }
    }

    public String toString(){
        return Integer.toString(maxLibriConsentiti);
    }

}
