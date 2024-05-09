package com.meli.obtenerdiploma.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.model.StudentDTO;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.Set;

public class CargadorDatos {

    public static <T> Set<T> cargarDatosDeResourceJson(String pathEnResources, Class<T> clazz) {

        try {
            File file = ResourceUtils.getFile("classpath:" + pathEnResources);

            ObjectMapper mapper = new ObjectMapper();

            return mapper.readValue(
                file,
                mapper.getTypeFactory().constructCollectionType(Set.class, clazz)
            );
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void guardarStudentsEnResource(Set<StudentDTO> students, String pathEnResources) {

        try {
            File file = ResourceUtils.getFile("classpath:" + pathEnResources);

            new ObjectMapper().writeValue(file, students);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
