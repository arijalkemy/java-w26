package spring.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class BlogDto {
     private int id;
     private String titulo;
     private String nombreAutor;
     private LocalDate fecha;
}
