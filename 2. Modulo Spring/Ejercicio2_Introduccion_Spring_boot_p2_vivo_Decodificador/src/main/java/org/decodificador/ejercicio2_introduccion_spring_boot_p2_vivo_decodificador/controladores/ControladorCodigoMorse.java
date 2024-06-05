package org.decodificador.ejercicio2_introduccion_spring_boot_p2_vivo_decodificador.controladores;

import jakarta.websocket.server.PathParam;
import org.decodificador.ejercicio2_introduccion_spring_boot_p2_vivo_decodificador.servicios.ICodificacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControladorCodigoMorse {
    @Autowired
    private ICodificacion miCodificacion;

    @GetMapping("/codifica/{mensaje}")
    public String codificarMensaje(@PathVariable String mensaje){
        return miCodificacion.codificarMensaje(mensaje);
    }

    @GetMapping("/decodifica/{mensaje}")
    public String decodificarMensaje(@PathVariable String mensaje){
        return miCodificacion.decodificarMensaje(mensaje);
    }
}
