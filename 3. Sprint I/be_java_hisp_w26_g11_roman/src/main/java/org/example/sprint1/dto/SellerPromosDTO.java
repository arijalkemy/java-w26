package org.example.sprint1.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.sprint1.entity.Post;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SellerPromosDTO {
    @JsonProperty("seller_id")
    private int sellerId;

    @JsonProperty("seller_name")
    private String sellerName;

    @JsonProperty("promo_products_count")
    private Integer promoProductsCount;

    @JsonCreator
    public SellerPromosDTO(@JsonProperty("seller_id") Integer sellerId,
                           @JsonProperty("seller_name") String sellerName,
                           @JsonProperty("posts") List<Post> posts,
                           @JsonProperty("followers") List<Integer> followers) {
        this.sellerId = sellerId;
        this.sellerName = sellerName;
        this.promoProductsCount = (int) posts.stream().filter(Post::isHasPromo).count();
    }


}
