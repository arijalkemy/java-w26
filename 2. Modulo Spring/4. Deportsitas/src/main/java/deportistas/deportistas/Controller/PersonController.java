package deportistas.deportistas.Controller;


import deportistas.deportistas.DTO.PersonDTO;
import deportistas.deportistas.Entity.Person;
import deportistas.deportistas.Service.IpersonService;
import deportistas.deportistas.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Persons")
public class PersonController {

    @Autowired
    IpersonService personService;

    @GetMapping("/FindSportsPersons")
    public ResponseEntity<List<PersonDTO>> findSportsPersons(){
        return new ResponseEntity(personService.getSportsPersons(), HttpStatus.OK);
    }
}
