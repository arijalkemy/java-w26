package spring.blog.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

@Getter
@Setter
@AllArgsConstructor
public class EntradaBlog {
    private int id;
    private String titulo;
    private String nombreAutor;
    private LocalDate fechaPublicacion;


}
