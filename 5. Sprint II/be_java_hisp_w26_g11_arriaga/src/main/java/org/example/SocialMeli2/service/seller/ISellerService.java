package org.example.SocialMeli2.service.seller;

import org.example.SocialMeli2.dto.RequestPostDTO;
import org.example.SocialMeli2.dto.ResponsePostDTO;
import org.example.SocialMeli2.entity.Post;
import org.example.SocialMeli2.entity.Seller;

import java.util.List;

public interface ISellerService {
     public Post addPost(RequestPostDTO postDTO);
     public List<Seller> getSellers();
     ResponsePostDTO getPostsFromFollowingWithTwoWeeksOld(int userId, String order);
}
