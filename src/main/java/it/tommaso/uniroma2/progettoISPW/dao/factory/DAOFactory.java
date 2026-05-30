package it.tommaso.uniroma2.progettoISPW.dao.factory;

public abstract class DAOFactory {

    private final TipoPersistenzaSistema tipoPersistenza;


    protected DAOFactory(TipoPersistenzaSistema tipoPersistenza) {
        this.tipoPersistenza = tipoPersistenza;
    }
}
