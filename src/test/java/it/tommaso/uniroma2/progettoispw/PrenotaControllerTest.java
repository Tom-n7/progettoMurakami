package it.tommaso.uniroma2.progettoispw;

import it.tommaso.uniroma2.progettoispw.bean.*;
import it.tommaso.uniroma2.progettoispw.control.ImportaMetadatiLibroController;
import it.tommaso.uniroma2.progettoispw.control.PrenotaLibroController;
import it.tommaso.uniroma2.progettoispw.dao.factory.DAOFactory;
import it.tommaso.uniroma2.progettoispw.dao.factory.TipoPersistenzaSistema;
import it.tommaso.uniroma2.progettoispw.model.FaseDiPrenotazione;
import it.tommaso.uniroma2.progettoispw.model.Libro;
import it.tommaso.uniroma2.progettoispw.model.Prenotazione;
import it.tommaso.uniroma2.progettoispw.model.TipoFiltroBiblioteca;
import it.tommaso.uniroma2.progettoispw.supporto.FactoryConnessioneDatabase;
import it.tommaso.uniroma2.progettoispw.supporto.Sessione;
import org.junit.jupiter.api.Test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class PrenotaControllerTest {

/*
 @Test void testBozzaPrenotazione(){

     PrenotaLibroController appController = new PrenotaLibroController();


     LettoreBean lettoreBean = new LettoreBean();
     lettoreBean.setId(1);
     lettoreBean.setNome("Tommaso Testa");
     lettoreBean.setEmail("tommaso.testa@students.uniroma2.eu");
     lettoreBean.setUsername("ttesta99");


     PrenotazioneBean prenotazioneBean = new PrenotazioneBean();



 }

 */

 @Test void testCaricamentoBibliotecheRegistrate() {

     int numeroBibliotecheRegistrate = 5;
     DAOFactory.inizializzaDAOFactory(TipoPersistenzaSistema.DATABASE);

     PrenotaLibroController appController = new PrenotaLibroController();
     int numeroBibliotecheRecuperate = appController.caricaBibliotecheRegistrate(new FiltroBibliotecaBean(TipoFiltroBiblioteca.NOME.toString(),"")).size();
     assertEquals(numeroBibliotecheRegistrate,numeroBibliotecheRecuperate);

 }

@Test void testValidaPrenotazioneRegolare(){
    DAOFactory.inizializzaDAOFactory(TipoPersistenzaSistema.DATABASE);
    Sessione.inizializzaSessione(1,"ttesta99");
    PrenotaLibroController appController = new PrenotaLibroController();
    ImportaMetadatiLibroController importaMetadatiLibroController  = new ImportaMetadatiLibroController();

    BibliotecaBean bibliotecaBean = new BibliotecaBean();
    bibliotecaBean.setId(1);
    bibliotecaBean.setNome("Biblioteca Casa della Memoria e della Storia");
    bibliotecaBean.setIndirizzo("Via di San Francesco di Sales,5, Roma, 00165");
    bibliotecaBean.setRegolePrenotazione("2");


    LibroBean libroBean = new LibroBean();
    libroBean.setAutori(List.of("prova"));
    libroBean.setEditore("prova editoer");
    libroBean.setEdizione("prova");
    libroBean.setLingua("italiano");
    libroBean.setTitolo("TITOLO PROVA");
    libroBean.setCodiceISNB("1234567890987");
    importaMetadatiLibroController.salvaLibro(libroBean);

    PrenotazioneBean prenotazioneBean = appController.bozzaPrenotazione(bibliotecaBean);
    int idPrenotazione = prenotazioneBean.getId();
    appController.aggiungiLibroAllaPrenotazione(prenotazioneBean,libroBean);

    appController.validaPrenotazione(prenotazioneBean);

    Prenotazione prenotazione = DAOFactory.ottieniDAOFactory().creaPrenotazioneDAO().ottieni(idPrenotazione);

    assertEquals(FaseDiPrenotazione.VERIFICATA, prenotazione.getStatoPrenotazione());
}


}
