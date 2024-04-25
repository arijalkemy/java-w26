package org.example.be_java_hisp_w26_g07.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor()
@Data
public class FollowersResponseDto {
    @JsonProperty(value = "user_id", index = 0)
    private int id;
    @JsonProperty(value = "user_name", index = 1)
    private String name;
    @JsonProperty(index = 2)
    private List<UserInfoFollowsDto> followers = new ArrayList<>();
}
