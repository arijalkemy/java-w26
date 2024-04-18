package bootcamp.bendezujonathan.blogs.dto.response;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(Include.NON_NULL)
public class EntradaDeBlogResponse {

    private int id;
    private String titulo;
    private String nombreAutor;
    private String fechaPublicacion;



}
