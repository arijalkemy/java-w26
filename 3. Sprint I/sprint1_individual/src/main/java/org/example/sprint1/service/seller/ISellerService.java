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
     String postProductPromotion(PostDTO requestProductPromoDto);
     SellersProductsCountDto getProductPromotionsCount(int id);
     List<SellerPromoListDto> getProductPromotionsList(int id);
}
