package mainApp.controller;

import mainApp.data.DataBaseEmu;
import model.PersonDTO;
import model.SportDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class QuerySport implements IQuerySport{

    DataBaseEmu dataBase;


    QuerySport(){
        dataBase = new DataBaseEmu();
        dataBase.populate();
    }




    @Override
    public ResponseEntity<List<SportDTO>> allSports() {
        return new ResponseEntity<>(dataBase.listaSports, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<SportDTO> findByName(String name) {
        return new ResponseEntity<>(dataBase.listaSports.get(0), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<PersonDTO>> allSporters() {
        return new ResponseEntity<>(dataBase.listaPersonas, HttpStatus.OK);
    }
}
