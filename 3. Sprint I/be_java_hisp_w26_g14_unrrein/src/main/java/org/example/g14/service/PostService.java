package org.example.g14.service;

import org.example.g14.dto.CreatePostDto;
import org.example.g14.dto.PostDto;
import org.example.g14.dto.UserWithPromoPostsCountDto;
import org.example.g14.exception.BadRequestException;
import org.example.g14.exception.NotFoundException;
import org.example.g14.model.Post;
import org.example.g14.model.User;
import org.example.g14.repository.IPostRepository;
import org.example.g14.repository.IUserRepository;
import org.example.g14.utils.PostMapper;
import org.example.g14.utils.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


@Service
public class PostService implements IPostService {

    @Autowired
    IPostRepository postRepository;

    @Autowired
    IUserRepository userRepository;


    @Override
    public void add(CreatePostDto createPostDto) {

        if (!Validation.isValid(createPostDto))
            throw new BadRequestException("Campos inválidos y/o faltantes.");

        Post post = PostMapper.mapToEntity(createPostDto);

        userRepository.getById(post.getIdUser())
            .orElseThrow(() -> new NotFoundException("No se encontró el usuario con id: " + post.getIdUser()));

        postRepository.save(post);
    }

    @Override
    public void addWithPromo(CreatePostDto createPromoPostDto) {

        if (createPromoPostDto.getHasPromo() != Boolean.TRUE)
            throw new BadRequestException("Para crear una promo, el campo 'has_promo' debe tener valor 'true'");

        add(createPromoPostDto);
    }

    @Override
    public UserWithPromoPostsCountDto getCountOfPromoPostsBySeller(Integer userId) {

        User user = userRepository.getById(userId)
            .orElseThrow(() -> new NotFoundException("No se encontró el usuario con id: " + userId));

        List<Post> userPosts = postRepository.findAllByUser(userId);

        if (userPosts.isEmpty())
            throw new BadRequestException("El usuario con el ID:" + userId + " no es un vendedor");

        long promoPostsCount = userPosts.stream().filter(Post::isHasPromo).count();

        return new UserWithPromoPostsCountDto(
            user.getId(),
            user.getName(),
            (int) promoPostsCount
        );
    }

    @Override
    public List<? extends PostDto> getPostsFromFollowed(int userId, String order, Boolean hasPromo) {

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

        List<? extends PostDto> result;

        if (hasPromo == Boolean.TRUE) {
            result = recentPosts.stream()
                .filter(Post::isHasPromo)
                .map(PostMapper::mapToPostWithDiscountDto)
                .toList();
        }
        else {
            result = recentPosts.stream()
                .map(PostMapper::mapToPostDto)
                .toList();
        }

        return result;
    }
}
