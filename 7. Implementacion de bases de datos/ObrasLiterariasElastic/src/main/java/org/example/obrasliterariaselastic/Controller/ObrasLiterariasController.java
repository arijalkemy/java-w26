package org.example.obrasliterariaselastic.Controller;

import org.example.obrasliterariaselastic.Service.IObrasLiterariasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/obras")
public class ObrasLiterariasController {

    @Autowired
    private IObrasLiterariasService obrasLiterariasService;

    @GetMapping
    public ResponseEntity<?> buscarTodas() {
        return ResponseEntity.ok(this.obrasLiterariasService.obtenerTodas());
    }

    @GetMapping("/autor/{nombre}")
    public ResponseEntity<?> buscarPorAutor(@PathVariable String nombre) {
        return ResponseEntity.ok(this.obrasLiterariasService.obtenerDeAutor(nombre));
    }

    @GetMapping("/keyword/{keyword}")
    public ResponseEntity<?> buscarPorKeywordEnTitulo(@PathVariable String keyword) {
        return ResponseEntity.ok(this.obrasLiterariasService.obtenerPorTituloContiene(keyword));
    }

    @GetMapping("/top5")
    public ResponseEntity<?> buscarTop5ObrasConMasPaginasOrdenadas() {
        return ResponseEntity.ok(this.obrasLiterariasService.obtenerTop5ObrasConMasPaginasOrdenadas());
    }

    @GetMapping("/anioMenorA/{anio}")
    public ResponseEntity<?> buscarPorAnioPrimeraPublicacionMenorA(@PathVariable Integer anio) {
        return ResponseEntity.ok(this.obrasLiterariasService.obtenerPorAnioPrimeraPublicacionMenorA(anio));
    }

    @GetMapping("/editorial/{editorial}")
    public ResponseEntity<?> buscarPorEditorial(String editorial) {
        return ResponseEntity.ok(this.obrasLiterariasService.obtenerPorEditorial(editorial));
    }
}
