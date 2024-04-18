package com.athletes.bootcamp.repositories;

import com.athletes.bootcamp.classes.Person;
import com.athletes.bootcamp.classes.Sport;


import java.util.ArrayList;
import java.util.List;

public class Repository {
     public static List<Person> persons;
     public static List<Sport> sports;

     static {
          sports = new ArrayList<>();
          persons = new ArrayList<>();

          Sport basketball = new Sport("Basketball", 1);
          Sport football = new Sport("Football", 2);


          sports.add(basketball);
          sports.add(football);

          persons.add(new Person("Blas", "Bulacio", 23, basketball));
          persons.add(new Person("Otra", "Persona", 18, football));
          persons.add(new Person("Otro", "Futbolero", 18, football));
     }

}
