package org.example.sprint1.service.seller;

import org.example.sprint1.dto.CountPromoPostsDTO;
import org.example.sprint1.dto.RequestPostDTO;
import org.example.sprint1.dto.RequestPromoPostDTO;
import org.example.sprint1.dto.ResponsePostDTO;
import org.example.sprint1.entity.Post;
import org.example.sprint1.entity.Seller;

import java.util.List;
import java.util.Optional;

public interface ISellerService {
     public Post addPost(RequestPostDTO postDTO);
     public Post addPost(RequestPromoPostDTO postDTO);
     public List<Seller> getSellers();
     ResponsePostDTO getPostsFromFollowingWithTwoWeeksOld(int userId, String order);
     CountPromoPostsDTO countPromoPosts(int userId);
}
