package org.example.sprint1.service.seller;

import org.example.sprint1.dto.PostDTO;
import org.example.sprint1.dto.RequestPostDTO;
import org.example.sprint1.dto.ResponsePostDTO;
import org.example.sprint1.dto.ResponsePromoDTO;
import org.example.sprint1.entity.Post;
import org.example.sprint1.entity.Seller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ISellerService {
     public Post addPost(RequestPostDTO postDTO);
     public List<Seller> getSellers();
     ResponsePostDTO getPostsFromFollowingWithTwoWeeksOld(int userId, Optional<String> order);
     ResponsePromoDTO getPostsWithPromo(int userId);
}
