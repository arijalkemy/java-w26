package co.com.mercadolibre.miniseries.controller;

import co.com.mercadolibre.miniseries.dto.MiniSerieDTO;
import co.com.mercadolibre.miniseries.service.IMiniSerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/miniseries")
public class MiniSerieController {

    @Autowired
    private IMiniSerieService miniSerieService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody MiniSerieDTO miniSerieDTO) {
        return ResponseEntity.ok(miniSerieService.create(miniSerieDTO));
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(miniSerieService.findAll());
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return ResponseEntity.ok(miniSerieService.findById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@RequestBody MiniSerieDTO miniSerieDTO, @PathVariable Long id) {
        return ResponseEntity.ok(miniSerieService.update(miniSerieDTO, id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return ResponseEntity.ok(miniSerieService.delete(id));
    }
}
