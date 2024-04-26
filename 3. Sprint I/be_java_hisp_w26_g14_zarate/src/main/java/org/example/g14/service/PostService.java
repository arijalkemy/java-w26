package org.example.g14.service;

import org.example.g14.dto.*;
import org.example.g14.exception.BadRequestException;
import org.example.g14.exception.NotFoundException;
import org.example.g14.model.Post;
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
    public void createPostWithPromo(CreatePostDto postWithPromo) {
        User user = userRepository.getById(postWithPromo.getIdUser())
                .orElseThrow(() -> new NotFoundException("No se encontro usuario con ese id"));

        if(postWithPromo.getDiscount() <= 0 || !postWithPromo.isHasPromo())
            throw new BadRequestException("Campos inválidos y/o faltantes.");

        Post post = new PostMapper().createPostDtoToPost(postWithPromo);
        postRepository.save(post);
    }

    @Override
    public UserWithPromoPostsCountDto getNumberOfPromoPost(int userId) {
        User user = userRepository.getById(userId)
                .orElseThrow(() -> new NotFoundException("No se encontro usuario con ese id"));

        List<Post> listOfPromoPost = postRepository.findAllByUser(userId);
        int postCounter = listOfPromoPost.stream().reduce(0, (acc, post) -> {
            if(post.isHasPromo())
                return acc + 1;
            return acc;
        }, Integer::sum);

        return new UserWithPromoPostsCountDto(user.getId(), user.getName(), postCounter);
    }

    @Override
    public UserResumeDto getResume(int userId) {
        User user = userRepository.getById(userId)
                .orElseThrow(() -> new NotFoundException("No se encontro usuario con ese id"));

        List<Post> listOfPosts = postRepository.findAllByUser(userId);
        int postCounter = listOfPosts.size();
        int postWithPromoCounter = listOfPosts.stream().reduce(0, (acc, post) -> {
            if(post.isHasPromo())
                return acc + 1;
            return acc;
        }, Integer::sum);
        LocalDate dateFirstProduct = listOfPosts.stream()
                .min(Comparator.comparing(Post::getDate))
                .get()
                .getDate();
        LocalDate dateLastProduct = listOfPosts.stream()
                .max(Comparator.comparing(Post::getDate))
                .get()
                .getDate();
        double maxPrice = listOfPosts.stream()
                .max(Comparator.comparing(Post::getPrice))
                .get()
                .getPrice();
        double minPrice = listOfPosts.stream()
                .min(Comparator.comparing(Post::getPrice))
                .get()
                .getPrice();
        double averagePrice = listOfPosts.stream()
                .mapToDouble(Post::getPrice)
                .average()
                .getAsDouble();
        double totalPublished = listOfPosts.stream()
                .mapToDouble(Post::getPrice)
                .sum();
        double totalPublishedWithDiscount = listOfPosts.stream()
                .filter(Post::isHasPromo)
                .mapToDouble(post -> post.getPrice() * (1 - post.getDiscount()))
                .sum();

        return new UserResumeDto(user.getId(), user.getName(), postCounter, postWithPromoCounter,
                dateFirstProduct, dateLastProduct, maxPrice, minPrice, averagePrice, totalPublished,
                totalPublishedWithDiscount);
    }
}
