package org.example.be_java_hisp_w26_g04.service.seller;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import lombok.RequiredArgsConstructor;
import org.example.be_java_hisp_w26_g04.dto.FollowersCountDTO;
import org.example.be_java_hisp_w26_g04.dto.PostRequestDTO;
import org.example.be_java_hisp_w26_g04.dto.PostResponseDTO;
import org.example.be_java_hisp_w26_g04.dto.SellerFollowersDTO;
import org.example.be_java_hisp_w26_g04.dto.UserDTO;
import org.example.be_java_hisp_w26_g04.exceptions.BadRequestException;
import org.example.be_java_hisp_w26_g04.model.Buyer;
import org.example.be_java_hisp_w26_g04.model.Post;
import org.example.be_java_hisp_w26_g04.model.Seller;
import org.example.be_java_hisp_w26_g04.repository.buyer.IBuyersRepository;
import org.example.be_java_hisp_w26_g04.repository.seller.ISellerRepository;
import org.example.be_java_hisp_w26_g04.util.crud.exceptionsHandler.ObjectExist;
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
    ObjectMapper objectMapper;

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

    private List<Buyer> getBuyersFromSeller(Seller seller){
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
}
