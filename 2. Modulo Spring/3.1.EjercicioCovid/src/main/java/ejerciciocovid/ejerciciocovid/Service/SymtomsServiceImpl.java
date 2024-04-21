package ejerciciocovid.ejerciciocovid.Service;

import ejerciciocovid.ejerciciocovid.Entity.Symptom;
import ejerciciocovid.ejerciciocovid.Entity.Person;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SymtomsServiceImpl implements  IsymptomService {

    private static List<Symptom> symptoms = List.of(new Symptom[]{
        new Symptom(1, "Fever", 3),
        new Symptom(2, "Cough", 2),
        new Symptom(3, "Shortness of breath", 3),
        new Symptom(4, "Loss of taste or smell", 2),
        new Symptom(5, "Fatigue", 2)
    });



    @Override
    public List<Symptom> getAllSymptoms() {
        return this.symptoms;
    }

    @Override
    public Optional<Symptom> getSymptom(String name) {
        return this.getAllSymptoms()
                .stream()
                .filter(symptom -> symptom.getNombre().equalsIgnoreCase(name))
                .findFirst();

    }

    public static List<Symptom> getSymptoms() {
        return symptoms;
    }

    public static void setSymptoms(List<Symptom> symptoms) {
        SymtomsServiceImpl.symptoms = symptoms;
    }
}
