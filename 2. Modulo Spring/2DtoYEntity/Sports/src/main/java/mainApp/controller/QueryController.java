package mainApp.controller;

import model.PersonDTO;
import model.SportDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QueryController {

    @Autowired
    IQuerySport querySport;

    @GetMapping("/sport")
    @ResponseBody
    public ResponseEntity<List<SportDTO>> sportList(){
        return querySport.allSports();
    }

    @GetMapping("/id/{name}/")
    @ResponseBody
    public ResponseEntity<SportDTO> sportByName(@PathVariable String name){
        return querySport.findByName(name);
    }

    @GetMapping("/sporters")
    @ResponseBody
    public ResponseEntity<List<PersonDTO>> personList(){
        return querySport.allSporters();
    }

}
