package com.Ejercicio.Deportistas.Repository;
import com.Ejercicio.Deportistas.Entity.Person;
import com.Ejercicio.Deportistas.Entity.Sport;
import java.util.List;
@org.springframework.stereotype.Repository
public class Repository {
    public static List<Sport> sportList = List.of(
            new Sport("Tennis", "Principiante"),
            new Sport("Basket", "Intermedio"),
            new Sport("Futbol", "Avanzado"));

    public static List<Person> personList = List.of(
            new Person("Bruno", "Donato", 23, sportList.get(0)),
            new Person("Maria", "Perez", 30, sportList.get(1)),
            new Person("Juan", "Gomez", 35, sportList.get(2)));

}
