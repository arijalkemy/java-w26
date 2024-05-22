package co.com.mercadolibre.productos.controller;

import co.com.mercadolibre.productos.dto.ProductoDTO;
import co.com.mercadolibre.productos.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private IProductoService productoService;

    @PostMapping()
    public ResponseEntity<?> create(@RequestBody ProductoDTO productoDTO) {
        return ResponseEntity.ok(productoService.create(productoDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody ProductoDTO productoDTO, @PathVariable String id) {
        return ResponseEntity.ok(productoService.update(productoDTO, id));
    }

    @GetMapping()
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(productoService.findAll());
    }
}
