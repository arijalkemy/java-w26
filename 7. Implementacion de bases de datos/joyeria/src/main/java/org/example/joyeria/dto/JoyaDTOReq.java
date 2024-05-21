package org.example.joyeria.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class JoyaDTOReq {
    private String nombre;
    private String material;
    private Double peso;
    private String particularidad;
    @JsonAlias("posee_piedra")
    private Boolean poseePiedra;
}
