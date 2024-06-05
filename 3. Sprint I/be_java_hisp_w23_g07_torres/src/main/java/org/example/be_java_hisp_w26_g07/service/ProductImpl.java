package org.example.be_java_hisp_w26_g07.service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.be_java_hisp_w26_g07.dto.PostDiscountDto;
import org.example.be_java_hisp_w26_g07.dto.PostDto;
import org.example.be_java_hisp_w26_g07.dto.PostRequestDto;
import org.example.be_java_hisp_w26_g07.dto.UserProductsPromotion;
import org.example.be_java_hisp_w26_g07.entity.DiscountPostDecorator;
import org.example.be_java_hisp_w26_g07.entity.Post;
import org.example.be_java_hisp_w26_g07.entity.PostDecorator;
import org.example.be_java_hisp_w26_g07.entity.User;
import org.example.be_java_hisp_w26_g07.exception.BadRequestException;
import org.example.be_java_hisp_w26_g07.exception.NotFoundException;
import org.example.be_java_hisp_w26_g07.repository.interfaces.IUserRepository;
import org.example.be_java_hisp_w26_g07.service.interfaces.IProductService;

import org.example.be_java_hisp_w26_g07.utils.PostUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
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
    public PostDiscountDto createPostWithDiscount(PostDiscountDto postDiscountDto){
        User myUser = iUserRepository.findById(postDiscountDto.getUserId());
        if (myUser == null) {
            throw new BadRequestException("El usuario no existe");
        }

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Post post = mapper.convertValue(postDiscountDto, Post.class);
        post.setId(PostUtil.increaseCounter());
        postDiscountDto.setId(post.getId());
        PostDecorator postDecorator = new DiscountPostDecorator();
        postDecorator.setPost(post);
        ((DiscountPostDecorator)postDecorator).setHas_promo(postDiscountDto.getHas_promo());
        ((DiscountPostDecorator)postDecorator).setDiscount(postDiscountDto.getDiscount());
        myUser.getPosts().add(postDecorator);
        myUser.setIsSeller(true);
        return postDiscountDto;
    }

    @Override
    public UserProductsPromotion getQuantityProductsPromotion(Integer userId){
        User user = iUserRepository.findById(userId);
        if (user == null) throw new NotFoundException("Usuario no encontrado");
        if (!user.getIsSeller()) throw new NotFoundException("El usuario no es un vendedor");
        Long cuantityPromotion = user.getPosts().stream()
                                                    .filter( v -> v instanceof DiscountPostDecorator)
                                                        .count();
        UserProductsPromotion userProductsPromotion = new UserProductsPromotion(user.getId(), user.getName(),
                                                            cuantityPromotion.intValue());
        return userProductsPromotion;
    }

    @Override
    public List<PostDiscountDto> getListProductsPromotionsBySeller(Integer userId){
        User user = iUserRepository.findById(userId);
        if (user == null) throw new NotFoundException("Usuario no encontrado");
        if (!user.getIsSeller()) throw new NotFoundException("El usuario no es un vendedor");

        ObjectMapper mapper = new ObjectMapper();
        List<PostDiscountDto> listPostDiscountDto = user.getPosts()
                                                    .stream()
                                                        .filter( v -> v instanceof DiscountPostDecorator)
                                                            .map(v->(DiscountPostDecorator)v)
                                                                .map(v -> {
                                                                    PostDiscountDto dto = mapper.
                                                                            convertValue(v.getPost(), PostDiscountDto.class);
                                                                                dto.setDiscount(v.getDiscount());
                                                                                    dto.setHas_promo(v.getHas_promo());
                                                                             return dto;
                                                                            }).collect(Collectors.toList());

        if(listPostDiscountDto.size() == 0) return null;
        else{
            return listPostDiscountDto;
        }
    }
}
