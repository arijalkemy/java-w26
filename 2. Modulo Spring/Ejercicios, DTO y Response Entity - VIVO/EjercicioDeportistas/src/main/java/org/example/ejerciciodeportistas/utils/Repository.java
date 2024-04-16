package org.example.ejerciciodeportistas.utils;

import org.example.ejerciciodeportistas.entities.Person;
import org.example.ejerciciodeportistas.entities.Sport;

import java.util.List;

public abstract class Repository {

    static Sport tennis = new Sport("Tennis", "Amateur");
    static Sport golf = new Sport("Golf", "Profesional");
    static Sport basket = new Sport("Basket", "Amateur");

    public static List<Sport> sportsList = List.of(tennis, golf, basket);


    static Person persona1 = new Person("juancito",
            "Perez",
            13,
            tennis);

    static Person persona2 = new Person("Luis",
            "Miguel",
            50,
            golf);

    static Person persona3 = new Person("Marco",
            "Solis",
            60,
            basket);

    public static List<Person> personsList = List.of(persona1, persona2, persona3);
}
