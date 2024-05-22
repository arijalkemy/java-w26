package bootcamp.bendezujonathan.elastichsearch.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class CiudadRequest {
    private Long ciudadId;
    private String ciudadNombre;
}
