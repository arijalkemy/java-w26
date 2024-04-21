package deportistas.deportistas.Controller;

import deportistas.deportistas.Entity.Sport;
import deportistas.deportistas.Service.PersonServiceImpl;
import deportistas.deportistas.Service.SportServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Sports")
public class SportsController {

    @Autowired
    SportServiceImpl sportService;

    @GetMapping("/findSports")
    public List<Sport> allSymptoms() {
        return sportService.getAllSports();

    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity findSymptom(@PathVariable String name){
        return new ResponseEntity(sportService.getSportByName(name) , HttpStatus.OK);
    }
}
