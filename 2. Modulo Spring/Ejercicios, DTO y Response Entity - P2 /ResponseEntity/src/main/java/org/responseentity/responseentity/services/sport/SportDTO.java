package org.responseentity.responseentity.services.sport;

import java.io.Serializable;
import java.util.UUID;

public class SportDTO implements Serializable {
    private String name;
    private String level;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
