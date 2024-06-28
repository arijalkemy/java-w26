package org.example.be_java_hisp_w26_g07.dto.products;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PostRequestDto {
    @NotNull(message = "El id no puede estar vacío.")
    @Positive(message = "El id debe ser mayor a cero")
    @JsonProperty("user_id")
    private Integer userId;

    @NotNull(message = "La fecha no puede estar vacía.")
    @PastOrPresent(message = "La fecha debe ser anterior o igual a la actual")
    @JsonProperty("date")
    @JsonFormat(pattern = "dd-MM-yyyy")
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate date;

    @NotNull(message = "El producto no puede estár vacío")
    @JsonProperty("product")
    @Valid
    private ProductDto product;

    @Positive(message = "El valor debe ser mayor a cero")
    @NotNull(message = "El campo no puede estar vacío.")
    @JsonProperty("category")
    private Integer category;

    @Positive(message = "El precio debe ser mayor a cero")
    @Max(value = 10000000, message = "El precio máximo por producto es de 10.000.000")
    @NotNull(message = "El campo no puede estar vacío.")
    @JsonProperty("price")
    private Double price;
}
