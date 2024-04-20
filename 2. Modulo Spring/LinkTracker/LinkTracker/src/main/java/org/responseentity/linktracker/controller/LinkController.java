package org.responseentity.linktracker.controller;

import org.responseentity.linktracker.dto.LinkDTO;
import org.responseentity.linktracker.dto.LinkMetricDTO;
import org.responseentity.linktracker.exceptions.CustomIllegalArgumentExeption;
import org.responseentity.linktracker.service.LinkService;
import org.responseentity.linktracker.utils.Regex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api")
public class LinkController {

    @Autowired
    LinkService linkService;

    @PostMapping("/{subPath}")
    public ResponseEntity<?> insertLink(@PathVariable("subPath") String subPath){
        return new ResponseEntity<>(linkService.insertLink(subPath), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<?> getAllTheLinks(){
        return new ResponseEntity<>(linkService.getAllTheLinks(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getLinkById(@PathVariable("id") String id){
        boolean isValidUUID = Regex.isValidUUID(id);
        if(!isValidUUID){
            throw new CustomIllegalArgumentExeption("El formato de id no es correcto");
        }

        LinkDTO linkDTO = linkService.getLinkById(UUID.fromString(id));
        return new ResponseEntity<>(linkDTO, HttpStatus.OK);
    }

    @GetMapping("/metrics/{id}")
    public ResponseEntity<?> getMetricsOfLinkById(@PathVariable("id") String id){
        boolean isValidUUID = Regex.isValidUUID(id);
        if(!isValidUUID){
            throw new CustomIllegalArgumentExeption("El formato de id no es correcto");
        }

        return new ResponseEntity<>(
                linkService.getMetricsOfVideoById(UUID.fromString(id)),
                HttpStatus.OK
        );
    }

    @PostMapping("/invalidate/{id}")
    public ResponseEntity<?> invalidatesLink(@PathVariable("id") String id,  @RequestParam("pass") String pass){
        boolean isValidUUID = Regex.isValidUUID(id);
        if(!isValidUUID){
            throw new CustomIllegalArgumentExeption("El formato de id no es correcto");
        }

        return new ResponseEntity<>(
                linkService.invalidatesLinkById(UUID.fromString(id), pass),
                HttpStatus.OK
        );
    }
}
