package meli.bootcamp.calories_calculator.dto;

import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DishDto {
  List<String> ingredientsName;
}
