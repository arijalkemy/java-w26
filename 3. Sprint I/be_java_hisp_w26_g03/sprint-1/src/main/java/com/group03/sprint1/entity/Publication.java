package com.group03.sprint1.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Publication {
    @JsonProperty("post_id")
    private int postId;
    @JsonProperty("user_id")
    private Integer userId;
    private LocalDate date;
    private Product product;
    private Integer category;
    private Double price;
}
