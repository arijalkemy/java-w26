package perlas.joyeria.dto;

import lombok.Data;

@Data
public class JoyaDto {
    private String nombre;
    private String material;
    private Double peso;
    private String particularidad;
    private Boolean posee_piedra;
}
