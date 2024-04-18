package com.starwars.Personajes.de.starwar.repository;

import java.util.List;
import java.util.Optional;

public interface IRepository<T> {
    public Optional<T> findByName(String name);
    public List<T> findAll();
}
