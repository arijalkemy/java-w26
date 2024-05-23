package org.miprimerproyecto.joyerialasperlas.controller;

import org.miprimerproyecto.joyerialasperlas.model.Jewel;
import org.miprimerproyecto.joyerialasperlas.service.IJewelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jewerly")
public class JewelController {

    @Autowired
    private IJewelService jewelService;

    @PostMapping("/new")
    public ResponseEntity<?> createJewel(@RequestBody Jewel jewel){
        jewelService.saveJewel(jewel);
        return ResponseEntity.status(HttpStatus.OK)
                .body("Se ha creado la joya con la identificacion "+jewel.getNro_identificatorio());

    }

    @GetMapping()
    public List<Jewel> getJewerly(){
        return jewelService.getJewel();
    }

    @PostMapping("/delete/{id}")
    public String deleteJewel(@PathVariable Long id){
        return jewelService.deleteJewel(id);
    }

    @PutMapping ("/update/{id_modificar}")
    public String editJoya (@PathVariable Long id_modificar,
                            @RequestBody Jewel joya) {

        return jewelService.editJewel(id_modificar, joya);
    }
}
