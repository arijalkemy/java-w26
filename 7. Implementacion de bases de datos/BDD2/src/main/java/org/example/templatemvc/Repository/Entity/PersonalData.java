package org.example.templatemvc.Repository.Entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class PersonalData {

    private String name;
    private String surname;
    private String email;

}
