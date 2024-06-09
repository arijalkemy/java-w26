package org.example.dto_p1_sports.service.implementation;

import lombok.RequiredArgsConstructor;
import org.example.dto_p1_sports.entity.Person;
import org.example.dto_p1_sports.repository.interfaces.IPersonRepository;
import org.example.dto_p1_sports.repository.interfaces.ISportRepository;
import org.example.dto_p1_sports.service.interfaces.ISportService;
import org.example.dto_p1_sports.entity.Sport;
import org.example.dto_p1_sports.dto.SportDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SportServiceImp implements ISportService {
    private final ISportRepository sportRepository;
    private final IPersonRepository personRepository;

    @Override
    public List<Sport> getAllSports() {
        return sportRepository.findAll();
    }

    @Override
    public String getSportLevel(String name) {
        Sport foundSport = sportRepository.findByName(name);
        if (foundSport == null) {
            return "Deporte no encontrado";
        }
        return foundSport.getLevel();
    }

    @Override
    public List<SportDTO> getPersonSport() {
        List<Sport> allSports = sportRepository.findAll();
        List<Person> allPersons = personRepository.getAll();

        List<SportDTO> sportDTOList = new ArrayList<>();
        for(int i = 0; i < allSports.size(); i++) {
            SportDTO sportDTO = new SportDTO();
            sportDTO.setSportName(allSports.get(i).getName());
            sportDTO.setName(allPersons.get(i).getName());
            sportDTO.setLastname(allPersons.get(i).getLastname());
            sportDTOList.add(sportDTO);
        }

        return sportDTOList;
    }
}
