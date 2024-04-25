package org.example.sprint1.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ResponsePostDTO {
    @JsonProperty("user_id")
    private int userId;
    @JsonSerialize(contentAs = PostDTO.class)
    @JsonDeserialize(contentAs = PostDTO.class)
    private List<PostDTO> posts;
}
