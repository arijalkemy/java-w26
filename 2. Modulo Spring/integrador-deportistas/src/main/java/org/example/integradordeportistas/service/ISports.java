package org.example.integradordeportistas.service;

import java.util.List;

public interface ISports <T> {
    public List<T> findAll();
    public T find(String name);
}
