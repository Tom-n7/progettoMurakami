package it.tommaso.uniroma2.progettoISPW.supporto;

import it.tommaso.uniroma2.progettoISPW.bean.LibroBean;
import javafx.event.Event;
import javafx.event.EventType;


public class LibroImportatoEvent extends Event {

    private LibroBean libroBeanImportato;

    public static final EventType<LibroImportatoEvent> ANY = new EventType<>(Event.ANY, "ANY");


    public LibroImportatoEvent(EventType<? extends Event> eventType) {
        super(eventType);
    }

    public LibroBean getLibroBeanImportato() {
        return libroBeanImportato;
    }

    public void setLibroBeanImportato(LibroBean libroBeanImportato) {
        this.libroBeanImportato = libroBeanImportato;
    }
}
