package com.example.sprint1.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CountFollowersUserDto {
    @JsonProperty("user_id")
    public Integer userId;
    @JsonProperty("user_name")
    public String userName;
    @JsonProperty("followers_count")
    public Integer count;
}
