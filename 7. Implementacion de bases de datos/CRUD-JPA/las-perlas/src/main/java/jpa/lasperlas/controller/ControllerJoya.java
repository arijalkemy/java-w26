package jpa.lasperlas.controller;

import jpa.lasperlas.model.Joya;
import jpa.lasperlas.service.IServiceJoya;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;

@RestController
public class ControllerJoya {

    @Autowired
    private IServiceJoya serviceJoya;

    @PostMapping("jewerly/new")
    public ResponseEntity<?> createJewerly(@RequestBody Joya joya) {
        return serviceJoya.crearJoya(joya);
    }



}
