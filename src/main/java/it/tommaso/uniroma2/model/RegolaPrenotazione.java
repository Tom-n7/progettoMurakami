package it.tommaso.uniroma2.model;

public class RegolaPrenotazione {
    private final int MAX_LIBRI_CONSENTITI;

    public RegolaPrenotazione(int maxLibriConsentiti) {
        MAX_LIBRI_CONSENTITI = maxLibriConsentiti;
    }

    public String toString(){
        return Integer.toString(MAX_LIBRI_CONSENTITI);
    }

}
