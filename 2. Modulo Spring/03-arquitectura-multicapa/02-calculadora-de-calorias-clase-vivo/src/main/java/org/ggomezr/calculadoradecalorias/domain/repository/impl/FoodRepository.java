package org.ggomezr.calculadoradecalorias.domain.repository.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.ggomezr.calculadoradecalorias.domain.entity.Food;
import org.ggomezr.calculadoradecalorias.domain.repository.interfaces.IFoodRepository;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

@Repository
public class FoodRepository implements IFoodRepository {

    private final String FILE_PATH = "food.json";

    public List<Food> getAllIngredients() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        InputStream inputStream = new ClassPathResource(FILE_PATH).getInputStream();
        Food[] foods = objectMapper.readValue(inputStream, Food[].class);
        return Arrays.asList(foods);
    }
}
