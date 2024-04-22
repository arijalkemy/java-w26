package meli.bootcamp.blog.repository.interfaces;

import java.util.List;

public interface ICrud<T> {
    T save(T t);
    T findById(Integer id);
    List<T> findAll();
}
