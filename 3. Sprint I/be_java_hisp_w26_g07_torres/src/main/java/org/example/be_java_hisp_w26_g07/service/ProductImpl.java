package org.example.be_java_hisp_w26_g07.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.be_java_hisp_w26_g07.dto.*;
import org.example.be_java_hisp_w26_g07.entity.Category;
import org.example.be_java_hisp_w26_g07.entity.Post;
import org.example.be_java_hisp_w26_g07.entity.Product;
import org.example.be_java_hisp_w26_g07.entity.User;
import org.example.be_java_hisp_w26_g07.exception.BadRequestException;
import org.example.be_java_hisp_w26_g07.exception.NotFoundException;
import org.example.be_java_hisp_w26_g07.repository.interfaces.IUserRepository;
import org.example.be_java_hisp_w26_g07.service.interfaces.IProductService;

import org.example.be_java_hisp_w26_g07.utils.PostUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ProductImpl implements IProductService {

    private final IUserRepository iUserRepository;

    public ProductImpl(@Autowired IUserRepository iUserRepository) {
        this.iUserRepository = iUserRepository;
    }

    @Override
    public List<PostDto> findProductByFollow(Integer userID, String order) {
        ObjectMapper mapper = new ObjectMapper();

        User foundUser = iUserRepository.findById(userID);
        if (foundUser == null) {
            throw new BadRequestException("El usuario con id "+userID+" no existe");
        }
        List<Post> postsList = iUserRepository.findProductByFollow(foundUser);
        if (postsList.isEmpty()) {
            throw new NotFoundException("No se encontraron publicaciones para las ultimas dos semanas.");
        }

        getPostOrderByDate(postsList, order);
        return postsList.stream()
                .map(post -> {
                    PostDto mappedPostDto = mapper.convertValue(post, PostDto.class);
                    Product product = iUserRepository.findProductById(mappedPostDto.getId());
                    ProductDto mappedProductDto = mapper.convertValue(product, ProductDto.class);
                    mappedPostDto.setProduct(mappedProductDto);
                    return mappedPostDto;
                })
                .collect(Collectors.toList());
    }

    private void getPostOrderByDate(List<Post> postList,
                                    String order) {
        if (order == null) return;
        switch (order) {
            case "date_asc":
                postList.sort(Comparator.comparing(Post::getDate));
                break;
            case "date_desc":
                postList.sort(Comparator.comparing(Post::getDate).reversed());
                break;
            default:
        }
    }

    @Override
    public PostDto createPost(PostRequestDto postRequestDto) {
        User myUser = iUserRepository.findById(postRequestDto.getUserId());
        if (myUser == null) {
            throw new BadRequestException("El usuario no existe");
        }

        ObjectMapper mapper = new ObjectMapper();
        SimplePostDto simplePostDto = mapper.convertValue(postRequestDto, SimplePostDto.class);
        Post post = mapper.convertValue(simplePostDto, Post.class);
        post.setId(PostUtil.increaseCounter());

        Product product = mapper.convertValue(postRequestDto.getProduct(), Product.class);
        Product foundProduct = iUserRepository.findProductById(product.getId());
        if (foundProduct != null) {
            throw new BadRequestException("Un producto con ese id ya existe, por favor actualice el id");
        }

        iUserRepository.createProduct(product);
        post.setProductId(product.getId());

        iUserRepository.addPost(post);
        if (!myUser.getIsSeller()) myUser.setIsSeller(true);

        PostDto createdPost = mapper.convertValue(post, PostDto.class);
        ProductDto createdProduct = mapper.convertValue(product, ProductDto.class);
        createdPost.setProduct(createdProduct);
        return createdPost;
    }

    @Override
    public SuccessResponseDto createPromoPost(PromoPostReqDto postReqDto) {
        User foundUser = iUserRepository.findById(postReqDto.getUserId());
        if (foundUser == null) {
            throw new BadRequestException("El usuario con id "+postReqDto.getUserId()+" no existe");
        }

        ObjectMapper mapper = new ObjectMapper();
        SimplePostDto simplePostDto = mapper.convertValue(postReqDto, SimplePostDto.class);
        Post post = mapper.convertValue(simplePostDto, Post.class);
        post.setId(PostUtil.increaseCounter());
        post.setHasPromo(postReqDto.getHasPromo());
        post.setDiscount(postReqDto.getDiscount());
        Product product = mapper.convertValue(postReqDto.getProduct(), Product.class);
        Product foundProduct = iUserRepository.findProductById(product.getId());
        if (foundProduct != null) {
            throw new BadRequestException("Un producto con ese id ya existe, por favor actualice el id");
        }
        iUserRepository.createProduct(product);
        post.setProductId(product.getId());

        iUserRepository.addPost(post);
        if (!foundUser.getIsSeller()) foundUser.setIsSeller(true);
        return new SuccessResponseDto("Post con promoción creado exitosamente");
    }

    @Override
    public PromoPostResDto getPromoPostsBySellerId(Integer userId) {
        User foundUser = iUserRepository.findById(userId);
        if (foundUser == null) {
            throw new BadRequestException("El usuario con id "+userId+" no existe");
        }
        List<Post> postByUser = iUserRepository.getPromoPostsBySellerId(userId);
        if (postByUser == null) {
            throw new BadRequestException("No se encontraron posts para el vendedor con id "+userId);
        }
        int postsCount = postByUser.size();

        return new PromoPostResDto(foundUser.getId(), foundUser.getName(), postsCount);
    }

    // Statistics with posts by (year or month), quantity on promo vs total, quantity by categories
    @Override
    public StatisticsDto getStatistics(Integer userId) {
        List<Post> allPosts = iUserRepository.getPostsBySellerId(userId);

        Map<String, Integer> postsByYear = new HashMap<>();
        Map<String, Integer> postsByCategory = new HashMap<>();
        for (Post post : allPosts) {
            String key = Integer.toString(post.getDate().getYear());
            if (!postsByYear.containsKey(key)) {
                postsByYear.put(key, 0);
            }
            Integer currCount = postsByYear.get(key);
            postsByYear.put(key, currCount + 1);

            Category category = iUserRepository.getCategoryById(post.getCategoryId());
            if (category != null) {
                String catName = category.getDescription();
                if (!postsByCategory.containsKey(catName)) {
                    postsByCategory.put(catName, 0);
                }
                Integer currCatCount = postsByCategory.get(catName);
                postsByCategory.put(catName, currCatCount + 1);
            }
        }

        PromoRatioDto promoRatioDto = new PromoRatioDto();
        List<Post> promoPosts = iUserRepository.getPromoPostsBySellerId(userId);
        promoRatioDto.setInPromo(promoPosts.size());
        promoRatioDto.setTotal(allPosts.size());


        return new StatisticsDto(userId, postsByYear, promoRatioDto, postsByCategory);
    }
}
