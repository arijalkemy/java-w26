package com.ej2p1.athletes.dto;

public class SportPersonDTO {
    private String firstName;
    private String lastName;
    private String sportName;

    public SportPersonDTO() {
    }

    public SportPersonDTO(String firstName, String lastName, String sportName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.sportName = sportName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSportName() {
        return sportName;
    }

    public void setSportName(String sportName) {
        this.sportName = sportName;
    }
}
