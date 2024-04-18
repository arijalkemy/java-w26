package org.responseentity.responseentity.services.sport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sport")
public class SportController {

    @Autowired
    SportService sportService;

    @GetMapping
    public ResponseEntity<List<SportDTO>> findSports(){
        List<SportDTO> sports = this.sportService.getSports();
        if(sports.isEmpty()){
            return new ResponseEntity<>(sports, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(sports, HttpStatus.OK);
    }

    @GetMapping(path = "/{sportName}")
    public ResponseEntity<SportDTO> findSportByName(@PathVariable String sportName){
        SportDTO sport = this.sportService.findSportByName(sportName);
        if(sport == null){
            return new ResponseEntity<>(
                    null,
                    HttpStatus.OK
            );
        }

        return new ResponseEntity<>(
                sport,
                HttpStatus.OK
        );
    }

    @PostMapping
    public ResponseEntity<String> insertSport(@RequestBody SportDTO sportDTO){
        this.sportService.insertSport(sportDTO);
        return new ResponseEntity<>("Se inserto correctamente el deporte", HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<List<SportDTO>> deleteSport(@RequestParam("sportName") String sportName){
        List<SportDTO> updatedSports = this.sportService.deleteSporte(sportName);
        return new ResponseEntity<>(updatedSports, HttpStatus.OK);
    }
}
