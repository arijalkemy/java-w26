package meli.bootcamp.calculadora.repository.interfaces;

import java.util.List;

public interface ICrud<T> {
    public List<T> findAll();
}