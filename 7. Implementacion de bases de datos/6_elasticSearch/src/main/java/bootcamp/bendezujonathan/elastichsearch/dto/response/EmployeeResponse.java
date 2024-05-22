package bootcamp.bendezujonathan.elastichsearch.dto.response;


import bootcamp.bendezujonathan.elastichsearch.model.Ciudad;
import bootcamp.bendezujonathan.elastichsearch.model.Provincia;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeResponse {
    
    
    private String id;
    private String nombre;
    private int edad;
    private Ciudad ciudad;
    private Provincia provincia;

}
