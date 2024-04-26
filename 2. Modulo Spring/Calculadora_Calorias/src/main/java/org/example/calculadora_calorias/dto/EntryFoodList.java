package org.example.calculadora_calorias.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntryFoodList {
    @JsonProperty("food_names")
    List<String> foodNames;
}
