package org.example.star_wars.repository;

import org.example.star_wars.entity.Character;

import java.util.*;

public interface ICharacterRepository {
    public List<Character> getAllCharacters();
}
