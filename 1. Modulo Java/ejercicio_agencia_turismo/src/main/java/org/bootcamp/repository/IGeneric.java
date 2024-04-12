package org.bootcamp.repository;

public interface IGeneric <T>{


     T guardar(T objeto);

    T buscar(int id);

}
