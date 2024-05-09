package org.example.be_java_hisp_w26_g07.dto.users;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor()
@AllArgsConstructor
public class FollowersResponseDto {
    @JsonProperty(value = "user_id", index = 0)
    private int id;
    @Size(min = 15)
    @JsonProperty(value = "user_name", index = 1)
    private String name;
    @JsonProperty(index = 2)
    private List<UserInfoFollowsDto> followers = new ArrayList<>();
}
