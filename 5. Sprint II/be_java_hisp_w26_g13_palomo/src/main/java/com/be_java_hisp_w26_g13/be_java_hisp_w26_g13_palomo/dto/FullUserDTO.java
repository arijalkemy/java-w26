package com.be_java_hisp_w26_g13.be_java_hisp_w26_g13_palomo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FullUserDTO {
    @JsonProperty("user_id")
    private int userId;
    @JsonProperty("user_name")
    private String userName;
    @JsonProperty("followers")
    private List<UserDTO> followers;
    @JsonProperty("followed")
    private List<UserDTO> followed;
    private List<PostDTO> post;
}
