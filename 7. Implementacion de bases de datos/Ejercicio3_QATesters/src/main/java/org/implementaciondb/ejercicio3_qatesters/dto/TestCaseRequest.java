package org.implementaciondb.ejercicio3_qatesters.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TestCaseRequest {

    @NotNull(message = "La descripción no puede estar vacía")
    @Size(max = 100, message = "La descripción debe tener como máximo 100 caracteres")
    @JsonProperty("description")
    private String description;

    @NotNull(message = "El campo 'tested' no puede ser nulo")
    @JsonProperty("tested")
    private Boolean tested;

    @NotNull(message = "El campo 'passed' no puede ser nulo")
    @JsonProperty("passed")
    private Boolean passed;

    @PositiveOrZero(message = "El número de intentos debe ser un valor positivo o cero")
    @JsonProperty("number_of_tries")
    private Integer numberOfTries;

    @JsonProperty("last_update")
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @PastOrPresent(message = "La fecha de actualización debe ser una fecha pasada o presente")
    private LocalDate lastUpdate;

}
