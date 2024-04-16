package com.w26.morse.morse.controlador;

import com.w26.morse.morse.servicio.MorseServicio;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/morse")
public class MorseControlador {
    @GetMapping("/decodificar/{mensaje}")
    public String decodificarMensaje(@PathVariable String  mensaje){
        return  MorseServicio.decodificar(mensaje);
    }

    @GetMapping("/codificar/{mensaje}")
    public String codificarMensaje(@PathVariable String mensaje) {
        return  MorseServicio.codificar(mensaje);
    }
}
