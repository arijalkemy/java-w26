package org.example.SocialMeli2.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.SocialMeli2.entity.Post;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BasicSellerDTO implements Serializable {
    @JsonProperty("user_id")
    @JsonAlias("seller_id")
    private int sellerId;

    @JsonProperty("user_name")
    @JsonAlias("seller_name")
    private String sellerName;

    @JsonIgnore
    private List<Post> posts;

    @JsonIgnore
    private List<Integer> followers;

}
