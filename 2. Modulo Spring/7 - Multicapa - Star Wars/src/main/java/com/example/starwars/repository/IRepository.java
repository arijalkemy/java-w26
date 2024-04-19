package com.example.starwars.repository;

import com.example.starwars.model.Personaje;

import java.util.List;

public interface IRepository {

    List<Personaje> getData();
    void postData( List<Personaje> values );
}
