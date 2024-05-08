package org.example.social_meli.dto;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserCountResponseDTO {
    @NotNull(message="El  id no puede estar vacío")
    @Min(value=0, message="El id debe ser mayor a cero")
    private Integer user_id;
    private String user_name;
    private Integer followers_count;

}
