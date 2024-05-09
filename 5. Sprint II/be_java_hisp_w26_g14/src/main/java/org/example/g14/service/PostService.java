package org.example.g14.service;

import org.example.g14.dto.request.PostCreateRequestDto;
import org.example.g14.dto.response.MessageResponseDto;
import org.example.g14.dto.response.PostResponseDto;

import org.example.g14.exception.OrderInvalidException;
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
import java.util.stream.Collectors;

@Service
public class PostService implements IPostService {

    @Autowired
    IUserServiceInternal userServiceInternal;

    @Autowired
    IPostRepository postRepository;

    @Autowired
    IUserRepository userRepository;

    @Override
    public MessageResponseDto add(PostCreateRequestDto postCreateRequestDto) {
        Post post = PostMapper.createPostDtoToPost(postCreateRequestDto);

        userServiceInternal.searchUserIfExists(post.getIdUser());

        postRepository.save(post);
        return new MessageResponseDto("Post creado exitosamente.");
    }

    @Override
    public List<PostResponseDto> getPostsFromFollowed(int userId, String order) {

        User user = userServiceInternal.searchUserIfExists(userId);

        List<Integer> followedVendors = user.getIdFollows();

        List<Post> allPosts = new ArrayList<>();
        for (Integer vendorId : followedVendors) {
            allPosts.addAll(postRepository.findAllByUser(vendorId));
        }

        if (order != null && !order.isEmpty() && !order.equals("date_asc") && !order.equals("date_desc")) {
            throw new OrderInvalidException(order);
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
                .map(PostMapper::postToPostResponseDto)
                .collect(Collectors.toList());
    }
}
