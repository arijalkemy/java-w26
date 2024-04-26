package org.example.be_java_hisp_w26_g04.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Post {
  private int idPost;

  @JsonAlias({"user_id", "userId"})
  private int userId;

  @JsonFormat(pattern = "dd-MM-yyyy")
  private LocalDate date;

  @JsonAlias({"has_promo", "hasPromo"})
  private boolean hasPromo;

  Product product;
  private int category;
  private double price;
  private Double discount;
}
