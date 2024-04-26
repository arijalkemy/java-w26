package org.example.be_java_hisp_w26_g04.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.be_java_hisp_w26_g04.model.Promotion;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@JsonPropertyOrder({"user_id", "user_name", "posts"})
public class PromotionResponseDTO {
    @JsonProperty("user_id")
    private int userId;
    @JsonProperty("user_name")
    private String userName;
    private List<PostResponseDTO> posts;
}
