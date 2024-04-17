package org.bootcamp.deportes.restcontroller;

import org.bootcamp.deportes.mapper.DeporteMapper;
import org.bootcamp.deportes.service.DeporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sports")
public class DeporteRestController {

    @Autowired
    private DeporteService deporteService;
    @Autowired
    private DeporteMapper deporteMapper;

    @GetMapping("/findSports")
    public ResponseEntity<?> obtenerDeporte(){
        return ResponseEntity.ok(deporteMapper.deporteListaADeporteDTOLista(deporteService.obtenerDeportes()));
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<?> obtenerNivelDeportePorNombre(@PathVariable String name){
        return ResponseEntity.ok(deporteService.obtenerNivelPorNombreDeporte(name));
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<?> encontrarPersonasPorDeporte(){
        return ResponseEntity.ok(deporteService.obtenerPersonasPorDeporte());
    }


}
