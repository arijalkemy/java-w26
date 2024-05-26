package com.example.joyerialasperlas.controller;

import com.example.joyerialasperlas.model.Jewelry;
import com.example.joyerialasperlas.service.IJewelryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/jewelry")
public class JewelryController {

    private final IJewelryService jewelryService;

    public JewelryController(IJewelryService jewelryService) {
        this.jewelryService = jewelryService;
    }

    @PostMapping(path = "/new")
    public ResponseEntity<?> registerJewelry(@RequestBody Jewelry jewelry) {
        this.jewelryService.saveJewelry(jewelry);
        return ResponseEntity.ok(null);
    }

    @GetMapping()
    public ResponseEntity<?> getAllJewelry() {
        return ResponseEntity.ok(this.jewelryService.getAllJewelry());
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<?> deleteJewelryById(@PathVariable Long id) {
        this.jewelryService.deleteJewelry(id);
        return ResponseEntity.ok(null);
    }

    @PatchMapping(path = "/update/{id}")
    public ResponseEntity<?> updateJewelryById(@PathVariable Long id,
                                                @RequestBody Jewelry jewelry) {
        return ResponseEntity.ok(this.jewelryService.updateJewelry(id, jewelry));
    }
}
