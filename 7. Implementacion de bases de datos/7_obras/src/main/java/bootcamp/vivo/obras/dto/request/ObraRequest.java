package bootcamp.vivo.obras.dto.request;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class ObraRequest {
    
    private String nombre;
    private Integer cantidadPaginas;
    @JsonProperty("fecha_primer_publicacion")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate fechaPrimerPublicacion;
    private AutorRequest autor;
    private EditorialRequest editorial;

}
