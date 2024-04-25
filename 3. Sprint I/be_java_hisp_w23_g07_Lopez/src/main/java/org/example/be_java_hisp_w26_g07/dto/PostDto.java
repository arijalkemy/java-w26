package org.example.be_java_hisp_w26_g07.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.be_java_hisp_w26_g07.entity.Product;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PostDto {
    @JsonProperty("user_id")
    private Integer userId;
    @JsonProperty("post_id")
    private Integer id;
    @JsonProperty("date")
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;
    @JsonProperty("product")
    private ProductDto product;
    @JsonProperty("category")
    private String category;
    @JsonProperty("price")
    private Double price;
}
