package bootcamp.spring.deportistas.dtos;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DeportistaDTO implements Serializable {
    private String nombreCompleto;
    private String nombreDeporte;
}
