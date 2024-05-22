package bootcamp.vivo.obras.dto.response;

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
public class ObraResponse {
    
    private String id;
    private String nombre;
    private Integer cantidadPaginas;
    @JsonProperty("fecha_primer_publicacion")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate fechaPrimerPublicacion;
    private AutoResponse autor;
    private EditorialResponse editorial;
}
