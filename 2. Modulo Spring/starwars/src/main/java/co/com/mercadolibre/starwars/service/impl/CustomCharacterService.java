package co.com.mercadolibre.starwars.service.impl;

import co.com.mercadolibre.starwars.dto.CustomCharacterDto;
import co.com.mercadolibre.starwars.entity.CustomCharacter;
import co.com.mercadolibre.starwars.repository.ICustomCharacterRepository;
import co.com.mercadolibre.starwars.service.ICustomCharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomCharacterService implements ICustomCharacterService {

    @Autowired
    private ICustomCharacterRepository characterRepository;

    @Override
    public CustomCharacterDto findByName(String name){
        CustomCharacter character = characterRepository.findByName(name);
        if (character == null) {
            return null;
        }
        return this.mapToDto(character);
    }

    private CustomCharacterDto mapToDto(CustomCharacter character) {
        CustomCharacterDto dto = new CustomCharacterDto();
        dto.setName(character.getName());
        dto.setHeight(character.getHeight());
        dto.setMass(character.getMass());
        dto.setGender(character.getGender());
        dto.setHomeworld(character.getHomeworld());
        dto.setSpecies(character.getSpecies());
        return dto;
    }
}
