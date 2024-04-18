package org.example.integradorstarwars.service;

import java.io.IOException;
import java.util.List;

public interface ICharacterService <T>{

    public List<T> findByName(String name) throws IOException;
}
