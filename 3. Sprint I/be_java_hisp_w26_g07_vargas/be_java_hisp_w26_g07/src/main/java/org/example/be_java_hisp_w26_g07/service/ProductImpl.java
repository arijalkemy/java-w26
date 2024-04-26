package org.example.be_java_hisp_w26_g07.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.be_java_hisp_w26_g07.dto.CountPromoResponseDto;
import org.example.be_java_hisp_w26_g07.dto.PostDto;
import org.example.be_java_hisp_w26_g07.dto.PostRequestDto;
import org.example.be_java_hisp_w26_g07.dto.PromoRequestDto;
import org.example.be_java_hisp_w26_g07.entity.Post;
import org.example.be_java_hisp_w26_g07.entity.User;
import org.example.be_java_hisp_w26_g07.exception.BadRequestException;
import org.example.be_java_hisp_w26_g07.exception.NoContentException;
import org.example.be_java_hisp_w26_g07.exception.NotAcceptable;
import org.example.be_java_hisp_w26_g07.exception.NotFoundException;
import org.example.be_java_hisp_w26_g07.repository.interfaces.IUserRepository;
import org.example.be_java_hisp_w26_g07.service.interfaces.IProductService;
import org.example.be_java_hisp_w26_g07.utils.PostUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public void createPromoPost(PromoRequestDto promoRequestDto) {
        User user = iUserRepository.findById(promoRequestDto.getUserId());
        if (user == null) {
            throw new NotFoundException("El usuario no existe");
        }
        ObjectMapper mapper = new ObjectMapper();
        Post post = mapper.convertValue(promoRequestDto, Post.class);
        post.setId(PostUtil.increaseCounter());
        user.getPosts().add(post);
        user.setIsSeller(true);
    }

    @Override
    public CountPromoResponseDto getNumberOfPromotions(String userId) {
        User user = getUserById(userId);
        Long count = user.getPosts().stream().filter(Post::getHasPromo).count();
        return new CountPromoResponseDto(user.getId(), user.getName(), count);
    }

    @Override
    public List<PostDto> getPromotions(String userId) {
        User user = getUserById(userId);
        ObjectMapper mapper = new ObjectMapper();
        List<PostDto> postDtos = new ArrayList<>();
        for (Post post : user.getPosts()) {
            if (post.getHasPromo()) {
                postDtos.add(mapper.convertValue(post, PostDto.class));
            }
        }
        return postDtos;
    }

    @Override
    public List<PostDto> getPosts(String userId) {
        User user = getUserById(userId);
        ObjectMapper mapper = new ObjectMapper();
        List<PostDto> postDtos = new ArrayList<>();
        for (Post post : user.getPosts()) {
            postDtos.add(mapper.convertValue(post, PostDto.class));
        }
        return postDtos;
    }

    @Override
    public List<PostDto> getAllProducts() {
        List<PostDto> posts = new ArrayList<>();
        return convertToPostDto(getAllPosts());
    }

    @Override
    public List<PostDto> getProductsFilteredByColor(String color) {
        if (!PostUtil.colores.contains(color.toLowerCase())) {
            throw new BadRequestException("Este color no existe");
        }
        List<Post> allPosts = getAllPosts();
        allPosts = allPosts.stream()
                .filter(x -> x.getProduct().getColor().equalsIgnoreCase(color))
                .toList();
        List<PostDto> posts = convertToPostDto(allPosts);
        if (posts.isEmpty()) {
            throw new NoContentException("No existen productos con el color: " + color);
        }
        return posts;
    }

    @Override
    public List<PostDto> getProductsFilteredByCategory(String category) {
        if (!category.matches("\\d+")) {
            throw new BadRequestException("Solo se aceptan valores numéricos");
        }
        List<Post> posts = getAllPosts().stream()
                .filter(x -> x.getCategory().equals(Integer.parseInt(category)))
                .toList();
        if (posts.isEmpty()) {
            throw new NoContentException("No se encontaron productos con la categoría: " + category);
        }
        return convertToPostDto(posts);
    }

    @Override
    public List<PostDto> getProductsWithAPriceLowerThan(String price) {
        Double value = PostUtil.convertToDouble(price);
        if (value == null) {
            throw new BadRequestException("El valor debe ser numérico");
        }
        List<Post> posts = getAllPosts().stream().filter(x -> x.getPrice() <= value).toList();
        if (posts.isEmpty()) {
            throw new NoContentException("No se encontaron productos con precio menor a: " + price);
        }
        return convertToPostDto(posts);
    }

    @Override
    public List<PostDto> getProductsWithPricesBetween(String since, String to) {
        Double since1 = PostUtil.convertToDouble(since);
        Double to1 = PostUtil.convertToDouble(to);
        if (since1 == null || to1 == null) {
            throw new BadRequestException("Los valores debe ser numéricos");
        }
        if (since1 >= to1) {
            throw new BadRequestException("El primer valor (since) debe ser mayor al segundo (to)");
        }
        List<Post> posts = getAllPosts().stream().filter(x -> x.getPrice() <= to1 && x.getPrice() >= since1).toList();
        if (posts.isEmpty()) {
            throw new NoContentException("No se encontaron productos con precio entre a: " + since + " y " + to);
        }
        return convertToPostDto(posts);
    }

    @Override
    public List<PostDto> getDiscountedProductsFrom(String discount) {
        Double value = PostUtil.convertToDouble(discount);
        if (value == null) {
            throw new BadRequestException("El valor debe ser numérico");
        }
        List<Post> posts = getAllPosts().stream().filter(x -> x.getDiscount()>= value/100).toList();
        if (posts.isEmpty()) {
            throw new NoContentException("No se encontaron productos con descuentos desde: " + discount);
        }
        return convertToPostDto(posts);
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

    private User getUserById(String userId) {
        if (!userId.matches("\\d+")) {
            throw new BadRequestException("El valor ingresado no es numérico");
        }
        User user = iUserRepository.findById(Integer.parseInt(userId));
        if (user == null) {
            throw new NotFoundException("Usuario no encontrado");
        }
        if (!user.getIsSeller()) {
            throw new NotAcceptable("Existe el usuario pero no es vendedor");
        }
        return user;
    }

    private List<Post> getAllPosts() {
        List<Post> posts = new ArrayList<>();
        List<User> users = iUserRepository.findAll().stream()
                .filter(user -> Boolean.TRUE.equals(user.getIsSeller()))
                .toList();
        for (User user : users) {
            posts.addAll(user.getPosts());
        }
        return posts;
    }

    private List<PostDto> convertToPostDto(List<Post> originalPosts) {
        List<PostDto> posts = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        for (Post post : originalPosts) {
            posts.add(mapper.convertValue(post, PostDto.class));
        }
        return posts;
    }
}
