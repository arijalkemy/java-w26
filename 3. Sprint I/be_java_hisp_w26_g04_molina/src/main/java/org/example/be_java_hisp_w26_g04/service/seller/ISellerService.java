package org.example.be_java_hisp_w26_g04.service.seller;

import org.example.be_java_hisp_w26_g04.dto.*;

import java.util.List;

public interface ISellerService {
  SellerFollowersDTO getFollowers(int userId);

  SellerFollowersDTO sortGetFollowers(int userId, String order);

  FollowersCountDTO findFollowers(int sellerId);

  void createNewPost(PostRequestDTO post);

  List<PostResponseDTO> sortGetPostFromFollower(int userId, String order);

  PromoCountResponseDTO getPromoCount(int sellerId);
}
