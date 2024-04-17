package bootcamp.bendezujonathan.covid.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    private int id;
    private String name;
    private String surname;
    private int age;
    private List<Symptom> symptoms;

    public List<String> getSymptomString() {
        return this.symptoms
                .stream()
                .map(Symptom::toString)
                .toList();
    }


    public boolean isOlder(int age) {
        return this.age >= age;
    }

    public boolean hasMoreThanSymptoms(int amount){
        return this.symptoms.size() >= amount;
    }
}
