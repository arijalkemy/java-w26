package com.be_java_hisp_w26_g13.be_java_hisp_w26_g13_palomo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ResponseFollowersCountDTO {
    @JsonProperty("user_id")
    private int userId;

    @JsonProperty("user_name")
    private String userName;

    @JsonProperty("followers_count")
    private int followersCount;
}
