package com.deportistas.deportistademo.dto;

public class ResponsePersonDto {
    private String name;
    private String surname;
    private String sport;

    public ResponsePersonDto(String name, String surname, String sport) {
        this.name = name;
        this.surname = surname;
        this.sport = sport;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getSport() {
        return sport;
    }

    @Override
    public String toString() {
        return "ResponsePersonDto{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", sport='" + sport + '\'' +
                '}';
    }
}
