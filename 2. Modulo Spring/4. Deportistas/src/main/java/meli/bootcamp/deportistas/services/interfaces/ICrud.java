package meli.bootcamp.deportistas.services.interfaces;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICrud<T> {
    public List<T> getAll();
    public T getOne(String name);
}
