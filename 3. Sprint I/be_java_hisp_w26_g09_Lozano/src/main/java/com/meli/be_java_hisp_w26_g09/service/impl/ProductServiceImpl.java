package com.meli.be_java_hisp_w26_g09.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.be_java_hisp_w26_g09.dto.*;
import com.meli.be_java_hisp_w26_g09.entity.Post;
import com.meli.be_java_hisp_w26_g09.entity.Role;
import com.meli.be_java_hisp_w26_g09.entity.User;
import com.meli.be_java_hisp_w26_g09.exception.BadRequestException;
import com.meli.be_java_hisp_w26_g09.exception.NotFoundException;
import com.meli.be_java_hisp_w26_g09.repository.IPostRepository;
import com.meli.be_java_hisp_w26_g09.repository.IProductRepository;
import com.meli.be_java_hisp_w26_g09.repository.IUserRepository;
import com.meli.be_java_hisp_w26_g09.service.IProductService;
import com.meli.be_java_hisp_w26_g09.util.mapper.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    IProductRepository productRepository;
    @Autowired
    IPostRepository postRepository;
    @Autowired
    IUserRepository userRepository;
    @Autowired
    PostMapper postMapper;


    @Override
    public ResponseDTO addNotPromoPost(PostDTO post) {
        if (post.getHasPromo() == true || (post.getDiscount() != null && post.getDiscount() != 0.0))
            throw new BadRequestException("Cannot add a promo post on this end point");
        return createPost(post);
    }

    @Override
    public ResponseDTO addPromoPost(PostDTO post) {

        if (post.getHasPromo() == false)
            throw new BadRequestException("Cannot add a not promo post on this end point");
        if(post.getDiscount() == null || post.getDiscount() == 0.0)
            throw new BadRequestException("it is necessary to indicate discount");
        return createPost(post);
    }

    @Override
    public ResponseDTO createPost(PostDTO post){
        if (post.getPrice() < 0)
            throw new BadRequestException("The price cannot be negative");

        if (validate(post))
            throw new BadRequestException("No field can be null");

        Optional<User> user = userRepository.findById(post.getUserId());
        if (user.isEmpty())
            throw new BadRequestException("The user_id does not exist ");

        if (user.get().getRole() == null || user.get().getRole().getIdRole().equals(Role.ID_CUSTOMER))
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
        if (user.isEmpty()) throw new NotFoundException("The user was not found");
        if (user.get().getFollowed() == null) throw new NotFoundException("The user don't follow no seller");
        Calendar twoWeeksAgo = Calendar.getInstance();
        twoWeeksAgo.add(Calendar.WEEK_OF_YEAR, -2);
        List<Post> posts = postRepository.findAll();
        List<Post> followedPosts = new ArrayList<>();
        user.get().getFollowed().forEach(seller -> followedPosts.addAll(posts.stream()
                .filter(post -> post.getUserId().equals(seller.getUserId()))
                .toList()));

        List<Post> followedPostsLastTwoWeeks = followedPosts.stream()
                .filter(post -> post.getDate().after(twoWeeksAgo.getTime())).toList()
                .stream().sorted(Comparator.comparing(Post::getDate).reversed()).toList();

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

    @Override
    public PostSellerPromoPostDTO findPromoPostBySeller(int userId) {
        List<Post> postSellerPromoPostDTOList = postRepository.findBySellerAndPromoPost(userId);

        if(postSellerPromoPostDTOList.isEmpty()) throw new NotFoundException("No results found");

        PostSellerPromoPostDTO postSellerPromoPostDTO = new PostSellerPromoPostDTO();

        postSellerPromoPostDTO.setUserId(userId);
        postSellerPromoPostDTO.setUserName(userRepository.findById(userId).get().getUserName());
        postSellerPromoPostDTO.setPromoProductsCount(postSellerPromoPostDTOList.size());

        return postSellerPromoPostDTO;

    }

    @Override
    public List<PostDTO> findAllPost() {
        List<Post> postList = postRepository.findAll();

        if(postList.isEmpty()) throw new NotFoundException("No results found");

        return postList.stream()
                .map(post -> postMapper.convertPostToPostDTO(post, PostDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ResponseDTO deletePost(Integer id) {

        if(!postRepository.postExistById(id))
            throw new NotFoundException("Id: " + id + " no exist");

        postRepository.deletePost(id);
        return new ResponseDTO("Post: " + id + " has been delete.");

    }


    private boolean validate(PostDTO post) {
        return Stream.of(post.getUserId(),
                post.getDate(),
                post.getProduct(),
                post.getCategory(),
                post.getPrice()).anyMatch(Objects::isNull);
    }
}
