package org.example.be_java_hisp_w26_g04.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    @JsonProperty("user_id")
    @JsonAlias("userId")
    int id;

    @JsonProperty("user_name")
    @JsonAlias("userName")
    String userName;
}
