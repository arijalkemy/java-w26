package bootcamp.bendezujonathan.perlas.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class JewerlyRequest {
    private String nombre;
    private String material;
    private String particularidad;
    private Double peso;
    private boolean ventaONo;
    @JsonProperty("posee_piedra")
    private boolean poseePiedra;
}

