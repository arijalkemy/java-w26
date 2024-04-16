package meli.bootcamp.covid_19.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SintomaDto {
  private String nombre;
  private String gravedad;
}
