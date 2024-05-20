package org.example.miniseriemanual.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MiniSerieDto {
    @NotNull
    private String name;
    @Positive
    private Double rating;
    @Positive
    @JsonProperty("amount_of_awards")
    private Integer amount;
}
