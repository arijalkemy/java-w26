package com.nummeroromanos.controller;

import com.nummeroromanos.service.IRomanosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/romano")
public class RomanoController {

    @Autowired
    IRomanosService romanosService;


    @GetMapping("/{number}")
    public String convertirDeDecimalANumeroRomano(@PathVariable Integer number) {
        return romanosService.convertirDeDecimalANumeroRomano(number);
    }


}
