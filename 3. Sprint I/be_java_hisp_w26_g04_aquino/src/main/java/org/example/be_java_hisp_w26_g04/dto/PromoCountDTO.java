package org.example.be_java_hisp_w26_g04.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PromoCountDTO {
  @JsonProperty("user_id")
  int id;

  @JsonProperty("user_name")
  String username;

  @JsonProperty("promo_posts_count")
  int promoPostsCount;
}
