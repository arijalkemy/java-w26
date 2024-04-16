package main.controller;

import main.model.PersonDTO;
import main.model.SintomaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class CovidTrackerController {
    @Autowired
    ICovidTracker tracker;

    @GetMapping("/symptoms")
    public ResponseEntity<HashMap<Integer, List<SintomaDTO>>> symptomsMapper(){
        return tracker.allSintoms();
    }

    @GetMapping("/symptoms/{name}/")
    public ResponseEntity<SintomaDTO> symptomsByName(@PathVariable Integer name){
        return tracker.sintomsByName(name);
    }

    @GetMapping("/patients")
    public ResponseEntity<List<PersonDTO>> patientList(){
        return tracker.vulnerableList();
    }


}
