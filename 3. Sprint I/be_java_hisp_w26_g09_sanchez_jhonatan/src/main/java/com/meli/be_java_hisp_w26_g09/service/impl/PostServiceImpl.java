package com.meli.be_java_hisp_w26_g09.service.impl;

import com.meli.be_java_hisp_w26_g09.dto.*;
import com.meli.be_java_hisp_w26_g09.entity.Post;
import com.meli.be_java_hisp_w26_g09.entity.User;
import com.meli.be_java_hisp_w26_g09.exception.BadRequestException;
import com.meli.be_java_hisp_w26_g09.exception.NotFoundException;
import com.meli.be_java_hisp_w26_g09.exception.NullEntityException;
import com.meli.be_java_hisp_w26_g09.repository.ICategoryRepository;
import com.meli.be_java_hisp_w26_g09.repository.IPostRepository;
import com.meli.be_java_hisp_w26_g09.repository.IProductRepository;
import com.meli.be_java_hisp_w26_g09.repository.IUserRepository;
import com.meli.be_java_hisp_w26_g09.service.IPostService;
import com.meli.be_java_hisp_w26_g09.service.IUserService;
import com.meli.be_java_hisp_w26_g09.util.mapper.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class PostServiceImpl implements IPostService {
    @Autowired
    private IProductRepository productRepository;
    @Autowired
    private IPostRepository postRepository;
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private PostMapper postMapper;
    @Autowired
    private IUserService userService;
    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public ResponseDTO addPost(PostDTO post) {
        validate(post);

        if (post.getPrice() < 0)
            throw new BadRequestException("The price cannot be negative");

        post.setHasPromo(false);

        if (post.getDiscount() != null && post.getDiscount() != 0.0)
            throw new BadRequestException("Cannot add a promo post on this end point");

        post.setDiscount(0.0);

        User user = userService.getUser(post.getUserId());

        if (userService.isCustomer(user.getUserId()))
            throw new BadRequestException("The customer can't create posts ");

        Post postEntity = postMapper.postDTOtoPost(post);
        if (!productRepository.isCreated(postEntity.getProduct()))
            productRepository.createProduct(postEntity.getProduct());

        postRepository.createPost(postEntity);
        return new ResponseDTO("Post has been created");
    }

    @Override
    public ProductFollowedListDTO findFollowedPostsLastTwoWeeks(int userID) {
        User user = userService.getUser(userID);
        if (user.getFollowed() == null) throw new NotFoundException("The user don't follow no seller");
        Calendar twoWeeksAgo = Calendar.getInstance();
        twoWeeksAgo.add(Calendar.WEEK_OF_YEAR, -2);
        List<Post> followedPosts = new ArrayList<>();
        user.getFollowed()
                .forEach(seller -> followedPosts.addAll(postRepository.findAllByIdUser(seller.getUserId())));

        List<Post> followedPostsLastTwoWeeks = followedPosts.stream()
                .filter(post -> post.getDate().after(twoWeeksAgo.getTime())).toList()
                .stream().sorted(Comparator.comparing(Post::getDate).reversed()).toList();

        return new ProductFollowedListDTO(
                user.getUserId(),
                postMapper.postListToPostForListDTOS(followedPostsLastTwoWeeks));
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
    public ResponseDTO savePromoPost(PostDTO postDTO) {
        validate(postDTO);

        if (postDTO.getHasPromo() == null || postDTO.getHasPromo().equals(Boolean.FALSE))
            throw new BadRequestException("The has_promo attribute cannot be null or false.");

        if (userService.isCustomer(postDTO.getUserId()))
            throw new BadRequestException("The customer can't create promo posts.");

        if (postDTO.getCategory() == null
                || categoryRepository.findById(postDTO.getCategory()).isEmpty())
            throw new NotFoundException("No information was found for the related category.");

        postRepository.createPost(postMapper.postDTOtoPost(postDTO));
        return new ResponseDTO("The promo post was saved successfully.");
    }

    @Override
    public List<PostForListDTO> getAll() {
        return postMapper.postListToPostForListDTOS(postRepository.findAll());
    }

    @Override
    public UserDTO getCountPromoPostById(Integer id) {
        if (userService.isCustomer(id))
            throw new BadRequestException("The user customer does not have posts.");

        User user = userService.getUser(id);

        return new UserDTO(
                user.getUserId(),
                user.getUserName(),
                postRepository.findAllByIdUser(id)
                        .stream()
                        .filter(post -> post.getHasPromo().equals(Boolean.TRUE))
                        .toList().size()
        );
    }

    @Override
    public UserDTO getListPromoPostById(Integer id) {
        if (userService.isCustomer(id))
            throw new BadRequestException("The user customer does not have posts.");

        User user = userService.getUser(id);
        return new UserDTO(
                user.getUserId(),
                user.getUserName(),
                postMapper.postListToPostDTOList(postRepository.findAllByIdUser(id)
                        .stream()
                        .filter(post -> post.getHasPromo().equals(Boolean.TRUE))
                        .toList())
        );
    }


    private void validate(PostDTO post) {
        if (post == null)
            throw new NullEntityException("Post");

        if (Stream.of(post.getUserId(),
                post.getDate(),
                post.getProduct(),
                post.getCategory(),
                post.getPrice()).anyMatch(Objects::isNull))
            throw new BadRequestException("No field can be null");

    }
}
