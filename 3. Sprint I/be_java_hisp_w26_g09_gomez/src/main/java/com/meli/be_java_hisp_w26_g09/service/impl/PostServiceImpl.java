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
    public ResponseDTO addPostWithDiscount(PostDTO postDTO) {
        if(postDTO.getHasPromo() == null) throw new BadRequestException("Promo value can't be null");

        if(!postDTO.getHasPromo()) throw new BadRequestException("This product does not have promo");

        if(postDTO.getDiscount() <= 0) throw new BadRequestException("Discount value can't be 0 or less");

        postRepository.createPost(postMapper.postDTOtoPost(postDTO));
        return new ResponseDTO("Post with discount has been created");
    }

    @Override
    public PostPromoDTO getAllPostsBySeller(Integer sellerId) {
        checkSellerId(sellerId);

        List<PostDTO> posts = postRepository.findAll().stream().filter(post -> Objects.equals(post.getUserId(), sellerId))
                .map(postMapper::postToPostDTO).toList();

        return new PostPromoDTO(sellerId, userRepository.findById(sellerId).get().getUserName(), posts);
    }

    @Override
    public PromoCountDTO getPromoCountBySeller(Integer sellerId) {

        Optional<User> user = userRepository.findById(sellerId);

        checkSellerId(sellerId);

        Integer promoCount = Math.toIntExact(postRepository.findAll().stream()
                .filter(post -> post.getUserId() == sellerId && post.getHasPromo())
                .count());

        return new PromoCountDTO(sellerId, user.get().getUserName(), promoCount);
    }

    @Override
    public PostPromoDTO getAllPromoPostsBySeller(Integer sellerId) {
        checkSellerId(sellerId);

        List<PostDTO> posts = postRepository.findAll().stream()
                .filter(post -> Objects.equals(post.getUserId(), sellerId) && post.getHasPromo())
                .map(postMapper::postToPostDTO)
                .toList();

        return new PostPromoDTO(sellerId, userRepository.findById(sellerId).get().getUserName(), posts);
    }

    @Override
    public List<PostDTO> getAllPostByCategory(Integer categoryId) {
        if(categoryId == null || categoryId <= 0) throw new BadRequestException("The id provided is not valid");

        List<Post> posts = postRepository.findAll().stream()
                .filter(post -> Objects.equals(post.getCategory(), categoryId)).toList();

        if(posts.isEmpty()) throw new NotFoundException("Couldn't find posts with the category");

        return posts.stream().map(postMapper::postToPostDTO).toList();
    }

    @Override
    public List<PostDTO> getAllPostByPriceRange(Double minPrice, Double maxPrice) {
        if((minPrice == null || minPrice < 0) || (maxPrice == null || maxPrice < 0))
            throw new BadRequestException("The ranges can't be null or less than 0");

        List<Post> posts = postRepository.findAll().stream()
                .filter(post -> post.getPrice() >= minPrice && post.getPrice() <= maxPrice)
                .toList();

        if(posts.isEmpty()) throw new NotFoundException("Couldn't find post between the range");

        return posts.stream().map(postMapper::postToPostDTO).toList();
    }

    @Override
    public List<PostDTO> getAllPostsByProductBrand(String brand) {
        if(brand == null) throw new BadRequestException("Brand can't be null");

        List<Post> posts = postRepository.findAll().stream()
                .filter(post -> post.getProduct().getBrand().equalsIgnoreCase(brand))
                .toList();

        if(posts.isEmpty()) throw new NotFoundException("Couldn't find posts with the brand");

        return posts.stream().map(postMapper::postToPostDTO).toList();
    }

    @Override
    public List<PostDTO> getAllPostByProductName(String name) {
        if(name == null) throw new BadRequestException("Name can't be null");

        List<Post> posts = postRepository.findAll().stream()
                .filter(post -> post.getProduct().getProductName().toLowerCase().contains(name.toLowerCase()))
                .toList();

        if(posts.isEmpty()) throw new NotFoundException("Couldn't find posts with the name");

        return posts.stream().map(postMapper::postToPostDTO).toList();
    }

    @Override
    public List<PostDTO> getAllPostByProductTypeAndColor(String type, String color) {
        if(type == null || color == null) throw new BadRequestException("Type and color can't be null");

        List<Post> posts = postRepository.findAll().stream()
                .filter(post -> post.getProduct().getType().equalsIgnoreCase(type)
                        && post.getProduct().getColor().equalsIgnoreCase(color))
                .toList();

        if(posts.isEmpty()) throw new NotFoundException("Couldn't find posts with the type and color");

        return posts.stream().map(postMapper::postToPostDTO).toList();
    }

    private boolean validate(PostDTO post) {
        return Stream.of(post.getUserId(),
                post.getDate(),
                post.getProduct(),
                post.getCategory(),
                post.getPrice()).anyMatch(Objects::isNull);
    }

    private void checkSellerId(Integer sellerId){
        if(sellerId <= 0) throw new BadRequestException("The id is not valid");

        if(userRepository.findById(sellerId).isEmpty()) throw new NotFoundException("User not found");

        if(userRepository.findById(sellerId).get().getRole().getIdRole().equals(Role.ID_CUSTOMER))
            throw new BadRequestException("This user can't do this operation");
    }
}