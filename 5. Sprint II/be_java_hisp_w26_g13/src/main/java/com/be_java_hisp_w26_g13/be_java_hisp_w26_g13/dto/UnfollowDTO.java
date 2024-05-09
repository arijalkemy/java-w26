package com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UnfollowDTO {
    @JsonProperty("user_id")
    private int userId;

    @JsonProperty("user_id_to_unfollow")
    private int userIdToUnfollow;
}
