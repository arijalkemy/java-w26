package org.example.starswars.service;

import org.example.starswars.DTO.CharacterDto;

import java.util.List;

public interface IfindService {
    List<CharacterDto> findCharacters(String name);
}
