package com.javabootcamp.socialmeli.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.javabootcamp.socialmeli.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    @JsonProperty("user_id")
    private Integer id;
    @JsonProperty("user_name")
    private String username;
}
