package org.example.be_java_hisp_w26_g04.service.seller;

import org.example.be_java_hisp_w26_g04.dto.FollowersCountDTO;
import org.example.be_java_hisp_w26_g04.dto.PostRequestDTO;
import org.example.be_java_hisp_w26_g04.dto.SellerFollowersDTO;
import org.example.be_java_hisp_w26_g04.dto.PostResponseDTO;

import java.util.List;

public interface ISellerService {
  SellerFollowersDTO getFollowers(int userId);

  SellerFollowersDTO sortGetFollowers(int userId, String order);

  FollowersCountDTO findFollowers(int sellerId);

  void createNewPost(PostRequestDTO post);

  List<PostResponseDTO> sortGetPostFromFollower(int userId, String order);
}
