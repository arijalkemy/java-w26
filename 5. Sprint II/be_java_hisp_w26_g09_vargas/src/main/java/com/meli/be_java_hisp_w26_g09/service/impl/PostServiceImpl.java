package com.meli.be_java_hisp_w26_g09.service.impl;

import com.meli.be_java_hisp_w26_g09.dto.*;
import com.meli.be_java_hisp_w26_g09.entity.Post;
import com.meli.be_java_hisp_w26_g09.entity.Role;
import com.meli.be_java_hisp_w26_g09.entity.User;
import com.meli.be_java_hisp_w26_g09.exception.BadRequestException;
import com.meli.be_java_hisp_w26_g09.exception.NotFoundException;
import com.meli.be_java_hisp_w26_g09.repository.IPostRepository;
import com.meli.be_java_hisp_w26_g09.repository.IProductRepository;
import com.meli.be_java_hisp_w26_g09.repository.IUserRepository;
import com.meli.be_java_hisp_w26_g09.service.IPostService;
import com.meli.be_java_hisp_w26_g09.util.mapper.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements IPostService {
    @Autowired
    IProductRepository productRepository;
    @Autowired
    IPostRepository postRepository;
    @Autowired
    IUserRepository userRepository;
    @Autowired
    PostMapper postMapper;

    @Override
    public ResponseDTO addPost(PostDTO post) {

        Optional<User> user = userRepository.findById(post.getUserId());
        if (user.isEmpty())
            throw new NotFoundException("The user_id does not exist");

        if (user.get().getRole().getIdRole().equals(Role.ID_CUSTOMER))
            throw new BadRequestException("The customer can't create posts ");

        Post postEntity = postMapper.postDTOtoPost(post);
        if (!productRepository.isCreated(postEntity.getProduct()))
            productRepository.createProduct(postEntity.getProduct());

        postRepository.createPost(postEntity);
        return new ResponseDTO("Post has been created");
    }

    @Override
    public ProductFollowedListDTO findFollowedPostsLastTwoWeeks(int userID) {
        Optional<User> user = userRepository.findById(userID);
        if (user.isEmpty())
            throw new NotFoundException("The user was not found");
        if (user.get().getFollowed() == null)
            throw new NotFoundException("The user don't follow no seller");
        List<Post> posts = postRepository.findAll();
        List<Post> followedPosts = new ArrayList<>();
        user.get().getFollowed().forEach(seller -> followedPosts.addAll(posts.stream()
                .filter(post -> post.getUserId().equals(seller.getUserId()))
                .toList()));

        LocalDate twoWeeksAgo = LocalDate.now().minusWeeks(2);
        LocalDate now = LocalDate.now();

        List<Post> followedPostsLastTwoWeeks = followedPosts.stream()
                .filter(post -> (post.getDate().isAfter(twoWeeksAgo) || post.getDate().isEqual(twoWeeksAgo))
                        && (post.getDate().isBefore(now) || post.getDate().isEqual(now)))
                .sorted(Comparator.comparing(Post::getDate).reversed())
                .collect(Collectors.toList());
        ProductFollowedListDTO productFollowedListDTO = new ProductFollowedListDTO();
        productFollowedListDTO.setUserId(user.get().getUserId());
        productFollowedListDTO.setPosts(postMapper.postListToPostForListDTOS(followedPostsLastTwoWeeks));
        return productFollowedListDTO;
    }

    @Override
    public ProductFollowedListDTO findFollowedPostsLastTwoWeeksSorted(int userID, String order) {
        ProductFollowedListDTO productFollowedListDTOSorted = findFollowedPostsLastTwoWeeks(userID);

        if (!("date_asc".equalsIgnoreCase(order) || "date_desc".equalsIgnoreCase(order)))
            throw new BadRequestException("Invalid order parameter. Valid values are 'date_asc' or 'date_desc'.");

        if ("date_asc".equalsIgnoreCase(order)) {
            productFollowedListDTOSorted.setPosts(productFollowedListDTOSorted.getPosts()
                    .stream()
                    .sorted(Comparator.comparing(PostForListDTO::getDate))
                    .collect(Collectors.toList()));
        }

        return productFollowedListDTOSorted;
    }
}
