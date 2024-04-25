package com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostsByFollowedUsersDTO {
    @JsonProperty("user_id")
    private int userId;
    @JsonProperty("posts")
    private List<PostDTO> posts;
}
