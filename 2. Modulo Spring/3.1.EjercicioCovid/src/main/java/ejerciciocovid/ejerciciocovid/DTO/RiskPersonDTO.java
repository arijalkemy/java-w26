package ejerciciocovid.ejerciciocovid.DTO;

import ejerciciocovid.ejerciciocovid.Service.PersonServiceImpl;
import ejerciciocovid.ejerciciocovid.Entity.Person;

import java.util.ArrayList;
import java.util.List;

public class RiskPersonDTO {

    public static List<String> getRiskPersons(List<Person> personServices){
        return personServices.stream()
                .filter(p-> p.getEdad() >= 60 && p.getSymptoms().size() > 0 )
                .map(p-> p.getNombre() + " " + p.getApellido()).toList();
    }
}
