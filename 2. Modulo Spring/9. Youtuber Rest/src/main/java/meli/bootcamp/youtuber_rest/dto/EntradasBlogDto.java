package meli.bootcamp.youtuber_rest.dto;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EntradasBlogDto {
  private String titulo;
  private String autor;
  private String fechaPublicacion;
}
