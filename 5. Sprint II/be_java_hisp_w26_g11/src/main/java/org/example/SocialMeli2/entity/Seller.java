package org.example.SocialMeli2.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({"sellerId", "sellerName", "posts", "followers"})
public class Seller {
    @JsonProperty("seller_id")
    private int sellerId;
    @JsonProperty("seller_name")
    private String sellerName;
    private List<Post> posts;
    private List<Integer> followers;

    public void addPost(Post post){
        posts.add(post);
    }

    public boolean productIdExists(int id){
        return posts.stream().anyMatch(post -> post.getProduct().getProductId() == id);
    }

    public void addFollowers(int id){
        followers.add(id);
    }
}
