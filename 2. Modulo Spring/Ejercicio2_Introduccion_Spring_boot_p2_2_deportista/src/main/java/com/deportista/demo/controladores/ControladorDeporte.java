package com.deportista.demo.controladores;

import com.deportista.demo.dto.DTODeportista;
import com.deportista.demo.modelo.Deporte;
import com.deportista.demo.servicios.IServicioDeportista;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ControladorDeporte {
    @Autowired
    private IServicioDeportista servicioDeportista;

    @GetMapping("/encuentradeportes")
    public List<Deporte> obtenerDeportes(){
        return servicioDeportista.listarDeportes();
    }

    @GetMapping("/encuentradeportes/{name}")
    public Deporte obtenerDeporte(@PathVariable String name){
        return servicioDeportista.obtenerDeporte(name);
    }

    @GetMapping("/deportepersonas")
    public List<DTODeportista> obtenerDeportista(){
        return servicioDeportista.listarDTOdeportista();
    }
}
