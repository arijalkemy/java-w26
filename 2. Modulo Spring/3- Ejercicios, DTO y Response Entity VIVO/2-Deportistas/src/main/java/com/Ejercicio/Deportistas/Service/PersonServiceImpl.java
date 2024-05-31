package com.Ejercicio.Deportistas.Service;

import com.Ejercicio.Deportistas.DTO.PersonDTO;
import com.Ejercicio.Deportistas.Entity.Person;
import com.Ejercicio.Deportistas.Exception.NotFoundException;
import com.Ejercicio.Deportistas.Repository.IPersonRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonServiceImpl implements IPersonService {
    private IPersonRepository personRepository;
    private ModelMapper modelMapper;

    public PersonServiceImpl(IPersonRepository personRepository) {
        this.personRepository = personRepository;
        this.modelMapper = new ModelMapper();
        mapPersonDto();
    }

    @Override
    public List<PersonDTO> findAllPerson() {
        List<Person> personList = personRepository.findAllPerson();

        if (personList == null || personList.isEmpty()) {
            throw new NotFoundException("No persons found");
        }

        List<PersonDTO> personDTOList = personList.stream()
                .map(person -> modelMapper.map(person, PersonDTO.class))
                .collect(Collectors.toList());
        return personDTOList;
    }

    private void mapPersonDto() {
        this.modelMapper.createTypeMap(Person.class, PersonDTO.class)
                .addMappings(mapper -> mapper.map(src -> src.getSport().getName(), PersonDTO::setSportName));
    }
}
