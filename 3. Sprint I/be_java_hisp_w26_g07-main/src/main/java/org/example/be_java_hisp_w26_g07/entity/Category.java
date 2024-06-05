package org.example.be_java_hisp_w26_g07.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    @JsonProperty("category_id")
    private String id;
    @JsonProperty("description")
    private String description;
}
