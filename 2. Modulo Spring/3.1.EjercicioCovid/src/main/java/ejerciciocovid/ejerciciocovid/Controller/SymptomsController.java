package ejerciciocovid.ejerciciocovid.Controller;

import ejerciciocovid.ejerciciocovid.DTO.RiskPersonDTO;
import ejerciciocovid.ejerciciocovid.Entity.Symptom;
import ejerciciocovid.ejerciciocovid.Service.PersonServiceImpl;
import ejerciciocovid.ejerciciocovid.Service.SymtomsServiceImpl;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Symptoms")
public class SymptomsController {

    @Autowired
    SymtomsServiceImpl symtomsService;

    @Autowired
    PersonServiceImpl personService;

    @GetMapping("/findSymptom")
    public List<Symptom> allSymptoms() {
        System.out.println(symtomsService.getAllSymptoms());
        return symtomsService.getAllSymptoms();

    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity findSymptom(@PathVariable String name){
        return new ResponseEntity(symtomsService.getSymptom(name) , HttpStatus.OK);
    }


    @GetMapping("/findRiskPerson")
    public ResponseEntity findRiskPerson(){
        return new ResponseEntity(RiskPersonDTO.getRiskPersons(personService.getPersons()), HttpStatus.OK);
    }
}
