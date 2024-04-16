package com.w26.morse.morse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.w26.morse.morse.controlador.MorseControlador;
import com.w26.morse.morse.servicio.MorseServicio;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.imageio.IIOException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class MorseApplication {

    public static void main(String[] args) throws IOException {
        MorseServicio.cargarMapa();
        SpringApplication.run(MorseApplication.class, args);
    }

}
