package it.tommaso.uniroma2.progettoISPW.dao.factory;

public abstract class DAOFactory {
    
    private static TipoPersistenzaSistema tipoPersistenza = TipoPersistenzaSistema.INDEFINITA;

    public static void setTipoPersistenza(TipoPersistenzaSistema tipoPersistenza){
        //il tipo di persistenza non può essere più cambiato una volta defibito
        if(DAOFactory.tipoPersistenza == TipoPersistenzaSistema.INDEFINITA){

        }

    }


    
}
