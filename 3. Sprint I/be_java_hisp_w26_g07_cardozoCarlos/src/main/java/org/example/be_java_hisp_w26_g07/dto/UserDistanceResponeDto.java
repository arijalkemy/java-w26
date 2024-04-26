package org.example.be_java_hisp_w26_g07.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.be_java_hisp_w26_g07.entity.Post;

import java.util.List;

@Data
@AllArgsConstructor
public class UserDistanceResponeDto {
    @JsonProperty("user_id")
    private Integer id;
    @JsonProperty("user_name")
    private String name;
    @JsonProperty("distance")
    private String distance;
    @JsonProperty("posts")
    private List<Post> posts;
}
