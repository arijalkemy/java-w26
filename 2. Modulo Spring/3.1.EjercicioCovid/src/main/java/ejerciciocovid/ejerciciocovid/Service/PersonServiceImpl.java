package ejerciciocovid.ejerciciocovid.Service;

import ejerciciocovid.ejerciciocovid.Entity.Person;
import ejerciciocovid.ejerciciocovid.Entity.Symptom;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class PersonServiceImpl {
    private static List<Person> persons = List.of(new Person[]{
            new Person(1, "Juan", "Pérez", 25, Arrays.asList(
                    new Symptom(2, "Cough", 2),
                    new Symptom(5, "Fatigue", 2)
            )),
            new Person(2, "María", "González", 45, Arrays.asList(
                    new Symptom(1, "Fever", 3),
                    new Symptom(3, "Shortness of breath", 3),
                    new Symptom(5, "Fatigue", 2)
            )),
            new Person(3, "Pedro", "López", 60, Arrays.asList(
                    new Symptom(1, "Fever", 3),
                    new Symptom(2, "Cough", 2),
                    new Symptom(3, "Shortness of breath", 3),
                    new Symptom(4, "Loss of taste or smell", 2)
            )),
            new Person(4, "Ana", "Martínez", 32, Arrays.asList(
                    new Symptom(2, "Cough", 2),
                    new Symptom(4, "Loss of taste or smell", 2),
                    new Symptom(5, "Fatigue", 2)
            )),
            new Person(5, "Carlos", "Sánchez", 28, Arrays.asList(
                    new Symptom(1, "Fever", 3),
                    new Symptom(5, "Fatigue", 2)
            )),
            new Person(6, "Luis", "Rodríguez", 70, Arrays.asList(
                    new Symptom(1, "Fever", 3),
                    new Symptom(3, "Shortness of breath", 3),
                    new Symptom(4, "Loss of taste or smell", 2),
                    new Symptom(5, "Fatigue", 2)
            )),
            new Person(7, "Laura", "Fernández", 38, Arrays.asList(
                    new Symptom(1, "Fever", 3),
                    new Symptom(2, "Cough", 2),
                    new Symptom(3, "Shortness of breath", 3)
            )),
            new Person(8, "Miguel", "López", 20, Arrays.asList(
                    new Symptom(2, "Cough", 2),
                    new Symptom(5, "Fatigue", 2)
            )),
            new Person(9, "Elena", "Gómez", 55, Arrays.asList(
                    new Symptom(1, "Fever", 3),
                    new Symptom(3, "Shortness of breath", 3),
                    new Symptom(4, "Loss of taste or smell", 2)
            )),
            new Person(10, "Javier", "Martínez", 30, Arrays.asList(
                    new Symptom(1, "Fever", 3),
                    new Symptom(2, "Cough", 2),
                    new Symptom(4, "Loss of taste or smell", 2)
            ))

    });
    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        PersonServiceImpl.persons = persons;
    }

    public List<String> getRiskPersons(){

        return this.getPersons().stream()
                .filter(p-> p.getEdad() >= 60 && p.getSymptoms().size() > 0 )
                .map(p-> p.getNombre() + " " + p.getApellido()).toList();
    }
}
