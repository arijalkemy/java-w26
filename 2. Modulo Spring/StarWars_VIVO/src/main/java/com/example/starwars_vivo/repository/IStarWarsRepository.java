package com.example.starwars_vivo.repository;

import com.example.starwars_vivo.entity.Character;

import java.util.List;

public interface IStarWarsRepository {
    public List<Character> readCharactersFromJson();
}
