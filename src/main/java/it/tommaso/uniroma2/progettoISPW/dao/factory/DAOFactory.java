package it.tommaso.uniroma2.progettoISPW.dao.factory;

/*
La DAOFactory è un singleton questo poiché deve essere a disposizione di diverse parti del sistema (diversi controller applicativi)
i quali appartengono tutti allo stessto "strato" dell'applicazione ma spesso non comunicano tra loro.

Inoltre è adatto alla creazione bootstrap.

Nello specifico viene implementato come singleton polimorfico, in questa maniera, stabilita il tipo di factory rimarrà invariata
per tutto la durata dell'esecuzione.
 */

import it.tommaso.uniroma2.progettoISPW.dao.IRicercabiliDAO;
import it.tommaso.uniroma2.progettoISPW.model.Biblioteca;
import it.tommaso.uniroma2.progettoISPW.model.Lettore;

public abstract class DAOFactory {

    public abstract IRicercabiliDAO<Biblioteca> creaBibliotecaDAO();
    public abstract IRicercabiliDAO<Lettore> creaLettoreDAO();
    public abstract IRicercabiliDAO<>


}
