package com.javabootcamp.socialmeli.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.javabootcamp.socialmeli.model.Post;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PromoBySellerDto {
    @JsonProperty("user_id")
    private int userId;
    @JsonProperty("user_name")
    private String userName;

    @JsonProperty("posts")
    private List<Post> posts;


}
