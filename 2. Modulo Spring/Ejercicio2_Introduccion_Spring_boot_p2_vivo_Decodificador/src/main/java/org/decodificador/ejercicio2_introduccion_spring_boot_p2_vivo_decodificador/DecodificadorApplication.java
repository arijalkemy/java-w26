package org.decodificador.ejercicio2_introduccion_spring_boot_p2_vivo_decodificador;

import org.decodificador.ejercicio2_introduccion_spring_boot_p2_vivo_decodificador.servicios.CodificacionMorse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DecodificadorApplication {

    public static void main(String[] args) {
        SpringApplication.run(DecodificadorApplication.class, args);
    }

}
