package bootcamp.bendezujonathan.elastichsearch.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRequest {
    private String nombre;
    private int edad;
    private CiudadRequest ciudad;
    private ProvinciaRequest provincia;

}
