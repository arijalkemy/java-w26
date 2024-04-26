package org.example.sprint1.service.seller;

import org.example.sprint1.dto.*;
import org.example.sprint1.entity.Post;
import org.example.sprint1.entity.Seller;

import java.util.List;
import java.util.Optional;

public interface ISellerService {
     public Post addPost(RequestPostDTO postDTO);
     public List<Seller> getSellers();
     ResponsePostDTO getPostsFromFollowingWithTwoWeeksOld(int userId, Optional<String> order);
     public Post addProductPromo(RequestPostPromoDTO promoDTO);
     ResponseCountPromoDTO getCountProductsPromo(int userId);
     public List<Post> getHalfPriceProductsPromo(int userId);
}
