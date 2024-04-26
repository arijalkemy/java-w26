package org.example.be_java_hisp_w26_g07.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.be_java_hisp_w26_g07.dto.*;
import org.example.be_java_hisp_w26_g07.entity.Post;
import org.example.be_java_hisp_w26_g07.entity.User;
import org.example.be_java_hisp_w26_g07.exception.BadRequestException;
import org.example.be_java_hisp_w26_g07.exception.NotFoundException;
import org.example.be_java_hisp_w26_g07.repository.interfaces.IUserRepository;
import org.example.be_java_hisp_w26_g07.service.interfaces.IProductService;

import org.example.be_java_hisp_w26_g07.utils.PostUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Comparator;
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
        List<Post> postsList = iUserRepository.findProductByFollow(iUserRepository.findById(userID));
        if (postsList.isEmpty()) {
            throw new NotFoundException("No se encontraron publicaciones para las ultimas dos semanas.");
        }
        getPostOrderByDate(postsList, order);
        return postsList.stream()
                .map(post -> mapper.convertValue(post, PostDto.class))
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

    private PostDto savePostUtility(Post post) {
        ObjectMapper mapper = new ObjectMapper();
        User user = iUserRepository.findById(post.getUserId());
        post.setId(PostUtil.increaseCounter());
        user.getPosts().add(post);
        user.setIsSeller(true);
        return mapper.convertValue(post, PostDto.class);
    }

    @Override
    public PostDto createPost(PostRequestDto postRequestDto) {
        ObjectMapper mapper = new ObjectMapper();
        User myUser = iUserRepository.findById(postRequestDto.getUserId());
        if (myUser == null) {
            throw new BadRequestException("El usuario no existe");
        }
        Post post = mapper.convertValue(postRequestDto, Post.class);
        return savePostUtility(post);
    }

    @Override
    public PostDto createPromotionPost(PromotionPostDto promotion) {
        ObjectMapper mapper = new ObjectMapper();
        Post post = mapper.convertValue(promotion, Post.class);
        return savePostUtility(post);
    }

    @Override
    public PromoPostCountDto findListPromotionCountById(Integer userId) {
        User user = iUserRepository.findById(userId);
        if (user == null) throw new NotFoundException("El usuario no existe");
        if (!user.getIsSeller()) throw new NotFoundException("El usuario no es vendedor");
        return new PromoPostCountDto(userId, user.getName(), iUserRepository.findPostPromotionByUserId(userId).size());
    }

    @Override
    public List<PostDto> findListPromotionById(Integer userId) {
        ObjectMapper mapper = new ObjectMapper();
        User user = iUserRepository.findById(userId);
        if (user == null) throw new NotFoundException("El usuario no existe");
        if (!user.getIsSeller()) throw new NotFoundException("El usuario no es vendedor");
        return iUserRepository.findPostPromotionByUserId(userId)
                .stream()
                .map(promotion -> mapper.convertValue(promotion, PostDto.class))
                .toList();
    }

    @Override
    public List<PostDto> findProductsBetweenPrice(Double minPrice, Double maxPrice) {
        ObjectMapper mapper = new ObjectMapper();
        return iUserRepository.findProductsBetweenPrice(minPrice, maxPrice)
                .stream()
                .map(post -> mapper.convertValue(post, PostDto.class))
                .toList();
    }

    @Override
    public List<CategoryProductsDto> findCategoryProducts() {
        Map<String, Integer> categoryId = iUserRepository.findCategoryProducts();
        List<CategoryProductsDto> categoryProductsList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : categoryId.entrySet()) {
            categoryProductsList.add(new CategoryProductsDto(entry.getKey(), entry.getValue()));
        }
        return categoryProductsList;
    }
}
