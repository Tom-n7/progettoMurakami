package it.tommaso.uniroma2.progettoISPW.supporto;

public class Sessione {

    private int idUtente;

    private Sessione(int id){
        idUtente = id;
    };

    private class ContenitoreSessione{
        private static Sessione ISTANZA;
    }

    public static int ottieniId(){
        return ContenitoreSessione.ISTANZA.idUtente;
    }


    public static Sessione inizializzaSessione(int id){
        if(ContenitoreSessione.ISTANZA == null){
            ContenitoreSessione.ISTANZA = new Sessione(id);
        }

         return ContenitoreSessione.ISTANZA;
    }
}
