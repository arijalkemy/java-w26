package org.example.starswars.repository;

import org.example.starswars.Model.Character;

import java.util.List;

public interface IcharacterRepository {
    List<Character> allCharacters();
}
