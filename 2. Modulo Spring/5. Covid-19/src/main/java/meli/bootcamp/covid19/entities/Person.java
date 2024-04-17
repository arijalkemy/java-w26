package meli.bootcamp.covid19.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data @NoArgsConstructor @AllArgsConstructor
public class Person {
    private Integer id;
    private String name;
    private String surname;
    private Integer age;
    private List<Symptom> symptoms;
}
