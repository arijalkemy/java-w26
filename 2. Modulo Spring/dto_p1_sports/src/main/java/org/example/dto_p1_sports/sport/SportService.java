package org.example.dto_p1_sports.sport;

import java.util.ArrayList;
import java.util.List;

import org.example.dto_p1_sports.person.Person;
import org.example.dto_p1_sports.person.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SportService {

    @Autowired
    SportRepository sportRepository;

    @Autowired
    PersonRepository personRepository;

    @GetMapping("/findSports")
    @ResponseBody
    public List<Sport> findSports() {
        return sportRepository.findSports();
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<String> findSport(@PathVariable String name) {
        List<Sport> allSports = sportRepository.findSports();
        Sport foundSport = allSports.stream()
                .filter(sport -> sport.getName().toLowerCase().trim().equals(name.toLowerCase().trim()))
                .findAny()
                .orElse(null);
        if (foundSport == null) {
            return new ResponseEntity<>("Deporte no encontrado", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(foundSport.getLevel(), HttpStatus.OK);
    }

    @GetMapping("/findSportsPersons")
    @ResponseBody
    public List<SportDTO> findSportsPersons() {
        List<Sport> allSports = sportRepository.findSports();
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
