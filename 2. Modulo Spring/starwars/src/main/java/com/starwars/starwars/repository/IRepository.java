package com.starwars.starwars.repository;
import java.util.List;

import com.starwars.starwars.model.CharacterModel;

public interface IRepository {

    public List<CharacterModel> findByName(String name);
}
