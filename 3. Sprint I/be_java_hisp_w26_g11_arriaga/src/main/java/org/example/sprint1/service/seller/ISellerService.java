package org.example.sprint1.service.seller;

import org.example.sprint1.dto.RequestPostDTO;
import org.example.sprint1.dto.ResponsePostDTO;
import org.example.sprint1.dto.ResponsePromoCountDTO;
import org.example.sprint1.entity.Post;
import org.example.sprint1.entity.Seller;

import java.util.List;
import java.util.Optional;

public interface ISellerService {
     public Post addPost(RequestPostDTO postDTO);
     public List<Seller> getSellers();
     ResponsePostDTO getPostsFromFollowingWithTwoWeeksOld(int userId, String order);
     ResponsePromoCountDTO getPromoPostCount(int userId);
}
