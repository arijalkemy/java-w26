package ejercicioDeportista.ejercicioDeportista.controlador;


import ejercicioDeportista.ejercicioDeportista.entidades.Deporte;
import ejercicioDeportista.ejercicioDeportista.entidades.Persona;
import ejercicioDeportista.ejercicioDeportista.servicio.IDeportePersonaService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
public class DeporteController {

    @Autowired
    IDeportePersonaService deporteService;

    @GetMapping("/findSports")
    public ResponseEntity<List<Deporte>> findAllSports() {
        List<Deporte> deportes = deporteService.findAllSports();
        return new ResponseEntity<>(deportes, HttpStatus.OK);
    }
    @GetMapping("/findSports/{name}")
    public String findSport(@PathVariable String name) {
        return deporteService.findSportsByName(name);
    }

}
