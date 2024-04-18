package org.example.integradorcovid.service;

import java.util.List;

public interface ISymptom <T>{

    public List<T> findAll();
    public T find(String name);
}
