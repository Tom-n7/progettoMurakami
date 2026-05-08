package it.tommaso.uniroma2.view;

import javafx.event.Event;
import javafx.event.EventType;

public class EnventoCambioUseCase extends Event {
    static final EventType<EnventoCambioUseCase> ANY = new EventType<>(Event.ANY, "ANY" );

    static final EventType<EnventoCambioUseCase> IMPORTA_METADATI_LIBRO = new EventType<>(ANY, "IMPORTA_METADATI_LIBRO");

    static final EventType<EnventoCambioUseCase> PRENOTA_LIBRO = new EventType<>(ANY, "PRENOTA_LIBRO");


    public EnventoCambioUseCase(EventType<? extends Event> eventType) {
        super(eventType);
    }
}
