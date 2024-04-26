package org.example.be_java_hisp_w26_g04.service.seller;

import java.util.List;
import org.example.be_java_hisp_w26_g04.dto.FollowersCountDTO;
import org.example.be_java_hisp_w26_g04.dto.PostRequestDTO;
import org.example.be_java_hisp_w26_g04.dto.PostResponseDTO;
import org.example.be_java_hisp_w26_g04.dto.PromoCountDTO;
import org.example.be_java_hisp_w26_g04.dto.PromoListDTO;
import org.example.be_java_hisp_w26_g04.dto.SellerFollowersDTO;

public interface ISellerService {
  SellerFollowersDTO getFollowers(int userId);

  SellerFollowersDTO sortGetFollowers(int userId, String order);

  FollowersCountDTO findFollowers(int sellerId);

  PostResponseDTO createNewPost(PostRequestDTO post);

  List<PostResponseDTO> sortGetPostFromFollower(int userId, String order);

  PromoCountDTO getPromoPostCount(int userId);

  PromoListDTO getPromoPostList(int userId);

  List<PostResponseDTO> getPosts(String priceOrder, String productName, String type);
}
