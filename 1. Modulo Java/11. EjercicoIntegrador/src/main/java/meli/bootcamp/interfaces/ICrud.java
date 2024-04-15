package meli.bootcamp.interfaces;

import java.util.List;

public interface ICrud <T>{

    public void save(T ... t );

    public List<T> findAll();


    public void delete(T t );

    public void update(T t );

    public T findById(Long id);
}