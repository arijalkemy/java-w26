package org.example.calorias.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.calorias.entity.Ingrediente;
import org.example.calorias.entity.Plato;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class PlatosRepository {

    List<Ingrediente> ingredientes = new ArrayList<>();
    private List<Plato> platos = new ArrayList<>();


    public PlatosRepository() {
        this.ingredientes = this.populateIngredientes();
        this.platos = this.populate();
    }

    private List<Ingrediente> populateIngredientes() {
        List<Ingrediente> ingredientes = new ArrayList<>();
        String route = "classpath:food.json";
        ObjectMapper objectMapper = new ObjectMapper();
        File file;
        try {
            file = ResourceUtils.getFile(route);
            ingredientes = List.of(objectMapper.readValue(file, Ingrediente[].class));
        } catch (IOException e) {
            System.out.println("Error al abrir el archivo: " + e.getMessage());
        }
        return ingredientes;
    }

    private List<Plato> populate(){
        List<Plato> platos = new ArrayList<>();

        if(ingredientes != null) {
            platos = Arrays.asList(
                    new Plato("Ensalada César", Arrays.asList(ingredientes.get(0), ingredientes.get(3))),
                    new Plato("Ensalada de Espárragos", Arrays.asList(ingredientes.get(1), ingredientes.get(2))),
                    new Plato("Sopa de Verduras", Arrays.asList(ingredientes.get(4), ingredientes.get(5), ingredientes.get(6), ingredientes.get(7))),
                    new Plato("Tortilla de Espinacas", Arrays.asList(ingredientes.get(2), ingredientes.get(8))),
                    new Plato("Risotto de Champiñones", Arrays.asList(ingredientes.get(9), ingredientes.get(10))),
                    new Plato("Paella Vegetariana", Arrays.asList(ingredientes.get(11), ingredientes.get(12), ingredientes.get(13))),
                    new Plato("Ensalada de Frutas", Arrays.asList(ingredientes.get(14), ingredientes.get(15), ingredientes.get(16), ingredientes.get(17))),
                    new Plato("Guacamole", Arrays.asList(ingredientes.get(18), ingredientes.get(19), ingredientes.get(20))),
                    new Plato("Ratatouille", Arrays.asList(ingredientes.get(21), ingredientes.get(22), ingredientes.get(23), ingredientes.get(24))),
                    new Plato("Hummus", Arrays.asList(ingredientes.get(25), ingredientes.get(3), ingredientes.get(26))),
                    new Plato("Ensalada Caprese", Arrays.asList(ingredientes.get(27), ingredientes.get(28), ingredientes.get(29))),
                    new Plato("Stir-fry de Vegetales", Arrays.asList(ingredientes.get(2), ingredientes.get(30), ingredientes.get(31), ingredientes.get(32))),
                    new Plato("Pasta Primavera", Arrays.asList(ingredientes.get(1), ingredientes.get(10), ingredientes.get(9), ingredientes.get(8))),
                    new Plato("Gazpacho", Arrays.asList(ingredientes.get(14), ingredientes.get(33), ingredientes.get(34), ingredientes.get(7))),
                    new Plato("Ensalada Griega", Arrays.asList(ingredientes.get(33), ingredientes.get(27), ingredientes.get(0), ingredientes.get(35)))
            );
        }
        return platos;
    }

    public List<Plato> obtenerPlatos() {
        return platos;
    }


}
