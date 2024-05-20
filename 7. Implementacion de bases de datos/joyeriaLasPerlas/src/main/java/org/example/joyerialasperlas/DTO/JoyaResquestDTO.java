package org.example.joyerialasperlas.DTO;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JoyaResquestDTO {
    @NotBlank(message = "El nombre no puede estar vacío")
    @NotNull(message = "El nombre no puede ser nulo")
    private  String nombre;

    @NotBlank(message = "El material no puede estar vacío")
    @NotBlank(message = "El material no puede ser nulo")
    private  String material;

    @Min(value = 0, message = "El peso no puede ser negativo")
    @NotNull(message = "El peso no puede ser nulo")
    private  float peso;

    private  String particularidad;
    @JsonProperty("posee_piedra")

    @NotNull(message = "El peso no puede ser nulo")
    private  boolean poseePiedra;
    private  boolean ventaONo;
}
