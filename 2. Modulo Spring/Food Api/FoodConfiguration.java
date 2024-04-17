package org.example.calories;

import org.example.calories.entities.Food;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class FoodConfiguration {
    @Bean
    public List<Food> foodList() {
        return List.of(
                new Food("Pizza", List.of("Queso cheddar", "Tomates")),
                new Food("Sandwich", List.of("Pan de trigo blanco", "Queso de oveja", "Lechuga", "Jamón"))
        );
    }
}
