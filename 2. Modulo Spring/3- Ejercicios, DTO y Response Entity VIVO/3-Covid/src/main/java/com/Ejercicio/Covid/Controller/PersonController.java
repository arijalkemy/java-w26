package com.Ejercicio.Covid.Controller;

import com.Ejercicio.Covid.DTO.PersonDto;
import com.Ejercicio.Covid.Service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class PersonController {

    @Autowired
    IPersonService iPersonService;

    @GetMapping(path = "/getRiskPerson")
    public List<PersonDto> getRiskPerson (){
        return iPersonService.searchRiskPerson();
    }
}
