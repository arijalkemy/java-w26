package co.com.mercadolibre.edadpersona.controller;

import co.com.mercadolibre.edadpersona.service.IEdadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class EdadController {

    @Autowired
    private IEdadService edadService;

    @GetMapping("/{dia}/{mes}/{anio}")
    public ResponseEntity<Integer> calcularEdad(@PathVariable Integer dia, @PathVariable Integer mes, @PathVariable Integer anio) {
        return new ResponseEntity<>(edadService.calcularEdad(dia, mes, anio), HttpStatus.OK);
    }
}
