package com.deporte.deportistas.Controller;
import com.deporte.deportistas.Service.Interfaces.IDeporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeporteController {

    @Autowired
    IDeporteService deporteService;

    @GetMapping("/findSports")
    public ResponseEntity<String> getDeportes(){
        return new ResponseEntity<>(this.deporteService.getDeportes(), HttpStatus.OK);
    }

    @GetMapping("/findSports/{name}")
    public ResponseEntity<String> getDeportesByName(@PathVariable String name){
        return new ResponseEntity<>(this.deporteService.getDeporteByName(name).toString(), HttpStatus.OK);
    }
}
