package com.example.sprint1.service;

import com.example.sprint1.dto.PostForListDto;
import com.example.sprint1.dto.PostDto;
import com.example.sprint1.dto.ProductDto;
import com.example.sprint1.exception.BadRequestException;
import com.example.sprint1.model.Post;
import com.example.sprint1.model.Product;
import com.example.sprint1.model.User;
import com.example.sprint1.repository.IUserRepository;
import com.example.sprint1.repository.PostRepositoryImpl;
import com.fasterxml.jackson.databind.DeserializationFeature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;

@ExtendWith(MockitoExtension.class)
public class PostServiceTest {

    @Mock
    PostRepositoryImpl postRepository;
    @Mock
    IUserRepository userRepository;


    @InjectMocks
    PostServiceImpl postService;

    /**
     * T-0005
     * This test case tests the method selectIfOrderFollowedList of the PostService class.
     * It tests the value of variable "order".
     * The test case uses a mock UserRepository and a mock PostRepository to provide the necessary data for the test.
     */

    @ParameterizedTest
    @DisplayName("Test Valid Order")
    @MethodSource("com.example.sprint1.util.Utils#userProvider")
    public void testFollowedListSortedByDate_ValidOrder(List<User> users) {
        // Arrange
        Integer userId = 3;
        String order = "date_asc";
        // Mock the necessary dependencies
        Mockito.when(userRepository.getUserById(userId)).thenReturn(users.stream().filter(u -> u.getId().equals(userId)).findFirst());
        Mockito.when(postRepository.getResentPost(anyInt())).thenReturn(new ArrayList<>()); //Return something

        // Act
        List<PostForListDto> result = postService.selectIfOrderFollowedList(userId, order);

        // Assert
        assertNotNull(result);
        assertTrue(result.stream()
                .map(PostForListDto::getDate)
                .allMatch(date -> LocalDate.parse(date, DateTimeFormatter.ofPattern("dd-MM-yyyy")) != null));
    }

    /**
     * T-0005
     * This test case tests the method selectIfOrderFollowedList of the PostService class.
     * It tests the value of variable "order" when isn't valid.
     * The test case uses a BadRequestException to verify the invalid value.
     */
    @ParameterizedTest
    @DisplayName("Test Invalid Order")
    @MethodSource("com.example.sprint1.util.Utils#userProvider")
    public void testFollowedListSortedByDate_InvalidOrder(List<User> users) {
        // Arrange
        Integer userId = 3;
        String order = "invalid_order";

        // Act and Assert
        assertThrows(BadRequestException.class, () -> postService.selectIfOrderFollowedList(userId, order));
    }


