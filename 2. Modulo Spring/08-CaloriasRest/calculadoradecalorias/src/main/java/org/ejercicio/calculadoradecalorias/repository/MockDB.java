package org.ejercicio.calculadoradecalorias.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import org.ejercicio.calculadoradecalorias.entity.Ingrediente;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

@Getter
public class MockDB {
    private List<Ingrediente> ingredientes = Collections.emptyList();
    public MockDB() {
        ingredientes = llenarListaIngredientes();
    }

    public List<Ingrediente> llenarListaIngredientes() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:food.json");
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<Ingrediente>> typeRef = new TypeReference<>() {};
        List<Ingrediente> listaIngredientes = Collections.emptyList();
        try{
            listaIngredientes = mapper.readValue(file,typeRef);
        }catch (IOException e) {
            e.printStackTrace();
        }
        return listaIngredientes;
    }
}
