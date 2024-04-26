package com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.service.impl;

import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.dto.*;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.entity.Post;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.entity.Product;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.entity.User;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.exception.BadRequestException;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.exception.IncorrectDateException;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.exception.InvalidOperation;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.exception.NotFoundException;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.repository.IPostRepository;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.repository.IProductRepository;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.repository.IUserRepository;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.service.IPostService;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class PostServiceImpl implements IPostService {

    @Autowired
    IUserRepository userRepository;

    @Autowired
    IProductRepository productRepository;

    @Autowired
    IPostRepository postRepository;


    /**
     *  Creates a new post based on the provided PostDTO object. This method validates the incoming data,
     *  converts it into a Post entity, and persists it in the database. Various checks are performed during
     *  the creation process to ensure data integrity and consistency.
     *
     * @param postDTO The PostDTO object containing data for creating the post.
     * @return An ExceptionDto object indicating the status of the operation.
     * @throws BadRequestException   if the provided PostDTO is invalid.
     * @throws NotFoundException     if the user or product referenced in the post is not found.
     * @throws IncorrectDateException if the date in the post is before the current date.
     */
    public ExceptionDto create(PostDTO postDTO){
        if(isBadRequestPostDto(postDTO)){ throw new BadRequestException("The request is invalid or missing required data."); }
        ObjectMapper mapper = JsonMapper.builder()
                .addModule(new JavaTimeModule())
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false)
                .build();
        Post post = mapper.convertValue(postDTO, Post.class);
        User user = userRepository.findById(post.getUserId());

        if(user == null){
            throw new NotFoundException("User with id " + post.getUserId() + " does not exist.");
        } if(productRepository.findById(post.getProduct().getProductId()) == null){
            throw new NotFoundException("Product with id " + post.getProduct().getProductId() + " does not exist.");
        } if(post.getDate().isBefore(LocalDate.now())){
            throw  new IncorrectDateException("The provided date in the post is before the current date.");
        }

        postRepository.create(post);
        user.getPosts().add(post);
        return new ExceptionDto("The post has been successfully created");
    }

    @Override
    public PromoProductCountDTO getPromoProductCount(int userId){
        User user = userRepository.findById(userId);
        if(user == null){
            throw new NotFoundException("User with id " + userId + " does not exist.");
        }
        List<Product> promoProductlist = postRepository.getPostBy(userId).stream().filter(p -> p.isHasPromo()).map(p ->p.getProduct()).toList();
        Map<Integer, List<Product>> promoPostMap = promoProductlist.stream().collect(Collectors.groupingBy(Product::getProductId));
        return new PromoProductCountDTO(userId, user.getUserName(), promoPostMap.size());
    }

    @Override
    public ExceptionDto setPromo(PromoPostSetDTO promoPostSetDTO){
        Optional<Post> post = postRepository.getPostById(promoPostSetDTO.getPostId());
        if(!post.isPresent()){
            throw new NotFoundException("Post with id " + promoPostSetDTO.getPostId() + " does not exist.");
        } if(post.get().isHasPromo()) {
            throw new InvalidOperation("The post has a promo already.");
        } if(post.get().getDiscount() > 1 || post.get().getDiscount() <= 0){
            throw new BadRequestException("The request is invalid or missing required data.");
        }
        post.get().setDiscount(promoPostSetDTO.getDiscount());
        post.get().setHasPromo(true);
        return new ExceptionDto("The post has been successfully correctly.");
    }

    @Override
    public PostListDTO getProductPosts(int productId, String order, Boolean onlyPromo) {
        Stream<Post> postList = postRepository.getAll().stream().filter(p -> p.getProduct().getProductId() == productId);
        if(onlyPromo != null && onlyPromo){
            postList = postList.filter(Post::isHasPromo);
        }
        if(order != null) {
            if (order.equals("user")) {
                postList = postList.sorted(Comparator.comparing(Post::getUserId));
            } else if (order.equals("price_asc")) {
                postList = postList.sorted(Comparator.comparing(Post::getPrice));
            } else if (order.equals("price_desc")) {
                postList = postList.sorted(Comparator.comparing(Post::getPrice).reversed());
            } else if (order.equals("date_asc")) {
                postList = postList.sorted(Comparator.comparing(Post::getDate));
            } else if (order.equals("date_desc")) {
                postList = postList.sorted(Comparator.comparing(Post::getDate).reversed());
            } else {
                throw new BadRequestException("Incorrect order parameter.");
            }
        }
        List<PostDTO> postDTOList = new ArrayList<>();
        ObjectMapper mapper = JsonMapper.builder()
                .addModule(new JavaTimeModule())
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false)
                .build();
        for(Post post: postList.toList()){
            postDTOList.add(mapper.convertValue(post, PostDTO.class));
        }
        return new PostListDTO(postDTOList);
    }

    private boolean isBadRequestPostDto(PostDTO postDto){
        return postDto.getDate() == null || postDto.getDate().isEmpty() ||
                postDto.getPrice() <= 0 ||
                postDto.getCategory() <= 0 ||
                postDto.getUserId() <= 0 ||
                postDto.getProduct() == null || isBadRequestProductDto(postDto.getProduct()) ||
                postDto.isHasPromo() && postDto.getDiscount() > 1 || postDto.getDiscount() < 0;
    }

    private boolean isBadRequestProductDto(ProductDTO productDTO){
        return productDTO.getProductId() <= 0 ||
                productDTO.getProductName() == null || productDTO.getProductName().isEmpty() ||
                productDTO.getBrand() == null || productDTO.getBrand().isEmpty() ||
                productDTO.getNotes() == null || productDTO.getNotes().isEmpty() ||
                productDTO.getType() == null || productDTO.getType().isEmpty() ||
                productDTO.getColor() == null || productDTO.getColor().isEmpty();
    }
}
