package it.tommaso.uniroma2.controller;

import it.tommaso.uniroma2.model.LibreriaPersonale;
import it.tommaso.uniroma2.model.Libro;
import it.tommaso.uniroma2.model.Scaffale;
import it.tommaso.uniroma2.model.bean.LibreriaPersonaleBean;
import it.tommaso.uniroma2.model.bean.LibroBean;
import it.tommaso.uniroma2.model.bean.ScaffaleBean;
import it.tommaso.uniroma2.model.dao.base.CaricaLibreriaPersonaleDAO;
import it.tommaso.uniroma2.model.dao.factories.DAOFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LibreriaPersonaleAppController {


    public LibreriaPersonaleBean caricaLibreriaPersonale() {

        LibreriaPersonale libreriaPersonale = null;
        LibreriaPersonaleBean libreriaPersonaleBean;
        List<ScaffaleBean> scaffaliLibreriaBean = new ArrayList<>();


        DAOFactory factory = DAOFactory.getFactory();
        CaricaLibreriaPersonaleDAO caricaLibreriaPersonaleDAO = factory.getCaricaLibreriaPersonaleDAO();

        try {
            libreriaPersonale = caricaLibreriaPersonaleDAO.execute();
        } catch (Exception e) {
            System.out.println("errore!");
        }

        List<Scaffale> scaffaliEntity;
        try {
            scaffaliEntity = Objects.requireNonNull(libreriaPersonale).getScaffaliLibreria();


            //bisogna incapsulare ogni scaffale nella sua bean
            for(Scaffale scaffale: scaffaliEntity) {

                String nomeScaffale = scaffale.getNomeScaffale();
                List<Libro> libriScaffale = scaffale.getLibriContenuti();
                List<LibroBean> libriBeanScaffale = new ArrayList<>();

                //bisogna incapsulare ogni libro nella sua bean
                for (Libro libro : libriScaffale){
                    libriBeanScaffale.add(new LibroBean(libro.getTitolo(), libro.getAutori(), libro.getLingua(),
                            libro.getCodiceISNB(), libro.getNomeSerie(), libro.getNumeroSerie(), libro.getPubblicazione(),
                            libro.getEditore(),libro.getDescrizione()) );
                }

                scaffaliLibreriaBean.add(new ScaffaleBean(nomeScaffale, libriBeanScaffale));

            }

        }catch (NullPointerException e){
            System.out.println("Errore!");
        }

        libreriaPersonaleBean = new LibreriaPersonaleBean(scaffaliLibreriaBean);

        return libreriaPersonaleBean;
    }



}
