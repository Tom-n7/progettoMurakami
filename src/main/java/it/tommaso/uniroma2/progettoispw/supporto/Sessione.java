package it.tommaso.uniroma2.progettoispw.supporto;

public class Sessione {

    private final int idUtente;
    private final String username;

    private Sessione(int id, String username){

        idUtente = id;
        this.username = username;
    }

    private class ContenitoreSessione{
        private static Sessione istanza;
    }

    public static int ottieniId(){
        return ContenitoreSessione.istanza.idUtente;
    }

    public static String getUsername() {
        return ContenitoreSessione.istanza.username;
    }

    public static Sessione inizializzaSessione(int id, String username){
        if(ContenitoreSessione.istanza == null){
            ContenitoreSessione.istanza = new Sessione(id,username);
        }

         return ContenitoreSessione.istanza;
    }
}
