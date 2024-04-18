package com.EjercicioSpring.Ejercicio11_Excepciones;

import com.EjercicioSpring.Ejercicio11_Excepciones.baseDeDatos.BaseDeDatos;
import com.EjercicioSpring.Ejercicio11_Excepciones.entity.Blog;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class Ejercicio11ExcepcionesApplication {

    public static void main(String[] args) {
        //cargarDatos();
        SpringApplication.run(Ejercicio11ExcepcionesApplication.class, args);
    }

    public static void cargarDatos() {
        Map<Long, Blog> testData = new HashMap<>();

        testData.put(1L, new Blog(1L, "Título 1", "Autor 1", LocalDate.of(2022, 1, 10)));
        testData.put(2L, new Blog(2L, "Título 2", "Autor 2", LocalDate.of(2022, 2, 15)));
        testData.put(3L, new Blog(3L, "Título 3", "Autor 3", LocalDate.of(2022, 3, 20)));
        testData.put(4L, new Blog(4L, "Título 4", "Autor 4", LocalDate.of(2022, 4, 25)));
        testData.put(5L, new Blog(5L, "Título 5", "Autor 5", LocalDate.of(2022, 5, 30)));
        testData.put(6L, new Blog(6L, "Título 6", "Autor 6", LocalDate.of(2022, 6, 5)));
        testData.put(7L, new Blog(7L, "Título 7", "Autor 7", LocalDate.of(2022, 7, 10)));
        testData.put(8L, new Blog(8L, "Título 8", "Autor 8", LocalDate.of(2022, 8, 15)));
        testData.put(9L, new Blog(9L, "Título 9", "Autor 9", LocalDate.of(2022, 9, 20)));
        testData.put(10L, new Blog(10L, "Título 10", "Autor 10", LocalDate.of(2022, 10, 25)));
        testData.put(11L, new Blog(11L, "Título 11", "Autor 11", LocalDate.of(2022, 11, 30)));
        testData.put(12L, new Blog(12L, "Título 12", "Autor 12", LocalDate.of(2022, 12, 5)));
        testData.put(13L, new Blog(13L, "Título 13", "Autor 13", LocalDate.of(2023, 1, 10)));
        testData.put(14L, new Blog(14L, "Título 14", "Autor 14", LocalDate.of(2023, 2, 15)));
        testData.put(15L, new Blog(15L, "Título 15", "Autor 15", LocalDate.of(2023, 3, 20)));
        testData.put(16L, new Blog(16L, "Título 16", "Autor 16", LocalDate.of(2023, 4, 25)));
        testData.put(17L, new Blog(17L, "Título 17", "Autor 17", LocalDate.of(2023, 5, 30)));
        testData.put(18L, new Blog(18L, "Título 18", "Autor 18", LocalDate.of(2023, 6, 5)));
        testData.put(19L, new Blog(19L, "Título 19", "Autor 19", LocalDate.of(2023, 7, 10)));
        testData.put(20L, new Blog(20L, "Título 20", "Autor 20", LocalDate.of(2023, 8, 15)));

        BaseDeDatos.getBaseDeDatos().setBlogs(testData);
    }

}
