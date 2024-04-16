package org.example.dto_p2_covid.symptoms;

import org.example.dto_p2_covid.person.Person;
import org.example.dto_p2_covid.person.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/")
public class SymptomService {
    @Autowired
    SymptomRepository symptomRepository;

    @Autowired
    PersonRepository personRepository;

    @GetMapping("/findSymptom")
    @ResponseBody
    public List<Symptom> findSymptom() {
        return symptomRepository.getAllSymptom();
    }
    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<String> findSymptom(@PathVariable String name) {
        Symptom symptom = symptomRepository.getAllSymptom()
                .stream()
                .filter(sym -> sym.getName().equalsIgnoreCase(name.trim()))
                .findAny()
                .orElse(null);
        if (symptom == null)
            return new ResponseEntity<>("Sintoma no encontrado", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(symptom.getLevel(), HttpStatus.OK);
    }

    @GetMapping("/findRiskPerson")
    @ResponseBody
    public List<RiskPersonDTO> findRiskPerson() {
        List<RiskPersonDTO> riskPersons = new ArrayList<>();
        List<Person> personList = personRepository.getAllPerson()
                .stream()
                .filter(p -> p.getAge() > 60)
                .toList();

        for (Person person : personList) {
            RiskPersonDTO riskPerson = new RiskPersonDTO();
            riskPerson.setPersonName(person.getName());
            riskPerson.setPersonLastname(person.getLastname());
            riskPersons.add(riskPerson);
        }

        return riskPersons;
    }
}
