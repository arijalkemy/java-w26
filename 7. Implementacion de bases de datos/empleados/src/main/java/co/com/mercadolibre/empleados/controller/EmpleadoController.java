package co.com.mercadolibre.empleados.controller;

import co.com.mercadolibre.empleados.dto.EmpleadoDTO;
import co.com.mercadolibre.empleados.service.IEmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController {

    @Autowired
    private IEmpleadoService empleadoService;

    @PostMapping()
    public ResponseEntity<?> create(@RequestBody EmpleadoDTO empleadoDTO) {
        return ResponseEntity.ok(empleadoService.create(empleadoDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody EmpleadoDTO empleadoDTO, @PathVariable String id) {
        return ResponseEntity.ok(empleadoService.update(empleadoDTO, id));
    }

    @GetMapping()
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(empleadoService.findAll());
    }
}
