package org.example.sprint1.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RequestPostDTO {

    @JsonProperty("user_id")
    @NotNull
    @Positive
    private int userId;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @NotNull
    private LocalDate date;

    @NotNull
    private ProductDTO product;

    @Positive
    @NotNull
    private int category;

    @Positive
    @NotNull
    private double price;
}
