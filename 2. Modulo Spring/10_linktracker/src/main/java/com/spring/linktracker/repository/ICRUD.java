package com.spring.linktracker.repository;

import java.util.List;

public interface ICRUD<T> {

    void create(T obj);

    T search(Integer id);

    void update(T obj);

    void delete(Integer id);

    List<T> getAll();


}
