package com.Ejercicio.Deportistas.Controller;

import com.Ejercicio.Deportistas.DTO.PersonDTO;
import com.Ejercicio.Deportistas.Service.IPersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class PersonController {

    private IPersonService iPersonService;

    public PersonController(IPersonService iPersonService) {
        this.iPersonService = iPersonService;
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<?> getAllSportsPersons(){
        List<PersonDTO> personDTOList = iPersonService.findAllPerson();
        return new ResponseEntity<>(personDTOList, HttpStatus.OK);
    }
}
