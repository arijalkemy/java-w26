package org.example.starwars.service;

import org.example.starwars.dto.StarWarCharacterDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IStarWarService {
    ResponseEntity<List<StarWarCharacterDTO>> getAllPersonajes();
}
