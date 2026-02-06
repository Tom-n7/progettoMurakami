package it.tommaso.uniroma2.model;

public enum Ruolo {
    BIBLIOTECARIO(1), LETTORE(2);

    private final int id;

    private Ruolo(int id) {
        this.id = id;
    }

    public static Ruolo fromInt(int id) {
        for (Ruolo type : values()) {
            if (type.getId() == id) {
                return type;
            }
        }
        return null;
    }

    public int getId() {
        return id;
    }
}