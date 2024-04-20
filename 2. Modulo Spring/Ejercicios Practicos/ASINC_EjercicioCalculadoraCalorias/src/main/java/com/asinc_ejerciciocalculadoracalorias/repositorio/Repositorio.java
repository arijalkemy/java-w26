package com.asinc_ejerciciocalculadoracalorias.repositorio;

import com.asinc_ejerciciocalculadoracalorias.entidad.Ingrediente;
import com.asinc_ejerciciocalculadoracalorias.entidad.Plato;
import com.google.gson.Gson;
import org.springframework.stereotype.Repository;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Repository
public class Repositorio {

    public static List<Ingrediente> listaIngredientes;

    public static List<Plato> listaPlatos = new ArrayList<>();

    static {
        try (Reader reader = new FileReader("src/main/java/com/asinc_ejerciciocalculadoracalorias/repositorio/ingredientes.json")) {
            Gson gson = new Gson();

            // Convertir el JSON en una lista de objetos Personaje
            Ingrediente[] personajesArray = gson.fromJson(reader, Ingrediente[].class);
            listaIngredientes = Arrays.asList(personajesArray);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    static {
        listaPlatos.add(new Plato("Menu del dia", 0.8, List.of(listaIngredientes.get(21),
                                                                  listaIngredientes.get(4),
                                                                  listaIngredientes.get(13),
                                                                  listaIngredientes.get(27))));

        listaPlatos.add(new Plato("Especial de la casa", 1.2, List.of(listaIngredientes.get(0),
                                                                        listaIngredientes.get(28),
                                                                        listaIngredientes.get(7),
                                                                        listaIngredientes.get(10))));
    }

}
