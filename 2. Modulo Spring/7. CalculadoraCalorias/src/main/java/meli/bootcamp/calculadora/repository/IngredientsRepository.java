package meli.bootcamp.calculadora.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import meli.bootcamp.calculadora.entity.Ingredient;
import meli.bootcamp.calculadora.repository.interfaces.ICrud;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;

@Repository
public class IngredientsRepository implements ICrud<Ingredient> {

    private List<Ingredient> ingredients;

    public IngredientsRepository() {
        populate();
    }


    private void populate() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Resource resource = new ClassPathResource("data/food.json");

            ingredients = objectMapper.readValue(resource.getInputStream(), new TypeReference<>() {
            });
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Ingredient> findAll() {
        return ingredients;
    }
}
