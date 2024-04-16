package org.example.ejerciciodeportistas.services;

import org.example.ejerciciodeportistas.entities.Person;
import org.example.ejerciciodeportistas.entities.PersonDTO;
import org.example.ejerciciodeportistas.entities.Sport;
import org.example.ejerciciodeportistas.utils.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SportsServiceImpl implements ISportsService {

    //obtiene una lista de los deportes registrados
    @Override
    public List<Sport> getSports() {
        return Repository.sportsList;
    }

    //obtiene el nivel de un deporte buscando por el nombre del deporte
    @Override
    public String getSportByName(String name) {

        for (Sport sport : Repository.sportsList) {
            //si encuentro ese nombre de deporte, devuelvo el nivel
            if (sport.getName().equalsIgnoreCase(name)) {
                return sport.getLevel();
            }
        }
        return null; // si no lo encuentro devuelvo null
    }

    // obtiene una lista de personas deportistas
    @Override
    public List<PersonDTO> getSportsPersons() {

        //creo una lista de DTOs vacia para luego llenarla en base a los
        // Person objects de la lista del repositorio
        List<PersonDTO> personDTOList = new ArrayList<>();

        for(Person person : Repository.personsList) {

            //creo una instancia de personDTO
            PersonDTO personDTO = new PersonDTO();
            //seteo el DTO con los datos de person actual
            personDTO.setName(person.getName());
            personDTO.setLastName(person.getLastName());
            personDTO.setSportName(person.getSport().getName());
            //agrego la instancia de DTO a la lista de DTOs que cree antes del loop
            personDTOList.add(personDTO);
        }
        //devuelvo la lista de DTOs
        return personDTOList;
    }


}
