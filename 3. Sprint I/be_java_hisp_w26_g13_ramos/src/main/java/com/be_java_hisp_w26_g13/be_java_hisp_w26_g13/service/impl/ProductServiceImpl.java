package com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.service.impl;

import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.dto.ResponseVendorPromoCountDTO;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.entity.Post;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.dto.PostDTO;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.dto.PostsByFollowedUsersDTO;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.entity.User;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.entity.UserMinimalData;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.exception.BadRequestException;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.exception.NotFoundException;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.repository.IPostRepository;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.repository.IUserRepository;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.service.IProductService;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.temporal.TemporalAmount;
import java.util.Comparator;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    IUserRepository userRepository;

    @Autowired
    IPostRepository postRepository;

    /**
     * Orders the given list of posts by date in either ascending or descending order.
     *
     * @param posts the list of posts to be sorted
     * @param order the order in which the posts should be sorted.
     *              Must be one of the following strings:
     *              - "date_asc" for ascending order
     *              - "date_desc" for descending order
     */
    private void orderByDate(List<PostDTO> posts, String order) {
        if (order.equals("date_asc")) {
            posts.sort(Comparator.comparing(PostDTO::getDate));
        } else if (order.equals("date_desc")) {
            posts.sort(Comparator.comparing(PostDTO::getDate).reversed());
        }else {
            throw new BadRequestException("Order should be date_asc or date_desc.");
        }
    }

    /**
     * Retrieves a list of posts created by users followed by the specified user within the last two weeks.
     *
     * @param userId the ID of the user whose followed vendors' posts are to be retrieved
     * @param order  the order in which the posts should be sorted (optional, can be null).
     *               Possible values are "date_asc" for ascending order and "date_desc" for descending order.
     * @return a DTO (Data Transfer Object) containing posts created by followed users within the last two weeks,
     *         sorted according to the specified order if provided
     * @throws NotFoundException     if the user with the specified userId does not exist or if no posts are found
     * within the specified range
     * @throws BadRequestException    if the user with the specified userId has not followed any vendors
     */
    @Override
    public PostsByFollowedUsersDTO getPostByFollowedUsers(int userId, String order) {
        ObjectMapper mapper = JsonMapper.builder()
                .addModule(new JavaTimeModule())
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false)
                .build();
        User user = userRepository.findById(userId);
        if (user == null) {
            throw new NotFoundException("User with id " + userId + " does not exist.");
        }
        List<UserMinimalData> followedVendors = user.getFollowed();
        if (followedVendors.isEmpty()) {
            throw new BadRequestException("User with id  " + userId + " has not followed vendors");
        }
        List<PostDTO> followedVendorsPostList = new ArrayList<>();
        LocalDate twoWeeksAgo = LocalDate.now().minusDays(14);
        for (UserMinimalData vendor : followedVendors) {
            postRepository.getPostBy(vendor.getUserId()).stream()
                    .filter(post -> post.getDate().isAfter(twoWeeksAgo) && post.getDate().isBefore(LocalDate.now().plusDays(1)))
                    .forEach(post -> {
                        followedVendorsPostList.add(mapper.convertValue(post, PostDTO.class));
                    });
        }
        if (followedVendorsPostList.isEmpty()) {
            throw new NotFoundException("have not been found posts in that range");
        }
        //ordenamiento por fecha ascendente
        if (order != null) {
            orderByDate(followedVendorsPostList, order);
        }else{
        followedVendorsPostList.sort(Comparator.comparing(PostDTO::getDate));
        }

        return new PostsByFollowedUsersDTO(userId, followedVendorsPostList);
    }

    @Override
    public ResponseVendorPromoCountDTO gerUserPromos(int userId) {
        User user = userRepository.findById(userId);
        if (user == null) {
            throw new NotFoundException("User with id " + userId + " does not exist.");
        }
        if (user.getPosts().isEmpty()){
            throw new BadRequestException("User with id " + userId + " is not a vendor");
        }

        int count = (int) postRepository.getPostBy(userId).stream().filter(Post::isHasPromo).count();
        if (count == 0){
            throw new NotFoundException("The vendor " + user.getUserName() + " has not any promos right now");
        }

        return new ResponseVendorPromoCountDTO(userId, user.getUserName(), count);
    }
}
