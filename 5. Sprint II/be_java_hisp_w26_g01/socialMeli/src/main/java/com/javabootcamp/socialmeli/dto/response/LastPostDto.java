package com.javabootcamp.socialmeli.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.javabootcamp.socialmeli.dto.request.PostDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LastPostDto {
    @JsonProperty("user_id")
    private long userId;
    private List<PostDto> posts;
}
