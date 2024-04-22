package meli.bootcamp.star_wars.domain;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EntradaBlog {
  Long id;
  String titulo;
  String autor;
  LocalDateTime fechaPublicacion;
}
