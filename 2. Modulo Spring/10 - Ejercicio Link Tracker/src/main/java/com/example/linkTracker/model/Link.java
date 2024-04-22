package com.example.linkTracker.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class Link {
    private String id;
    private boolean valid;
    private int accessCounter;
    private String password;

    public Link(String id, boolean valid, int accessCounter) {
        this.id = id;
        this.valid = valid;
        this.accessCounter = accessCounter;
        this.password = null;
    }

    public boolean getValid(){
        return valid;
    }
}
