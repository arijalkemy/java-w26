package meli.bootcamp.youtuber_rest.entity;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // getter, setter, toString, hashCode
@NoArgsConstructor
@AllArgsConstructor
public class EntradaBlog {
  private Long id;
  private String titulo;
  private String autor;
  private LocalDateTime fechaPublicacion;

}
