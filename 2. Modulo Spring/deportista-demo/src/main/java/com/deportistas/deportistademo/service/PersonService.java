package com.deportistas.deportistademo.service;

import com.deportistas.deportistademo.dto.ResponsePersonDto;
import com.deportistas.deportistademo.entity.Person;
import com.deportistas.deportistademo.entity.Sport;
import com.deportistas.deportistademo.repository.IRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {
    IRepository<Person> personIRepository;
    IRepository<Sport>  sportIRepository;



    @Autowired
    public PersonService(IRepository<Person> personIRepository, IRepository<Sport> sportIRepository) {
        this.personIRepository = personIRepository;
        this.sportIRepository = sportIRepository;

        Sport sport1 = new Sport("Tennis",3);
        Sport sport2 = new Sport("Football",2);
        Sport sport3 = new Sport("Rugby",1);

        this.sportIRepository.add(sport1);
        this.sportIRepository.add(sport2);
        this.sportIRepository.add(sport3);


        Person person1 = new Person("Agustin","Juarez",28,sport1);
        Person person2 = new Person("Enzo","Cambon",29,sport2);
        Person person3 = new Person("Dilan","Torrez",20,sport3);

        this.personIRepository.add(person1);
        this.personIRepository.add(person2);
        this.personIRepository.add(person3);
    }

    public List<ResponsePersonDto> getDeportist(){
        return this.personIRepository.findAll().stream()
                .map(this::parsePersonToDto)
                .collect(Collectors.toList());
    }

    private ResponsePersonDto parsePersonToDto(Person person){
        return new ResponsePersonDto(person.getName(),person.getSurname(),person.getSport().getName());
    }
}
