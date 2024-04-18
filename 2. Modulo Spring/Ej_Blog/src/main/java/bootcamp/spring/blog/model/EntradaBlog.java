package bootcamp.spring.blog.model;

import java.time.LocalDate;

import lombok.Data;

@Data
public class EntradaBlog{
	Integer id;
    String titulo;
    String nombreAutor;
    LocalDate fechaPublicacion;
}
