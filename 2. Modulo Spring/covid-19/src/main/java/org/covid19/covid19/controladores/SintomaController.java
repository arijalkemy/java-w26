package org.covid19.covid19.controladores;

import org.apache.coyote.Response;
import org.covid19.covid19.dto.SintomaDto;
import org.covid19.covid19.servicios.ISintomaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/findSymptom")
public class SintomaController {

    final
    ISintomaServicio sintomaServicio;

    public SintomaController(ISintomaServicio sintomaServicio) {
        this.sintomaServicio = sintomaServicio;
    }

    @GetMapping
    public ResponseEntity<List<SintomaDto>> obtenerSintomas(){
        return ResponseEntity.ok(this.sintomaServicio.obtenerTodosLosSintomas());
    }
    @GetMapping("/{nombre}")
    public ResponseEntity<List<SintomaDto>> obtenerSintomasPorNombre(@PathVariable String nombre){
        return ResponseEntity.ok(this.sintomaServicio.obtenerSintomaPorNombre(nombre));
    }

}
