package it.tommaso.uniroma2.progettoISPW.supporto;

public class Sessione {

    private final int idUtente;
    private final String username;

    private Sessione(int id, String username){

        idUtente = id;
        this.username = username;
    };

    private class ContenitoreSessione{
        private static Sessione ISTANZA;
    }

    public static int ottieniId(){
        return ContenitoreSessione.ISTANZA.idUtente;
    }

    public static String getUsername() {
        return ContenitoreSessione.ISTANZA.username;
    }

    public static Sessione inizializzaSessione(int id, String username){
        if(ContenitoreSessione.ISTANZA == null){
            ContenitoreSessione.ISTANZA = new Sessione(id,username);
        }

         return ContenitoreSessione.ISTANZA;
    }
}
