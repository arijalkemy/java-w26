package com.practicaSpring.starWars.repository;

import com.practicaSpring.starWars.model.Character;

import java.util.List;

public interface ICharacterRepository {
    public List<Character> findAll();
    public List<Character> findByString(String name);
}
