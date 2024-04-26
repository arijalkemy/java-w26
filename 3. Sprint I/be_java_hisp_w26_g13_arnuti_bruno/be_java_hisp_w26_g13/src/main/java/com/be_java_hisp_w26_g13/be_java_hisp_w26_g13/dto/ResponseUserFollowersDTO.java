package com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseUserFollowersDTO implements Serializable {
    @JsonProperty("user_id")
    private int userId;

    @JsonProperty("user_name")
    private String userName;

    @JsonProperty("followers")
    private List<UserDTO> followers;
}
