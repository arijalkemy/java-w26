package com.Ejercicio.Deportistas.Repository;

import com.Ejercicio.Deportistas.Entity.Person;
import java.util.List;

public interface IPersonRepository {
    List<Person> findAllPerson();
}
