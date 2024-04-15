package org.example.pasajero;

import java.util.UUID;

public class Pasajero {
    private UUID id;
    private String name;

    public Pasajero(String name) {
        this.id = UUID.randomUUID();
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
