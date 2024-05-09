package org.example.be_java_hisp_w26_g07.dto.users;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CountFollowersResponseDto implements Serializable {
    @JsonProperty("user_id")
    private Integer id;
    @Size(min = 15)
    @JsonProperty("user_name")
    private String name;
    @JsonProperty("followers_count")
    private Integer followersCount;
}
