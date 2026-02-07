package it.tommaso.uniroma2.model.bean;

import it.tommaso.uniroma2.model.LibreriaPersonale;

import java.util.List;

public class LibreriaPersonaleBean {

    LibreriaPersonaleBean(List<ScaffaleBean> scaffaliLibreria){
        this.scaffaliLibreria = scaffaliLibreria;
    }

    private List<ScaffaleBean> scaffaliLibreria;

    public List<ScaffaleBean> getScaffaliLibreria() {
        return scaffaliLibreria;
    }

}
