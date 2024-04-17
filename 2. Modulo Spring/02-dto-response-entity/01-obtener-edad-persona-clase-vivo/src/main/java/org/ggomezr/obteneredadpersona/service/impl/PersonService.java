package org.ggomezr.obteneredadpersona.service.impl;

import org.ggomezr.obteneredadpersona.service.IPersonService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
@Service
public class PersonService implements IPersonService {
    @Override
    public String calculateAge(int day, int month, int year) {

        StringBuilder age = new StringBuilder();

        int calculatedAge = LocalDateTime.now().getYear() - year;

        if(calculatedAge < 0){
            return "Couldn't calculate the age";
        }

        age.append("<h1>Calculate age</h1>");

        age.append("<p><strong>Birthdate: </strong>").append(day).append("/")
                .append(month).append("/")
                .append(year).append("</p>");

        age.append("<p><strong>Age: </strong>").append(calculatedAge).append("</p>");

        return age.toString();
    }
}
