package com.w26.deportista.deportistas;

import com.w26.deportista.deportistas.repositorio.RepositorioDeporte;
import com.w26.deportista.deportistas.repositorio.RepositorioDeportePersona;
import com.w26.deportista.deportistas.repositorio.RepositorioPersona;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DeportistasApplication {

    public static void main(String[] args) {

        RepositorioDeporte.getInstance().load();
        RepositorioPersona.getInstance().load();
        RepositorioDeportePersona.getInstance().load();;

        SpringApplication.run(DeportistasApplication.class, args);
    }

}
