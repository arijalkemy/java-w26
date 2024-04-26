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
@JsonPropertyOrder({"user_id", "user_name", "followers"})
public class SellerFollowersDTO {
  @JsonProperty("user_id")
  int id;

  @JsonProperty("user_name")
  String username;

  List<UserDTO> followers;
}
