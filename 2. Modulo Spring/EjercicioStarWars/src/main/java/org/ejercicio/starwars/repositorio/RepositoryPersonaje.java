package org.ejercicio.starwars.repositorio;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.ejercicio.starwars.entity.Personaje;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.IOException;
import java.util.List;
@Repository
public abstract class RepositoryPersonaje {
    public static List<Personaje> obtenerPersonajesDeArchivos() throws IOException {

        ClassPathResource archivo = new ClassPathResource("starwars.json");

        // Mapear el archivo JSON a una lista de objetos de la clase Character
        ObjectMapper mapeadorDeObjetos = new ObjectMapper();

        return mapeadorDeObjetos.readValue(archivo.getInputStream(), new TypeReference<>() {});
    }
}
