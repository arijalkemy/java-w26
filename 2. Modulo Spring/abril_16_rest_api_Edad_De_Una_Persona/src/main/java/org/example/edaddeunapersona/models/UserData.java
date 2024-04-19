package org.example.edaddeunapersona.models;

import java.time.*;
import java.time.LocalDate;

public class UserData {
    private final LocalDate birthDate;

    public UserData(String year, String month, String day) {
        this.birthDate = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
    }

    public int calculateAge(){
        LocalDate currentDate = LocalDate.now();
        Period age = Period.between(birthDate, currentDate);
        return age.getYears();
    }
}
