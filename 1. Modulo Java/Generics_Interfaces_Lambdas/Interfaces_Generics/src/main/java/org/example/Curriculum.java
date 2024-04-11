package org.example;

import java.util.List;

public class Curriculum implements IDocument {
    private String name;
    private int age;
    private String country;
    private List<String> skills;

    public Curriculum(String name, int age, String country, List<String> skills) {
        this.name = name;
        this.age = age;
        this.country = country;
        this.skills = skills;
    }

    @Override
    public void print() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "Curriculum{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", country='" + country + '\'' +
                ", skills=" + skills +
                '}';
    }
}
