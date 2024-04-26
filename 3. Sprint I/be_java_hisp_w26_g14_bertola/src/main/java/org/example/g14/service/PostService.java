package org.example.g14.service;

import ch.qos.logback.core.read.ListAppender;
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
                            post.getPrice(),
                            post.isHasPromo()
                    );
                })
                .collect(Collectors.toList());
    }

    @Override
    public void addPromoPost(CreatePostDto promoPostDto) {
        PostMapper postMapper = new PostMapper();
        Post postToAdd = postMapper.createPostDtoToPost(promoPostDto);

        if (!postToAdd.isHasPromo()) {
            throw new BadRequestException("El producto debe estar en promocion");
        } else if (postToAdd.getDiscount() <=0) {
            throw new BadRequestException("El producto debe tener descuento");
        } else if (userRepository.getById(postToAdd.getIdUser()).isEmpty()) {
            throw new NotFoundException("No se encontró al usuario con id " + postToAdd.getIdUser());
        }

        postRepository.save(postToAdd);
    }

    @Override
    public int getPromoProdCountByUserId(int userId) {
        if (userRepository.getById(userId).isEmpty()){
            throw new NotFoundException("No se encontró el usuario con id " + userId);
        } else if (postRepository.findAllByUser(userId).isEmpty()) {
            throw new BadRequestException("El usuario no es vendedor");
        }

        return (int)postRepository.findAllByUser(userId).stream().filter(Post::isHasPromo).count();
    }

    @Override
    public CartPriceDto getCartTotalPrice(List<Integer> cart) {
        if (cart == null || cart.isEmpty() || cart.contains(null)) {
            throw new BadRequestException("La lista de productos no puede estar vacía o contener valores nulos.");
        }

        List<Post> cartPosts = postRepository.findByPostId(cart);

        if (cartPosts.size() != cart.size()) {
            throw new NotFoundException("No se encontraron todas las publicaciones especificadas.");
        }

        double totalPrice = cartPosts.stream().mapToDouble(post -> {
                    double price = post.getPrice();
                    return post.isHasPromo() ? price * (1 - post.getDiscount()) : price;
            }).sum();

        List<CartPostDto> cartPostsDto = cartPosts.stream().map(post -> {
                double postPrice = post.isHasPromo() ? post.getPrice() * (1 - post.getDiscount()) : post.getPrice();

                ProductDto productDto = new ProductDto(
                        post.getProduct().getId(),
                        post.getProduct().getName(),
                        post.getProduct().getType(),
                        post.getProduct().getBrand(),
                        post.getProduct().getColor(),
                        post.getProduct().getNotes()
                );

                return new CartPostDto(
                        post.getIdUser(),
                        post.getId(),
                        post.getDate(),
                        productDto,
                        post.getCategory(),
                        post.getPrice(),
                        post.isHasPromo(),
                        post.getDiscount(),
                        postPrice);
            }).collect(Collectors.toList());

        return new CartPriceDto(cartPostsDto, totalPrice);
    }
}
