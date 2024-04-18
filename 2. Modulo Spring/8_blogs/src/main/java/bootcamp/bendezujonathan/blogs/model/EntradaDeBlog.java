package bootcamp.bendezujonathan.blogs.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntradaDeBlog {
    
    private int id;
    private String titulo;
    private String nombreAutor;
    private String fechaPublicacion;

}
