package perlas.joyeria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import perlas.joyeria.dto.JoyaDto;
import perlas.joyeria.service.IJoyaService;

@RestController
public class JoyaController {

    @Autowired
    private IJoyaService joyaService;

    @PostMapping("/jewerly/new")
    public ResponseEntity<?> createJewerly(@RequestBody JoyaDto joyaDto){
        return new ResponseEntity(joyaService.saveJoya(joyaDto), HttpStatus.CREATED);
    }

    @GetMapping("/jewerly")
    public ResponseEntity<?> getJewerly(){
        return new ResponseEntity(joyaService.getJoyas(), HttpStatus.OK);
    }

    @DeleteMapping("/jewerly/delete/{id}")
    public ResponseEntity<?> deleteJewerly(@PathVariable long id){
        return new ResponseEntity(joyaService.deleteJoya(id), HttpStatus.OK);
    }

    @PutMapping("/jewerly/update/{id}")
    public ResponseEntity<?> updateJewerly(@PathVariable long id, @RequestBody JoyaDto joyaDto){
        return new ResponseEntity(joyaService.updateJoya(id, joyaDto), HttpStatus.OK);
    }
}
