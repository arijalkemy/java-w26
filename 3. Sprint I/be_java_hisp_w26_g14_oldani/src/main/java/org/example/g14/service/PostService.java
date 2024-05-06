package org.example.g14.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.g14.dto.*;
import org.example.g14.exception.BadRequestException;
import org.example.g14.exception.NotFoundException;
import org.example.g14.model.Post;
import org.example.g14.model.Product;
import org.example.g14.model.User;
import org.example.g14.repository.IPostRepository;
import org.example.g14.repository.IUserRepository;
import org.example.g14.utils.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostService implements IPostService {
    @Autowired
    IPostRepository postRepository;

    @Autowired
    IUserRepository userRepository;

    @Override
    public void add(CreatePostDto createPostDto) {
        PostMapper postMapper = new PostMapper();
        Post post = postMapper.createPostDtoToPost(createPostDto);

        Optional<User> usuario = userRepository.getById(post.getIdUser());
        if(usuario.isEmpty()) {
            throw new NotFoundException("No se encontró el usuario con id: " + post.getIdUser());
        }

        postRepository.save(post);
    }

    @Override
    public List<PostDto> getPostsFromFollowed(int userId, String order) {
        User user = userRepository.getById(userId).orElseThrow(() -> new NotFoundException("Usuario no encontrado"));

        List<Integer> followedVendors = user.getIdFollows();

        List<Post> allPosts = new ArrayList<>();
        for (Integer vendorId : followedVendors) {
            allPosts.addAll(postRepository.findAllByUser(vendorId));
        }

        if (order != null && !order.isEmpty() && !order.equals("date_asc") && !order.equals("date_desc")) {
            throw new BadRequestException("Tipo de orden inválido");
        }

        LocalDate twoWeeksAgo = LocalDate.now().minusWeeks(2);
        List<Post> recentPosts = new ArrayList<>(allPosts.stream()
                .filter(post -> post.getDate().isAfter(twoWeeksAgo))
                .toList());

        if (order != null && order.equals("date_asc")) {
            recentPosts.sort(Comparator.comparing(Post::getDate));
        } else if (order != null && order.equals("date_desc")) {
            recentPosts.sort(Comparator.comparing(Post::getDate).reversed());
        }

        return recentPosts.stream()
                .map(post -> {

                    ProductDto productDto = new ProductDto();
                    productDto.setId(post.getProduct().getId());
                    productDto.setName(post.getProduct().getName());
                    productDto.setType(post.getProduct().getType());
                    productDto.setBrand(post.getProduct().getBrand());
                    productDto.setColor(post.getProduct().getColor());
                    productDto.setNotes(post.getProduct().getNotes());

                    return new PostDto(
                            post.getIdUser(),
                            post.getId(),
                            post.getDate(),
                            productDto,
                            post.getCategory(),
                            post.getPrice()
                    );
                })
                .collect(Collectors.toList());
    }

    @Override
    public PromotionProductCountDto getPromotionalProducts(int user_id) {
        User user = getUserById(user_id);
        List<Post> postList = postRepository.findAllByUser(user.getId());
        if(postList.isEmpty()){
            throw new BadRequestException("El usuario con el ID:" + user_id + " no es un vendedor");
        }

        return new PromotionProductCountDto(
                user.getId(),
                user.getName(),
                postList.size()
        );
    }

    @Override
    public List<ProductDto> getProductsFromTag(String tag) {
        List<Post> postList = postRepository.findAll()
                .stream()
                .filter(post -> post.getProduct()
                                    .getNotes().toLowerCase()
                                    .contains(tag.toLowerCase()))
                .toList();

        if (postList.isEmpty()){
            throw new NotFoundException("No se encontraron productos con el tag " + tag);
        }

        ObjectMapper mapper = new ObjectMapper();
        List<ProductDto> productListDto = new ArrayList<>();
        postList.stream()
                .forEach(post -> productListDto.add(
                        new ProductDto(post.getProduct().getId(),
                                post.getProduct().getName(),
                                post.getProduct().getType(),
                                post.getProduct().getBrand(),
                                post.getProduct().getColor(),
                                post.getProduct().getNotes())));

        return productListDto;
    }

    private User getUserById(int id){
        Optional<User> user = userRepository.getById(id);
        if(user.isEmpty())
            throw new NotFoundException("No se encontro el usuario");
        return user.get();
    }
}
