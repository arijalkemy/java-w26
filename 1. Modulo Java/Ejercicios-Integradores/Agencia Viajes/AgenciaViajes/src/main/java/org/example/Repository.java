package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class Repository {
    public List<Localizador> db;

    public Repository(){
        this.db = new ArrayList<>();
    }

    public Optional<Localizador> findById(UUID id){
        return db.stream().filter(loc -> loc.getId() == id).findFirst();
    }

    public void insert(Localizador localizador){
        this.db.add(localizador);
    }

    public void delete(UUID id){
        List<Localizador> tempDb = this.db.stream().filter(localizador -> !localizador.getId().equals(id)).toList();
        this.db = tempDb;
    }
}
