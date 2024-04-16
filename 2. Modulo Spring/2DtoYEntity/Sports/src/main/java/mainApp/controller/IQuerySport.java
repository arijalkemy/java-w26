package mainApp.controller;

import model.PersonDTO;
import model.SportDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IQuerySport {
    public ResponseEntity<List<SportDTO>> allSports();
    public ResponseEntity<SportDTO> findByName(String name);
    public ResponseEntity<List<PersonDTO>> allSporters();
}
