package it.tommaso.uniroma2.view;

import javafx.event.Event;
import javafx.event.EventType;

public class EventoCambioUseCase extends Event {
    public static final EventType<EventoCambioUseCase> ANY = new EventType<>(Event.ANY, "ANY" );

    public static final EventType<EventoCambioUseCase> IMPORTA_METADATI_LIBRO = new EventType<>(ANY, "IMPORTA_METADATI_LIBRO");

    public static final EventType<EventoCambioUseCase> PRENOTA_LIBRO = new EventType<>(ANY, "PRENOTA_LIBRO");

    public static final EventType<EventoCambioUseCase> GESTISCI_LIBRERIA = new EventType<>(ANY, "GESTISCI_LIBRERIA");

    public EventoCambioUseCase(EventType<? extends Event> eventType) {
        super(eventType);
    }
}
