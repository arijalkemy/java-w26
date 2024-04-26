package org.example.be_java_hisp_w26_g04.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({"user_id", "user_name", "posts"})
public class PromoListDTO {
  @JsonProperty("user_id")
  private int userId;

  @JsonProperty("user_name")
  private String username;

  List<PostResponseDTO> posts;
}
