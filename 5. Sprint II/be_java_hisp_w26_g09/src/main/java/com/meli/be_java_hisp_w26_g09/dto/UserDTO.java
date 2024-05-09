package com.meli.be_java_hisp_w26_g09.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
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
    @Positive(message = "ID must be greater than zero")
    @NotNull(message = "ID is required, can't be null")
    private Integer userId;
    @JsonProperty("user_name")
    @Size(max = 15, min = 1, message = "Username max length must be 15 characters")
    private String userName;
    @JsonIgnore
    private RoleDTO role;

    @Valid
    private List<UserDTO> followed;

    @Valid
    private List<UserDTO> followers;
    @JsonProperty("followers_count")
    private Integer followersCount;
}
