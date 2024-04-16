package org.example.dto_p1_sports.sport;

import java.io.Serializable;

public class SportDTO implements Serializable {
    private String name;
    private String lastname;
    private String sportName;

    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setSportName(String sportName) {
        this.sportName = sportName;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getSportName() {
        return sportName;
    }
}
