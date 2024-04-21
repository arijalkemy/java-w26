package org.example.calculadora_calorias.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.calculadora_calorias.dto.IngredientDTO;
import org.example.calculadora_calorias.model.Ingredient;
import org.example.calculadora_calorias.model.Plate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class PlateRepository implements IPlateRepository {


    IIngredientRepository ingredientRepository= new IngredientRepository();


    private List<Plate> plates=new ArrayList<>();



    public PlateRepository() {
        ObjectMapper mapper= new ObjectMapper();

        this.plates = Arrays.asList(
                new Plate("Arroz con pollo", Arrays.asList(
                        new IngredientDTO(ingredientRepository.findByName("Pollo"), 200),
                        new IngredientDTO(ingredientRepository.findByName("Arroz blanco"),420),
                        new IngredientDTO(ingredientRepository.findByName("Pimiento"),10),
                        new IngredientDTO(ingredientRepository.findByName("Zanahoria"),10)
                )),
                new Plate("Pasta con pollo", Arrays.asList(
                        new IngredientDTO(ingredientRepository.findByName("Pollo"), 200),
                        new IngredientDTO(ingredientRepository.findByName("Pasta al huevo"),420),
                        new IngredientDTO(ingredientRepository.findByName("Nata o crema de leche"),10),
                        new IngredientDTO(ingredientRepository.findByName("Bacon (Panceta ahumada)"),100)
                ))
        );


    }
    @Override
    public List<Plate> findAll() {
        return this.plates;
    }

    @Override
    public Plate findByName(String  name) {
        return this.plates.stream().filter(p -> p.getName().equals(name)).findFirst().orElse(new Plate());
    }


}
