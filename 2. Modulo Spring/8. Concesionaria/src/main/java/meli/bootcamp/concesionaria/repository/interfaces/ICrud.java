package meli.bootcamp.concesionaria.repository.interfaces;

import java.util.List;

public interface ICrud<T> {
    void save(List<T> t);
    List<T> findAll();
    T findById(Integer id);
}
