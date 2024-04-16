package com.example.edadPersona.Controller;

import com.example.edadPersona.Service.EdadServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class EdadController {

    @Autowired
    EdadServiceImpl edadService;

    @GetMapping("/{dia}/{mes}/{anio}")
    public int edadPorFecha(@PathVariable String dia,
                            @PathVariable String mes,
                            @PathVariable String anio){
        return edadService.edadPorFecha(anio, mes, dia);
    }
}
