package org.example.be_java_hisp_w26_g07.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JSR310Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
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
import java.util.Optional;
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

    @Override
    public PostDto createPost(PostRequestDto postRequestDto) {
        User myUser = iUserRepository.findById(postRequestDto.getUserId());
        if (myUser == null) {
            throw new BadRequestException("El usuario no existe");
        }
        ObjectMapper mapper = new ObjectMapper();
        Post post = mapper.convertValue(postRequestDto, Post.class);
        post.setId(PostUtil.increaseCounter());
        myUser.getPosts().add(post);
        myUser.setIsSeller(true);
        return mapper.convertValue(post, PostDto.class);
    }

    @Override
    public PostPromoResponseDto createPostWithPromo(PostPromoRequestDto postPromoRequestDto) {
        User myUser = iUserRepository.findById(postPromoRequestDto.getUserId());
        if (myUser == null) throw new BadRequestException("El usuario no existe");

        ObjectMapper mapper = new ObjectMapper();
        Post post = mapper.convertValue(postPromoRequestDto, Post.class);
        post.setId(PostUtil.increaseCounter());

        myUser.getPosts().add(post);
        myUser.setIsSeller(true);

        return mapper.convertValue(post, PostPromoResponseDto.class);
    }

    @Override
    public PromoPostCountResponseDto getPromoCountByUser(Integer id) {
        User myUser = iUserRepository.findById(id);
        if (myUser == null) throw new BadRequestException("El usuario no existe");

        PromoPostCountResponseDto promoPostCountResponseDto = new PromoPostCountResponseDto();
        promoPostCountResponseDto.setId(myUser.getId());
        promoPostCountResponseDto.setName(myUser.getName());

        Integer countOfPromos = (int) myUser.getPosts().stream().filter(p -> p.isHasPromo()).count();
        promoPostCountResponseDto.setPromoProductsCount(countOfPromos);

        return promoPostCountResponseDto;
    }

    @Override
    public List<ProductResponseDto> findProductsWithDiscountByFollowers(Double discount, Integer userID) {
        List<User> usersFollowedByUser = iUserRepository.findById(userID).getFollowerIds().stream()
                .map(iUserRepository::findById).toList();
        List<ProductResponseDto> products = getListOfProductsWithDiscountByUser(usersFollowedByUser, discount);
        if (products.isEmpty()) throw new NotFoundException("No se encontraron productos con el descuento");
        return products;
    }

    @Override
    public List<ProductResponseDto> findProductsWithDiscount(Double discount) {
        List<User> allUsers = iUserRepository.findAll().stream().filter(u -> u.getIsSeller()).toList();
        List<ProductResponseDto> products = getListOfProductsWithDiscountByUser(allUsers, discount);
        if (products.isEmpty()) throw new NotFoundException("No se encontraron productos con el descuento");
        return products;
    }

    @Override
    public List<ProductResponseDto> findProductsByNameProduct(String name) {
        List<ProductResponseDto> listOfProductsByName = new ArrayList<>();

        iUserRepository.findAll().forEach(u-> {
            List<Post> postUserWithName = u.getPosts().stream().filter(p->p.getProduct().getName()
                            .toLowerCase().contains(name.toLowerCase()))
                    .toList();
            postUserWithName.forEach(p -> {
                listOfProductsByName.add(createProductResponseDto(p, u));
            });
        });
        if (listOfProductsByName.isEmpty()) throw new NotFoundException("No se encontraron productos con el nombre");
        return listOfProductsByName;
    }

    @Override
    public List<ProductResponseDto> findProductsWithDiscountBySeller(Integer sellerId) {
        User seller = iUserRepository.findById(sellerId);

        List<ProductResponseDto> products = seller.getPosts().stream().filter(p->p.isHasPromo()).map(
                p -> {
                    Double priceDicount = p.getPrice() - (p.getPrice() * p.getDiscount());
                    return new ProductResponseDto(seller.getId(), seller.getName(), p.getProduct().getId()
                            , p.getProduct().getName(), p.getProduct().getType(), p.getProduct().getBrand(),
                            p.getProduct().getColor(), p.getProduct().getNotes(), p.getCategory(),
                            p.getPrice(),
                            p.getDiscount(), priceDicount);
                }).toList();
        if (products.isEmpty()) throw new NotFoundException("No se encontraron productos con el descuento");
        return products;
    }

    private List<ProductResponseDto> getListOfProductsWithDiscountByUser(List<User> users, Double discount) {
        List<ProductResponseDto> postPromoResponseDtoList = new ArrayList<>();
        users.forEach(user -> {
            List<Post> posts = user.getPosts();
            posts.stream().filter(p->p.isHasPromo() && p.getDiscount() >= discount).forEach(p -> {
                postPromoResponseDtoList.add(createProductResponseDto(p, user));
            });
        });
        return postPromoResponseDtoList;
    }

    private ProductResponseDto createProductResponseDto(Post post, User user) {
        Double priceDicount = post.getPrice() - (post.getPrice() * post.getDiscount());
        return new ProductResponseDto(user.getId(),user.getName(),post.getProduct().getId()
                ,post.getProduct().getName(), post.getProduct().getType(), post.getProduct().getBrand(),
                post.getProduct().getColor(), post.getProduct().getNotes(), post.getCategory(), post.getPrice(),
                post.getDiscount(), priceDicount);
    }
}
