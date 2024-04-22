package meli.bootcamp.calories_calculator.repository.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.List;
import meli.bootcamp.calories_calculator.domain.Food;
import meli.bootcamp.calories_calculator.repository.IFoodRepository;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Repository;

@Repository
public class FoodRepositortImplJson implements IFoodRepository {
  List<Food> foods;

  FoodRepositortImplJson(ResourceLoader resourceLoader) throws IOException {
    ObjectMapper objectMapper = new ObjectMapper();
    Resource resource = resourceLoader.getResource("classpath:static/food.json");
    foods = objectMapper.readValue(resource.getInputStream(), new TypeReference<>() {
    });
  }

  @Override
  public List<Food> getAll() {
    return foods;
  }

  @Override
  public Food findByName(String name) {
    return foods.stream().filter(f -> f.getName().equalsIgnoreCase(name)).findFirst().orElseThrow();
  }

}
