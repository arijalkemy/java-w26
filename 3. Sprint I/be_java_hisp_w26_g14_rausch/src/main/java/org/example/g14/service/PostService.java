package org.example.g14.service;

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
    public PromoPostCountDto getPostsPromoByUserId(int userId) {
        List<Post> posts = postRepository.findAllByUser(userId);
        User user = userRepository.getById(userId).get();
        return new PromoPostCountDto(userId, user.getName(),posts.stream()
                .filter(Post::isHasPromo)
                .toList()
                .size());
    }

    @Override
    public List<CreatePostPromoDto> getPostsInOrder() {
        List<Post> posts = postRepository.getPostsInOrder();
        List<CreatePostPromoDto> postDtos = new ArrayList<>();

        for(Post post : posts) {
            postDtos.add(new CreatePostPromoDto(
                    post.getIdUser(),
                    post.getDate(),
                    new ProductDto(
                            post.getProduct().getId(),
                            post.getProduct().getName(),
                            post.getProduct().getType(),
                            post.getProduct().getBrand(),
                            post.getProduct().getColor(),
                            post.getProduct().getNotes()
                            ),
                    post.getCategory(),
                    post.getPrice(),
                    post.getDiscount()
                    ));
        }

        return postDtos;
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
    public void addPromopPost(CreatePostPromoDto createPostPromoDto) {
        PostMapper postMapper = new PostMapper();
        Post post = postMapper.createPostPromoDtoToPost(createPostPromoDto);

        if(createPostPromoDto.getDiscount() <= 0.0){
            throw new BadRequestException("Si creas un post con descuento, efectivamente tiene que tenerlo");
        }

        Optional<User> usuario = userRepository.getById(post.getIdUser());
        if(usuario.isEmpty()) {
            throw new NotFoundException("No se encontró el usuario con id: " + post.getIdUser());
        }

        postRepository.save(post);
    }
}
