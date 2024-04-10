package org.example.CarreraDeLaSelva;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Competitor {

    private Integer number;

    //private Integer dni;

    private String name;

    private Integer age;

    //private  Integer nCel;

    //private Integer nEmergency;

    //private String bloodType;

    private Category category;

    private boolean isOlder;

    public Competitor(Integer number, String name, Integer age, Category category) {
        this.number = number;
        this.name = name;
        this.age = age;
        this.category = category;
        this.isOlder = age >= 18;
    }

    @Override
    public String toString() {
        return "Competitor{" +
                "number=" + number +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", category=" + category +
                ", isOlder=" + isOlder +
                '}';
    }
}
