package org.example.be_java_hisp_w26_g04.util.crud;

import org.example.be_java_hisp_w26_g04.exceptions.BadRequestException;

import java.util.Optional;
import java.util.Set;

public interface ICRUD<T> {
    public Set<T> findAll();
    public Optional<T> findById(int id);
    public int save(T object);
    public int update(T Object);
    public void delete(T Object);
}