    /**
     * T-0006
     * This test case tests the method selectIfOrderFollowedList of the PostService class.
     * It tests the functionality of ordering the posts by date in ascending order.
     * The test case uses a mock UserRepository and a mock PostRepository to provide the necessary data for the test.
     */
    @Test
    @DisplayName("Test order post by date asc")
    public void testFollowedListSortedByDateAsc() {
        // arrange
        // create two products
        Product product1 = new Product(1, "Product 1", "Type 1", "Brand 1", "Color 1", "Notes 1");
        Product product2 = new Product(2, "Product 2", "Type 2", "Brand 2", "Color 2", "Notes 2");
        // create a list of expected posts
        List<Post> expectedPosts = List.of(
                new Post(1, 2, "19-12-2022", 1, 100.0, product1, false, 0.0),
                new Post(2, 2, "20-12-2022", 2, 200.0, product2, false, 0.0)
        );

        // act

        // mock the UserRepository and PostRepository methods
        Mockito.when(userRepository.getUserById(1)).thenReturn(Optional.of(new User(1, "User 1", Set.of(2), Set.of(2), Set.of(1))));
        Mockito.when(postRepository.getResentPost(anyInt())).thenReturn(expectedPosts);
        // call the method under test
        List<PostForListDto> actualPosts = postService.selectIfOrderFollowedList(1, "date_asc");
        // convert expectedPosts to PostForListDto
        ObjectMapper mapper = new ObjectMapper();
        List<PostForListDto> expectedPostsForListDto = expectedPosts.stream()
                .map(post -> mapper.convertValue(post, PostForListDto.class))
                .collect(Collectors.toList());
        // assert
        // check that the actual list has the same size as the expected list
        Assertions.assertEquals(expectedPosts.size(), actualPosts.size());
        // check that the dates are in ascending order
        for (int i = 0; i < expectedPostsForListDto.size(); i++) {
            Assertions.assertEquals(expectedPostsForListDto.get(i).getDate(), actualPosts.get(i).getDate());
        }
    }
    /**
     * T-0006
     * This test case tests the method selectIfOrderFollowedList of the PostService class.
     * It tests the functionality of ordering the posts by date in descending order.
     * The test case uses a mock UserRepository and a mock PostRepository to provide the necessary data for the test.
     */
    @Test
    @DisplayName("Test order post by date desc")
    public void testFollowedListSortedByDateDesc() {
        // arrange
        // create two products
        Product product1 = new Product(1, "Product 1", "Type 1", "Brand 1", "Color 1", "Notes 1");
        Product product2 = new Product(2, "Product 2", "Type 2", "Brand 2", "Color 2", "Notes 2");
        // create a list of expected posts
        List<Post> expectedPosts = List.of(
                new Post(1, 2, "20-12-2022", 1, 100.0, product1, false, 0.0),
                new Post(2, 2, "19-12-2022", 2, 200.0, product2, false, 0.0)
        );

        // act
        // mock the UserRepository and PostRepository methods
        Mockito.when(userRepository.getUserById(1)).thenReturn(Optional.of(new User(1, "User 1", Set.of(2), Set.of(2), Set.of(1))));
        Mockito.when(postRepository.getResentPost(anyInt())).thenReturn(expectedPosts);
        // call the method under test
        List<PostForListDto> actualPosts = postService.selectIfOrderFollowedList(1, "date_desc");
        // convert expectedPosts to PostForListDto
        ObjectMapper mapper = new ObjectMapper();
        List<PostForListDto> expectedPostsForListDto = expectedPosts.stream()
                .map(post -> mapper.convertValue(post, PostForListDto.class))
                .collect(Collectors.toList());
        // assert
        // check that the actual list has the same size as the expected list
        Assertions.assertEquals(expectedPosts.size(), actualPosts.size());
        // check that the dates are in descending order
        for (int i = 0; i < expectedPostsForListDto.size(); i++) {
            Assertions.assertEquals(expectedPostsForListDto.get(i).getDate(), actualPosts.get(i).getDate());
        }
    }

    /**
     * T-0008
     * This test case tests the method selectIfOrderFollowedList of the PostService class.
     * It tests the functionality of last two week posts.
     * The test case uses a mock UserRepository and a mock PostRepository to provide the necessary data for the test.
     */
    @ParameterizedTest
    @DisplayName("Test last two week posts")
    @MethodSource("com.example.sprint1.util.Utils#userProvider")
    public void testLastTwoWeekPosts(List<User> users) {
        // Arrange
        LocalDate today = LocalDate.now();
        LocalDate twoWeeksAgo = today.minusWeeks(2);

        Integer userId = 4;
        Product product1 = new Product(6, "Product Q", "Type S", "Brand Epsilon", "Yellow", "This is product Q.");
        PostForListDto post1 = new PostForListDto(6, 3, "08-05-2024", 3, 15.07, product1);

        Product product2 = new Product(7, "Product W", "Type T", "Brand Blue Label", "Blue", "This is product W.");
        PostForListDto post2 = new PostForListDto(7, 3, "07-05-2024", 1, 1005.07, product2);

        List<PostForListDto> postsListDto = List.of(post2, post1);
        List<Post> expectedPosts = List.of(
                new Post(6, 3, "08-05-2024", 3, 15.07, product1, false, 0.0),
                new Post(7, 3, "07-05-2024", 1, 1005.07, product2, false, 0.0)
        );

        User user = users.stream().filter(u -> u.getId().equals(userId)).findFirst().orElse(null);

        // Act

        Mockito.when(userRepository.getUserById(userId)).thenReturn(Optional.ofNullable(user));
        Mockito.when(postRepository.getResentPost(3)).thenReturn(expectedPosts);

        List<PostForListDto> result = postService.selectIfOrderFollowedList(userId, null);

        // Assert
        Assertions.assertEquals(postsListDto.size(), result.size());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        for (int i = 0; i < postsListDto.size(); i++) {
            LocalDate dateToValidate = LocalDate.parse(result.get(i).getDate(), formatter);
            assertThat(dateToValidate).isAfterOrEqualTo(twoWeeksAgo).isBeforeOrEqualTo(today);

        }

    }

}
