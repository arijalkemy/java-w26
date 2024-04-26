package org.example.be_java_hisp_w26_g07.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.be_java_hisp_w26_g07.dto.PostDto;
import org.example.be_java_hisp_w26_g07.dto.PostDtoPromo;
import org.example.be_java_hisp_w26_g07.dto.PostDtoPromoCount;
import org.example.be_java_hisp_w26_g07.dto.PostRequestDto;
import org.example.be_java_hisp_w26_g07.entity.Post;
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
    public PostDtoPromo createPostPromo(PostRequestDto postRequestDto) {
        User myUser = iUserRepository.findById(postRequestDto.getUserId());
        if (myUser == null) {
            throw new BadRequestException("El usuario no existe");
        }
        if (postRequestDto.getDiscount()==null){
            throw new BadRequestException("Debe especificar un descuento");
        }
        ObjectMapper mapper = new ObjectMapper();
        Post post = mapper.convertValue(postRequestDto, Post.class);
        post.setId(PostUtil.increaseCounter());
        myUser.getPosts().add(post);
        myUser.setIsSeller(true);
        return mapper.convertValue(post, PostDtoPromo.class);
    }

    @Override
    public PostDtoPromoCount getPromoPostCount(Integer userID) {
        ObjectMapper mapper = new ObjectMapper();
        User myUser = iUserRepository.findById(userID);
        if (myUser == null) {
            throw new NotFoundException("El usuario no existe");
        }
        PostDtoPromoCount countPostPromo = iUserRepository.getPromoPostCount(myUser);
        if (countPostPromo.getPromo_products_count()==0) {
            throw new NotFoundException("No se encontraron publicaciones en promocion para el vendedor."+countPostPromo.getUser_name());
        }
        //getPostOrderByDate(postsList, order);
        return countPostPromo;
    }

    @Override
    public List<PostDto> getPromoPostList(Integer userId, String order) {
        ObjectMapper mapper = new ObjectMapper();
        User myUser = iUserRepository.findById(userId);
        if (myUser == null) {
            throw new NotFoundException("El usuario no existe");
        }
        List<Post> postsListPromo = iUserRepository.getPromoPostList(myUser);

        if (postsListPromo.isEmpty()) {
            throw new NotFoundException("No se encontraron publicaciones con promocion para el vendedor.");
        }
        getPostOrderByDate(postsListPromo, order);
        return postsListPromo.stream()
                .map(post -> mapper.convertValue(post, PostDto.class))
                .collect(Collectors.toList());

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
}
