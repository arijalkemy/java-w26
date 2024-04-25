package org.example.be_java_hisp_w26_g07.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.bind.DefaultValue;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @JsonProperty("product_id")
    private Integer id;
    @JsonProperty("product_name")
    private String name;
    @JsonProperty("type")
    private String type;
    @JsonProperty("brand")
    private String brand;
    @JsonProperty("color")
    private String color;
    @JsonProperty("notes")
    private String notes;
    @JsonIgnore
    private Boolean hasPromo;
    @JsonIgnore
    private Double discount;
}
