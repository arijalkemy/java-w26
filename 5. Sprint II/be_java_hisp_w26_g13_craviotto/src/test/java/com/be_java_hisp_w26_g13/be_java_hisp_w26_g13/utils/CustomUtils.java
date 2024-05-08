package com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.utils;

import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.dto.*;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.entity.Post;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.entity.Product;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.entity.User;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.entity.UserMinimalData;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.exception.BadRequestException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CustomUtils {
    public static final LocalDate fourteenDaysAgo = LocalDate.now().minusDays(13);
    public static final LocalDate fifteenDaysAgo = LocalDate.now().minusDays(14);
    public static final LocalDate tomorrow = LocalDate.now().plusDays(1);

    /**
     * @return a mocked vendor with userId = 1
     * followed by userId = 15
     */
    public static User newMockedVendor() {
        User mockedVendor = new User(1, "Alice Morrison");
        UserMinimalData minimalUser = new UserMinimalData(15, "Oscar Lee");
        UserMinimalData minimalUserTwo = new UserMinimalData(16, "Brenda Jhonson");

        mockedVendor.setFollowers(new ArrayList<>(List.of(minimalUser, minimalUserTwo)));
        mockedVendor.setPosts(List.of(1, 2));
        return mockedVendor;
    }

    /**
     * @return a mocked vendor with a list of two mocked posts
     */
    public static User newMockedVendorWithMockedPosts() {
        User mockedVendor = newMockedVendor();
        mockedVendor.setPosts(List.of(1, 2));
        return mockedVendor;
    }

    /**
     * @return a mocked User with userId = 15
     * following userId = 15
     */
    public static User newMockedUser() {
        User mockedUser = new User(15, "Oscar Lee");
        UserMinimalData minimalVendor = new UserMinimalData(1, "Alice Morrison");
        mockedUser.setFollowed(new ArrayList<>(List.of(minimalVendor)));
        return mockedUser;
    }

    /**
     * @return a mocked User with userId = 15
     * following userId = 15
     */
    public static User newMockedUserTwo() {
        User mockedUser = new User(16, "Brenda Jhonson");
        UserMinimalData minimalVendor = new UserMinimalData(1, "Alice Morrison");
        mockedUser.setFollowed(new ArrayList<>(List.of(minimalVendor, new UserMinimalData(2, "Bob Marley"))));
        return mockedUser;
    }

    public static ResponseUserFollowersDTO newResponseUserFollowersDTO(String order) {
        ResponseUserFollowersDTO responseUserFollowersDTO = new ResponseUserFollowersDTO(1, "Alice Morrison",
                new ArrayList<>(List.of(new UserDTO(15, "Oscar Lee"),
                        new UserDTO(16, "Brenda Jhonson"))
                )
        );

        if (order.equals("name_asc")) {
            responseUserFollowersDTO.getFollowers().sort(Comparator.comparing(UserDTO::getUserName));
        } else if (order.equals("name_desc")) {
            responseUserFollowersDTO.getFollowers().sort(Comparator.comparing(UserDTO::getUserName).reversed());
        }

        return responseUserFollowersDTO;
    }

    public static ResponseFollowedByUserDTO newResponseFollowedByUserDTO(String order) {
        ResponseFollowedByUserDTO responseFollowedByUserDTO = new ResponseFollowedByUserDTO(16, "Brenda Jhonson",
                new ArrayList<>(List.of(new UserDTO(1, "Alice Morrison"),
                        new UserDTO(2, "Bob Marley"))
                )
        );

        if (order.equals("name_asc")) {
            responseFollowedByUserDTO
                    .getFollowed().sort(Comparator.comparing(UserDTO::getUserName));
        } else if (order.equals("name_desc")) {
            responseFollowedByUserDTO.getFollowed().sort(Comparator.comparing(UserDTO::getUserName).reversed());
        }

        return responseFollowedByUserDTO;
    }

    public static Product newMockedProduct() {
        return new Product(1,
                "HyperX Cloud II",
                "Headset",
                "HyperX",
                "Red",
                "Excellent noise canceling");
    }

    public static ProductDTO newMockedProductDTO() {
        return new ProductDTO(1,
                "HyperX Cloud II",
                "Headset",
                "HyperX",
                "Red",
                "Excellent noise canceling");
    }

    /**
     * @return a list of post for vendor userId = 1
     */
    public static List<Post> newMockedFollowedVendorPostList() {
        User mockedVendor = newMockedVendor();
        Product product = newMockedProduct();

        Post beforeRangePost = new Post(1, mockedVendor.getUserId(), fifteenDaysAgo, product, 1, 3000.0);
        Post firstPost = new Post(2, mockedVendor.getUserId(), fourteenDaysAgo, product, 3, 2500.0);
        Post todayPost = new Post(3, mockedVendor.getUserId(), LocalDate.now(), product, 2, 2000.0);
        Post tomorrowPost = new Post(4, mockedVendor.getUserId(), tomorrow, product, 1, 3000.0);
        List<Post> mockedFollowedVendorsPostList = new ArrayList<>();

        mockedFollowedVendorsPostList.add(beforeRangePost);
        mockedFollowedVendorsPostList.add(firstPost);
        mockedFollowedVendorsPostList.add(todayPost);
        mockedFollowedVendorsPostList.add(tomorrowPost);
        return mockedFollowedVendorsPostList;
    }

    public static PostsByFollowedUsersDTO newMockedFollowedVendorPostAsDtoList(String order) {
        List<Post> mockedPostList = CustomUtils.newMockedFollowedVendorPostList();
        mockedPostList = mockedPostList.stream().filter(p -> p.getDate().isAfter(fifteenDaysAgo) && p.getDate().isBefore(tomorrow)).toList();
        List<PostDTO> followedVendorsPostList = new ArrayList<>();

        for(Post post : mockedPostList){
            ProductDTO product = new ProductDTO(post.getProduct().getProductId(), post.getProduct().getProductName(),
                    post.getProduct().getType(),post.getProduct().getBrand(),
                    post.getProduct().getColor(), post.getProduct().getNotes());
            followedVendorsPostList.add(new PostDTO(post.getPostId(), post.getUserId(),
                    post.getDate(), product, post.getCategory(), post.getPrice()));
        }

        if (order.equals("date_asc")) {
            followedVendorsPostList.sort(Comparator.comparing(PostDTO::getDate));
        } else if (order.equals("date_desc")) {
            followedVendorsPostList.sort(Comparator.comparing(PostDTO::getDate).reversed());
        }
        return new PostsByFollowedUsersDTO(15, followedVendorsPostList);
    }
}
