package org.example.tiendadeprendas.controller;

import org.apache.coyote.Response;
import org.example.tiendadeprendas.dto.PrendaDto;
import org.example.tiendadeprendas.dto.VentaDto;
import org.example.tiendadeprendas.service.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/sale")
public class VentaController {

    @Autowired
    private IVentaService ventaService;

    @PostMapping
    public ResponseEntity<?> postVenta(@RequestBody VentaDto ventaDto){
        ventaService.createVenta(ventaDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<VentaDto>> getAllVentas(){
        List<VentaDto> ventasDto = ventaService.allVentas();
        return new ResponseEntity<>(ventasDto, HttpStatus.OK);
    }

    @GetMapping("/{number}")
    public ResponseEntity<VentaDto> getVentaByNumber(@PathVariable String number){
        VentaDto ventaDto = ventaService.findByIdVenta(number);
        return new ResponseEntity<>(ventaDto, HttpStatus.OK);
    }

    @GetMapping("/sale")
    public ResponseEntity<?> getPrendaByTimeSell(@RequestParam("date") LocalDate date) {
        return ResponseEntity.status(HttpStatus.OK).body(ventaService.findAllPrendasByFecha(date));
    }

    @GetMapping("/clothes/{number}")
    public ResponseEntity<List<PrendaDto>> getPrendasBySale(@PathVariable String number){
        List<PrendaDto> prendasDto = ventaService.findAllPrendasByVenta(number);
        return new ResponseEntity<>(prendasDto, HttpStatus.OK);
    }


    @PutMapping("/{number}")
    public ResponseEntity<?> updateVentaByNumber(@PathVariable String number, @RequestBody VentaDto ventaDto){
        ventaService.updateVenta(number, ventaDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{number}")
    public ResponseEntity<?> deleteVentaByNumber(@PathVariable String number){
        ventaService.deleteVenta(number);
        return ResponseEntity.noContent().build();
    }
}
