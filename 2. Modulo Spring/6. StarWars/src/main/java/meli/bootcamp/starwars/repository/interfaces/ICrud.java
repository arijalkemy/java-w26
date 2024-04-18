package meli.bootcamp.starwars.repository.interfaces;

import java.util.List;

public interface ICrud<T>{
    List<T> findAll();
}
