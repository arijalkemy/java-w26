package org.example.be_java_hisp_w26_g07.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class FollowedResponseDto {
    @JsonProperty("user_id")
    private int id;
    @JsonProperty("user_name")
    private String name;
    @JsonProperty("followed")
    private List<UserInfoFollowsDto> followed;
}
