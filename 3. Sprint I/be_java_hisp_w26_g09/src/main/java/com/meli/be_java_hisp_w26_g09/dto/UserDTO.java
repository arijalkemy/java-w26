package com.meli.be_java_hisp_w26_g09.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({
        "user_id",
        "user_name",
        "role",
        "followed",
        "followers",
        "followers_count"
})
public class UserDTO {

    @JsonProperty("user_id")
    private Integer userId;
    @JsonProperty("user_name")
    private String userName;
    @JsonIgnore
    private RoleDTO role;
    private List<UserDTO> followed;
    private List<UserDTO> followers;
    @JsonProperty("followers_count")
    private Integer followersCount;
}
