package org.example.be_java_hisp_w26_g04.util.crud;

import java.util.Optional;
import java.util.Set;

public interface ICRUD<T> {
    public Set<T> findAll();
    public Optional<T> findById(int id);
    public boolean save(T object);
}
