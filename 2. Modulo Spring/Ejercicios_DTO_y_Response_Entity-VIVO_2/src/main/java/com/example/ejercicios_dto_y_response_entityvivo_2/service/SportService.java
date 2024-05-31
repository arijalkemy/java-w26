package com.example.ejercicios_dto_y_response_entityvivo_2.service;

import com.example.ejercicios_dto_y_response_entityvivo_2.dto.DeportistDTO;
import com.example.ejercicios_dto_y_response_entityvivo_2.dto.SportDTO;
import com.example.ejercicios_dto_y_response_entityvivo_2.entity.Person;
import com.example.ejercicios_dto_y_response_entityvivo_2.entity.Sport;
import com.example.ejercicios_dto_y_response_entityvivo_2.exception.NotFoundException;
import com.example.ejercicios_dto_y_response_entityvivo_2.repository.PersonRepository;
import com.example.ejercicios_dto_y_response_entityvivo_2.repository.SportRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class SportService implements ISportService{

    @Autowired
    PersonRepository personRepository;
    @Autowired
    SportRepository sportRepository;

    final ModelMapper mm = new ModelMapper();


    @Override
    public List<SportDTO> getAll() {

        List<Sport> sportList = sportRepository.getAll();
        return sportList
                .stream()
                .map(sport -> mm.map(sport, SportDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public SportDTO getSport(String name) {
        Optional<Sport> isSport = sportRepository.getSport(name);
        if(isSport.isEmpty()){
            throw new NotFoundException("Not registrated sport");
        }
        return mm.map(isSport.get(), SportDTO.class);
    }

    @Override
    public List<DeportistDTO> getDeportist() {
        List<Sport> sportList = sportRepository.getAll(); //Lista completa
        List<Person> personList = personRepository.getAll();

        Random random = new Random();

        List<DeportistDTO> deportistList = new ArrayList<>();

        for (Person person : personList) {
            // Escoge un deporte aleatorio de la lista de deportes disponibles
            int randomIndex = random.nextInt(sportList.size());
            Sport randomSport = sportList.get(randomIndex);

            // Crea un DeportistDTO con la persona y el deporte asignado
            DeportistDTO deportistDTO = new DeportistDTO();
            deportistDTO.setName(person.getName());
            deportistDTO.setLastname(person.getLastName());;
            deportistDTO.setNameSport(randomSport.getName());
            // Agrega el DeportistDTO a la lista de resultados
            deportistList.add(deportistDTO);
        }

        return deportistList;
    }


}
