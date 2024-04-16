package main.controller;

import main.data.DataBase;
import main.model.PersonDTO;
import main.model.SintomaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class CovidTracker implements ICovidTracker{

    DataBase data;

    CovidTracker(){
        data = new DataBase();
        data.populate();
    }

    @Override
    public ResponseEntity<HashMap<Integer, List<SintomaDTO>>> allSintoms() {
        return new ResponseEntity<>(data.hashSintoms, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<SintomaDTO> sintomsByName(Integer id) {
        return new ResponseEntity<SintomaDTO>((SintomaDTO) data.hashSintoms.get(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<PersonDTO>> vulnerableList() {
        List<PersonDTO> listaVulnerables = data.personList.stream().filter(person -> person.getEdad() > 60).toList();
        return new ResponseEntity<>(listaVulnerables, HttpStatus.OK);
    }
}
