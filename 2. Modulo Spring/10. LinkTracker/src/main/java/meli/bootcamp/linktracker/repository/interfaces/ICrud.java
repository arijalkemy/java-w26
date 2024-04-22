package meli.bootcamp.linktracker.repository.interfaces;

import java.util.List;

public interface ICrud<T>{
    void save(T t);
    T findById(Integer id);
    List<T> findAll();
}
