package com.bootcamp.course.service;

import java.util.List;

/**
 * Interface for generic service
 *
 * @param <T> Entity
 * @author jsanchezpimi
 **/
public interface IGenericService<T> {
    T findById(Long id);
    List<T> findAll();
    T save(T t);
    T update(Long id, T t);
    void delete(Long id);

}
