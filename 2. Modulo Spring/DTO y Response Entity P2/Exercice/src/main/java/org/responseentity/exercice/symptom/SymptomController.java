package org.responseentity.exercice.symptom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/symptom")
public class SymptomController {

    @Autowired
    SymptomService symptomService;

    @GetMapping("")
    public ResponseEntity<List<SymptomEntity>> listAllSymptoms(){
        return new ResponseEntity<>(
                this.symptomService.listSymptoms(),
                HttpStatus.OK
        );
    }

    @GetMapping("{name}")
    public ResponseEntity<String> getLevelOfSeverity(@PathVariable("name") String name){
        return new ResponseEntity<>(
                this.symptomService.getLevelOfSeverityByName(name),
                HttpStatus.OK
        );
    }

    @PostMapping
    public ResponseEntity<String> insertSymptom(@RequestBody SymptomEntity symptomEntity){
        this.symptomService.insertSymptom(symptomEntity);
        return new ResponseEntity<>("Se inserto correctamente el simtoma", HttpStatus.OK);
    }
}
