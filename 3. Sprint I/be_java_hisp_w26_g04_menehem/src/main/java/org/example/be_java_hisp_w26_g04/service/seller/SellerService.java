package org.example.be_java_hisp_w26_g04.service.seller;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.example.be_java_hisp_w26_g04.dto.*;
import org.example.be_java_hisp_w26_g04.exceptions.BadRequestException;
import org.example.be_java_hisp_w26_g04.exceptions.NotFoundException;
import org.example.be_java_hisp_w26_g04.model.Buyer;
import org.example.be_java_hisp_w26_g04.model.Post;
import org.example.be_java_hisp_w26_g04.model.Seller;
import org.example.be_java_hisp_w26_g04.repository.buyer.IBuyersRepository;
import org.example.be_java_hisp_w26_g04.repository.seller.ISellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SellerService implements ISellerService {

    @Autowired
    ISellerRepository sellerRepository;

    @Autowired
    IBuyersRepository buyerRepository;

    private final ObjectMapper objectMapper;

    @Override
    public FollowersCountDTO findFollowers(int sellerId) {
        Seller seller = findSellerById(sellerId);
        int followerCount = seller.getFollowers().size();

        FollowersCountDTO followersCountDTO = objectMapper.convertValue(seller, FollowersCountDTO.class);
        followersCountDTO.setFollowersCount(followerCount);

        return followersCountDTO;
    }

    @Override
    public SellerFollowersDTO getFollowers(int sellerId) {
        Seller seller = findSellerById(sellerId);

        return converSellerToSellerFollowersDto(seller);
    }

    @Override
    public SellerFollowersDTO sortGetFollowers(int userId, String order) {
        SellerFollowersDTO sellerFollowersDTO = getFollowers(userId);
        List<UserDTO> res;

        if (order.equals("name_asc")) {
            res = sellerFollowersDTO.getFollowers().stream()
                    .sorted(Comparator.comparing(UserDTO::getUsername)).toList();
        } else if (order.equals("name_desc")) {
            res = sellerFollowersDTO.getFollowers().stream()
                    .sorted(Comparator.comparing(UserDTO::getUsername).reversed())
                    .toList();
        } else {
            throw new BadRequestException();
        }

        sellerFollowersDTO.setFollowers(res);
        return sellerFollowersDTO;
    }

    private SellerFollowersDTO converSellerToSellerFollowersDto(Seller seller) {
        List<UserDTO> followers = seller.getFollowers().stream()
                .map(this::findBuyerById)
                .map(follower -> new UserDTO(follower.getUserId(), follower.getUserName()))
                .toList();

        return new SellerFollowersDTO(seller.getUserId(), seller.getUserName(), followers);
    }


    private List<PostResponseDTO> getPostsFromFollower(int userId) {
        Buyer buyer = findBuyerById(userId);
        List<Post> posts = sellerRepository.getPosts();
        List<Post> filteredPost = filterPostsTwoWeeksAgo(posts);
        List<PostResponseDTO> postsDTO = new ArrayList<>();
        buyer.getSellersFollowing().forEach(
                id -> filteredPost.stream().filter(post -> post.getUserId() == id)
                        .forEach(
                                x -> postsDTO.add(objectMapper.convertValue(x, PostResponseDTO.class))
                        )
        );
        return postsDTO;
    }

    private List<Post> filterPostsTwoWeeksAgo(List<Post> posts) {
        LocalDate dateTwoWeeksAgo = LocalDate.now().minusWeeks(2);
        return posts.stream().filter(p -> p.getDate().isAfter(dateTwoWeeksAgo))
                .sorted(Comparator.comparing(Post::getDate)).toList();
    }


    @Override
    public List<PostResponseDTO> sortGetPostFromFollower(int userId, String order) {
        List<PostResponseDTO> ListPostDTO = getPostsFromFollower(userId);
        if (order != null) {
            if (order.contains("date_asc")) {
                ListPostDTO.sort(Comparator.comparing(PostResponseDTO::getDate));
            } else if (order.contains("date_desc")) {
                ListPostDTO.sort(Comparator.comparing(PostResponseDTO::getDate).reversed());
            } else {
                throw new BadRequestException();
            }
        }
        return ListPostDTO;
    }

    @Override
    public void createNewPost(PostRequestDTO postDTO) {
        Seller seller = findSellerById(postDTO.getUserId());

        Post post = objectMapper.convertValue(postDTO, Post.class);

        sellerRepository.save(post);
    }


    @Override
    public PromosCountDTO findPromos(int sellerId) {
        Seller seller = findSellerById(sellerId);
        int promosCount = seller.getListPost().stream().filter(Post::isHasPromo).toList().size();

        PromosCountDTO promosCountDTO = objectMapper.convertValue(seller, PromosCountDTO.class);
        promosCountDTO.setFollowersCount(promosCount);

        return promosCountDTO;
    }

    @Override
    public List<PostResponseDTO> findAllPosts(Integer sellerId, Boolean hasPromo) {
        List<Post> posts = sellerRepository.getPosts();
        List<PostResponseDTO> postsDTO = posts.stream().map(post -> objectMapper.convertValue(post, PostResponseDTO.class)).toList();

        if(sellerId != null){
            postsDTO = postsDTO.stream().filter(post -> post.getUserId() == sellerId).toList();
        }

        if(hasPromo != null){
            postsDTO = postsDTO.stream().filter(post -> post.isHasPromo() == hasPromo).toList();
        }

        return postsDTO;
    }

    private Seller findSellerById(int id) {
        return sellerRepository.findById(id).orElseThrow(() -> new NotFoundException("Seller with id " + id + " not found"));
    }

    private Buyer findBuyerById(int id) {
        return buyerRepository.findById(id).orElseThrow(() -> new NotFoundException("Buyer with id " + id + " not found"));
    }

}
