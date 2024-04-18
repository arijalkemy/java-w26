package org.example.integradordeportistas.dto;

public class SportsPersonDTO {

    private String fullName;
    private String sportName;

    public SportsPersonDTO(String fullName, String sportName) {
        this.fullName = fullName;
        this.sportName = sportName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getSportName() {
        return sportName;
    }

    public void setSportName(String sportName) {
        this.sportName = sportName;
    }
}
