package main.controller;

import main.model.PersonDTO;
import main.model.SintomaDTO;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.List;

public interface ICovidTracker {
    public ResponseEntity<HashMap<Integer, List<SintomaDTO>>> allSintoms();
    public ResponseEntity<SintomaDTO> sintomsByName(Integer id);
    public ResponseEntity<List<PersonDTO>> vulnerableList();

}
