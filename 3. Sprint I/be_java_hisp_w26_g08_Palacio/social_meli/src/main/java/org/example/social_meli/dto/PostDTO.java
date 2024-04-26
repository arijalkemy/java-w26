package org.example.social_meli.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {
    private Integer post_id;
    private Integer user_id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;
    private ProductDTO product;
    private Integer category;
    private Double price;
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private Boolean has_promo;
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private Double discount;

    public PostDTO(Integer post_id, Integer user_id, LocalDate date, ProductDTO product, Integer category, Double price) {
        this.post_id = post_id;
        this.user_id = user_id;
        this.date = date;
        this.product = product;
        this.category = category;
        this.price = price;
        this.has_promo = null;
        this.discount = null;
    }
}
