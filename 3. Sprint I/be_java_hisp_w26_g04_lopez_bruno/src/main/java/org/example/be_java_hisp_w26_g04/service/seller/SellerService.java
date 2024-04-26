package org.example.be_java_hisp_w26_g04.service.seller;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import java.util.*;

import lombok.RequiredArgsConstructor;
import org.example.be_java_hisp_w26_g04.dto.*;
import org.example.be_java_hisp_w26_g04.exceptions.BadRequestException;
import org.example.be_java_hisp_w26_g04.model.Buyer;
import org.example.be_java_hisp_w26_g04.model.Post;
import org.example.be_java_hisp_w26_g04.model.Promotion;
import org.example.be_java_hisp_w26_g04.model.Seller;
import org.example.be_java_hisp_w26_g04.repository.buyer.IBuyersRepository;
import org.example.be_java_hisp_w26_g04.repository.promotion.IPromotionRepository;
import org.example.be_java_hisp_w26_g04.repository.seller.ISellerRepository;
import org.example.be_java_hisp_w26_g04.util.exceptionsHandler.ObjectExist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SellerService implements ISellerService {

    @Autowired
    ISellerRepository sellerRepository;

    @Autowired
    IBuyersRepository buyerRepository;

    @Autowired
    IPromotionRepository promotionRepository;

    @Autowired
    ObjectMapper objectMapper;

    private int promotionIdCounter;

    @Override
    public FollowersCountDTO findFollowers(int sellerId) {
        Seller seller = ObjectExist.getObjectFromOptional(sellerRepository.findById(sellerId));
        int followerCount = seller.getFollowers().size();

        FollowersCountDTO followersCountDTO = objectMapper.convertValue(seller, FollowersCountDTO.class);
        followersCountDTO.setFollowersCount(followerCount);

        return followersCountDTO;
    }

    @Override
    public SellerFollowersDTO getFollowers(int userId) {
        Seller seller = ObjectExist.getObjectFromOptional(sellerRepository.findById(userId));
        return converSellerToSellerFollowersDto(seller);
    }

    @Override
    public SellerFollowersDTO sortGetFollowers(int userId, String order) {
        SellerFollowersDTO sellerFollowersDTO = getFollowers(userId);
        List<UserDTO> res = sellerFollowersDTO.getFollowers();

        if (order.equals("name_asc")) {
            res = sellerFollowersDTO.getFollowers().stream()
                    .sorted(Comparator.comparing(UserDTO::getUserName)).toList();
        } else if (order.equals("name_desc")) {
            res = sellerFollowersDTO.getFollowers().stream()
                    .sorted(Comparator.comparing(UserDTO::getUserName).reversed())
                    .toList();
        } else {
            throw new BadRequestException();
        }

        sellerFollowersDTO.setFollowers(res);
        return sellerFollowersDTO;
    }

    private List<Buyer> getBuyersFromSeller(Seller seller) {
        return seller.getFollowers().stream()
                .map(x -> buyerRepository.findById(x))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();
    }

    private SellerFollowersDTO converSellerToSellerFollowersDto(Seller seller) {
        List<Buyer> buyers = getBuyersFromSeller(seller);
        List<UserDTO> followers = buyers.stream()
                .map(follower -> objectMapper.convertValue(follower, UserDTO.class))
                .toList();
        return new SellerFollowersDTO(seller.getUserId(), seller.getUserName(), followers);
    }

    private List<PostResponseDTO> getPostsFromFollower(int userId) {
        Buyer buyer = ObjectExist.getObjectFromOptional(buyerRepository.findById(userId));
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
    public void createNewPost(PostRequestDTO post) {
        ObjectExist.getObjectFromOptional(sellerRepository.findById(post.getUserId()));
        // lanza error si no esxite el seller

        Post unPost = objectMapper.convertValue(post, Post.class);
        addPost(unPost);
    }

    private void addPost(Post post) {
        Seller seller = ObjectExist.getObjectFromOptional(sellerRepository.findById(post.getUserId()));
        int maxPostId = seller.getListPost().stream()
                .mapToInt(Post::getIdPost)
                .max()
                .orElse(0);

        post.setIdPost(++maxPostId);
        seller.getListPost().add(post);
    }

    @Override
    public void addPromotion(PromotionRequestDTO promotionDTO) {
        Promotion promotion = createNewPromotionFromDTO(promotionDTO);
        promotionRepository.save(promotion);
    }

    private Promotion createNewPromotionFromDTO(PromotionRequestDTO promotionDTO) {
        Post post = objectMapper.convertValue(promotionDTO, Post.class);
        ObjectExist.getObjectFromOptional(sellerRepository.findById(post.getUserId()));
        // return error if seller doesn't exist
        addPost(post);
        promotionIdCounter++;
        return new Promotion(
                promotionIdCounter,
                promotionDTO.getUserId(),
                post.getIdPost(),
                promotionDTO.isHasPromo(),
                promotionDTO.getDiscount()
        );
    }

    @Override
    public PromotionsCountByUserResponseDTO getCountPromoByUser(int userId) {
        Seller seller = ObjectExist.getObjectFromOptional(sellerRepository.findById(userId));
        int promotionsCount = getPromotionsByUserId(userId).size();
        return new PromotionsCountByUserResponseDTO(
                userId,
                seller.getUserName(),
                promotionsCount
        );
    }

    private List<Promotion> getPromotionsByUserId(int userId){
            Set<Promotion> promotions = promotionRepository.findAll();
            return promotions.stream().filter(p -> p.getUserId() == userId).toList();
    }


    @Override
    public List<PromotionResponseDTO> getPromotionsResponseDTOByUserId(int userId) {
        Seller seller = ObjectExist.getObjectFromOptional(sellerRepository.findById(userId));
        List<Post> posts = sellerRepository.getPosts();
        String userName = seller.getUserName();

        Set<Promotion> promotions = promotionRepository.findAll();
        List<Promotion> promotionsById = getPromotionsByUserId(userId);

        return promotionsById.stream().map(
                promotion -> {
                    Post post = getPostFromPromotion(posts, promotion);
                    return createPromotionResponseDTOFromUserIdAndPostAndUserName(
                            seller.getUserId(),
                            userName,
                            post
                    );
                }
        ).toList();
    }

    private Post getPostFromPromotion(List<Post> posts, Promotion promotion ){
        Optional<Post> optionalPost = posts.stream()
                .filter(p -> promotion.getPostId() == p.getIdPost()).findFirst();
        return ObjectExist.getObjectFromOptional(optionalPost);
    }

    private PromotionResponseDTO createPromotionResponseDTOFromUserIdAndPostAndUserName(
            int userId, String userName, Post post
    ){
        PostResponseDTO postDTO = objectMapper.convertValue(post, PostResponseDTO.class);
        return new PromotionResponseDTO(
                userId,
                userName,
                postDTO
        );



    }

}
