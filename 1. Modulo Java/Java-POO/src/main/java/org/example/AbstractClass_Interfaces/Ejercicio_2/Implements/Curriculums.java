package org.example.AbstractClass_Interfaces.Ejercicio_2.Implements;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.AbstractClass_Interfaces.Ejercicio_2.Services.Imprimible;

import java.util.List;

@Data
@AllArgsConstructor
public class Curriculums implements Imprimible {

    private Person person;

    private List<String> skills;

    @Override
    public void viewData() {
        System.out.println("---------------------------");
        System.out.println("Name: " + person.getName());
        System.out.println("Age: " + person.getAge());
        System.out.println("Skills: ");
        for (String skill : skills) {
            System.out.println(skill);
        }
    }
}
