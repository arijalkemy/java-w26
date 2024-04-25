package org.example.sprint1.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.example.sprint1.entity.Post;

import java.io.Serializable;
import java.util.List;

@Data
public class BasicSellerDTO implements Serializable {
    @JsonProperty("seller_id")
    private int sellerId;
    @JsonProperty("seller_name")
    private String sellerName;
    @JsonIgnore
    private List<Post> posts;
    @JsonIgnore
    private List<Integer> followers;

}
