package com.jewelry.perls.controller;

import com.jewelry.perls.dto.JewerDto;
import com.jewelry.perls.service.IJewerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jewerly")
public class JewerlyController {

    @Autowired
    IJewerService jewerService;

    /**
     *
     * @param jewerDto : recibe el json de la joya para ser almacenada
     * @return retorna el mensaje indicador de funcionalidad
     */
    @PostMapping("/new")
    public ResponseEntity <?> saveJewer(@RequestBody JewerDto jewerDto){
        return new ResponseEntity<>(this.jewerService.saveJewer(jewerDto), HttpStatus.CREATED);
    }

    /**
     *
     * @return retorna la lista de joyas
     */
    @GetMapping
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(this.jewerService.getAll(),HttpStatus.OK);
    }

    /**
     *
     * @param id : identificador de la joya a eliminar
     * @return retorna el mensaje indicador de respuesta
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> removeJewer(@PathVariable Integer id){
        return new ResponseEntity<>(this.jewerService.deleteJewer(id),HttpStatus.OK) ;
    }

    /**
     *
     * @param id_modificar : id al cual se le desea aplicar la modificacion
     * @return retorna el json con la modificacion realizada
     */
    @PostMapping("/update/{id_modificar}")
    public ResponseEntity<?> changeJewer(@PathVariable Integer id_modificar, @RequestBody JewerDto jewerDto){
        return new ResponseEntity<>(this.jewerService.changeJewer(jewerDto,id_modificar), HttpStatus.ACCEPTED);
    }
}
