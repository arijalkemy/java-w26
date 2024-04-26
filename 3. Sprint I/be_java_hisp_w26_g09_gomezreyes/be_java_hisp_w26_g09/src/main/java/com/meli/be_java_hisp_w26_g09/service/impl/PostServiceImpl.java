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

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        if (post.getPrice() < 0)
            throw new BadRequestException("The price cannot be negative");

        post.setHasPromo(false);
        if (post.getDiscount() != null && post.getDiscount() != 0.0)
            throw new BadRequestException("Cannot add a promo post on this end point");

        post.setDiscount(0.0);

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
    public ResponseDTO addPromoPost(PostDTO post) {
        if (post.getPrice() < 0)
            throw new BadRequestException("The price cannot be negative");

        if (post.getHasPromo()==null || post.getHasPromo()==false)
            throw new BadRequestException("The post must be a promo");

        if (post.getDiscount()==null || post.getDiscount()>1 || post.getDiscount()<=0)
            throw new BadRequestException("Must include a valid discount");

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
        return new ResponseDTO("Promo post has been created");
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
    public UserDTO findPromoPostCountBySeller(Integer id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) throw new NotFoundException("The user was not found");
        if (user.get().getRole() == null || user.get().getRole().getIdRole().equals(Role.ID_CUSTOMER))
            throw new BadRequestException("The user isn't a seller");
        UserDTO userResult = new UserDTO();
        userResult.setUserId(id);
        userResult.setUserName(user.get().getUserName());
        userResult.setPromoProductsCount(postRepository.findPostBySeller(id).stream().filter(p -> p.getHasPromo()==true).count());
        return userResult;
    }

    @Override
    public ResponseDTO updatePostToPromoPost(Integer idPost, PostDTO post) {
        if(post.getHasPromo()==null || post.getHasPromo()==false)
            throw new BadRequestException("Must include a promo");

        if (post.getDiscount()==null || post.getDiscount()>1 || post.getDiscount()<=0)
            throw new BadRequestException("Must include a valid discount");

        Post postNew = postRepository.findPostById(idPost);
        if(postNew==null)
            throw new BadRequestException("This post doesn't exist");
        if(postNew.getHasPromo()==true)
            throw new BadRequestException("This post already is a promo");
        postNew.setHasPromo(true);
        postNew.setDiscount(post.getDiscount());
        postNew.setId(idPost);
        postRepository.updatePost(postNew);
        return new ResponseDTO("Post has been updated to Promo post correctly");
    }

    @Override
    public PostDTO findPostById(Integer id){
        Post post = postRepository.findPostById(id);
        if(post==null)
            throw new NotFoundException("Not exist a post with this id");
        return postMapper.postToPostDTO(post);
    }

    public UserDTO findPromoPostBySeller(Integer id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) throw new NotFoundException("The user was not found");
        if (user.get().getRole() == null || user.get().getRole().getIdRole().equals(Role.ID_CUSTOMER))
            throw new BadRequestException("The user isn't a seller");
        UserDTO userResult = new UserDTO();
        userResult.setUserId(id);
        userResult.setUserName(user.get().getUserName());

        userResult.setPosts(postMapper
                .listPostToListPostDTO(postRepository
                        .findPostBySeller(id)
                        .stream()
                        .filter(p -> p.getHasPromo()==true)
                        .toList()));
        return userResult;
    }

    @Override
    public ResponseDTO updatePost(Integer id, PostDTO post) {
        if(post.getPostId()!=null)
            throw new BadRequestException("Cannot update the post id");
        Post postNew = postRepository.findPostById(id);
        postNew = postMapper.mergePostDTOToPost(post, postNew);
        postNew.setId(id);
        if(postNew.getPrice() < 0)
            throw new BadRequestException("The price cannot be negative");
        if(postNew.getCategory()<0)
            throw new BadRequestException("The category isn't valid");
        if(postNew.getDiscount()>1 || postNew.getDiscount()<=0)
            throw new BadRequestException("Must include a valid discount");
        postRepository.updatePost(postNew);
        return new ResponseDTO("Post has been updated correctly");
    }

    @Override
    public ResponseDTO removePost(Integer id) {
        if(postRepository.findPostById(id)==null)
            throw new BadRequestException("The post doesn't exist");
        postRepository.deletePost(id);
        return new ResponseDTO("Post has been deleted");
    }


    private boolean validate(PostDTO post) {
        return Stream.of(post.getUserId(),
                post.getDate(),
                post.getProduct(),
                post.getCategory(),
                post.getPrice()).anyMatch(Objects::isNull);
    }
}
