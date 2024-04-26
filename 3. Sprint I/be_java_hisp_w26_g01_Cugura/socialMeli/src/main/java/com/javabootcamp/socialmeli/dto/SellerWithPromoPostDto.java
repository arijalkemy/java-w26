package com.javabootcamp.socialmeli.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SellerWithPromoPostDto {

    @JsonProperty("user_id")
    private Integer userId;
    @JsonProperty("user_name")
    private String username;
    private List<PromoPostDto> posts;
    
}