package org.example.g14.service;

import org.example.g14.dto.response.PostResponseDto;
import org.example.g14.exception.OrderInvalidException;
import org.example.g14.model.Product;
import org.example.g14.model.User;
import org.example.g14.repository.PostRepository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.example.g14.model.Post;
import org.example.g14.utils.PostList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Comparator;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PostServiceTest {

    @Mock
    IUserServiceInternal iUserServiceInternal;

    @Mock
    PostRepository repository;

    @InjectMocks
    PostService service;

    private void initializeFeature0005() {
        MockitoAnnotations.openMocks(this);

        // arrange
        int sellerId = 1;
        User user = new User(2, "John Doe", List.of(), List.of(1));

        // act
        when(iUserServiceInternal.searchUserIfExists(user.getId())).thenReturn(user);
        when(repository.findAllByUser(sellerId)).thenReturn(List.of());
    }

    @ParameterizedTest
    @ValueSource(strings = {"date_asc", "date_desc"})
    @DisplayName("T-0005: US-0009 el tipo de ordenamiento por fecha existe")
    public void getPostsFromFollowedTestOk(String order){
        initializeFeature0005();
        List<PostResponseDto> result = service.getPostsFromFollowed(2, order);

        // assert
        Assertions.assertNotNull(result);
    }

    @Test
    @DisplayName("T-0005: US-0009 el tipo de ordenamiento por fecha no existe")
    public void getPostsFromFollowedTestBadRequest() {
        initializeFeature0005();

        // assert
        Assertions.assertThrows(OrderInvalidException.class, () -> service.getPostsFromFollowed(2, "test"));
    }

    @Test
    @DisplayName("T-0006: US-0009 el ordenamiento con date_desc está correcto")
    public void getPostsFromFollowedDescOk(){
        //arrange
        String order = "date_desc";
        List<LocalDate> dateDescExpected = PostList.getPostResponse().stream()
                .map(Post::getDate)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        //act y assert
        getPostsFromFollowedOk(order, dateDescExpected);
    }

    @Test
    @DisplayName("T-0006: US-0009 el ordenamiento con date_desc está correcto\"")
    public void getPostsFromFollowedAscOk(){
        //arrange
        String order = "date_asc";
        List<LocalDate> dateAscExpected = PostList.getPostResponse().stream()
                .map(Post::getDate)
                .sorted()
                .collect(Collectors.toList());
        //act y assert
        getPostsFromFollowedOk(order, dateAscExpected);
    }

    private void getPostsFromFollowedOk(String order, List<LocalDate> expectedDates){
        //arrange
        int sellerId= 1;
        int userId = 2;

        User user = new User(userId,"Pedro", new ArrayList<>(), List.of(1));

        //act
        when(iUserServiceInternal.searchUserIfExists(userId)).thenReturn(user);
        when(repository.findAllByUser(sellerId)).thenReturn(PostList.getPostResponse());

        List<LocalDate> obtainedDates = service.getPostsFromFollowed(userId, order).stream()
                .map(PostResponseDto::getDate)
                .collect(Collectors.toList());

        //assert
        assertEquals(expectedDates, obtainedDates);
    }

    @Test
    @DisplayName("T-0008: US-0006 verificar que traigan post de las ultimas 2 semanas")
    public void testGetPostsFromFollowedWithinLastTwoWeeks() {
        // Arrange
        int userId = 1;
        int sellerId = 2;

        User user = new User();
        user.setId(userId);
        List<Integer> followedSellers = new ArrayList<>();
        followedSellers.add(sellerId);
        user.setIdFollows(followedSellers);
        when(iUserServiceInternal.searchUserIfExists(userId)).thenReturn(user);


        Post postWithinLastTwoWeeks = new Post();
        postWithinLastTwoWeeks.setId(1);
        postWithinLastTwoWeeks.setIdUser(sellerId);
        postWithinLastTwoWeeks.setDate(LocalDate.now().minusDays(7)); // Within last two weeks
        postWithinLastTwoWeeks.setProduct(new Product());

        Post postOutsideLastTwoWeeks = new Post();
        postOutsideLastTwoWeeks.setId(2);
        postOutsideLastTwoWeeks.setIdUser(sellerId);
        postOutsideLastTwoWeeks.setDate(LocalDate.now().minusDays(15)); // Outside last two weeks
        postOutsideLastTwoWeeks.setProduct(new Product());

        List<Post> posts = List.of(postWithinLastTwoWeeks, postOutsideLastTwoWeeks);

        when(repository.findAllByUser(2)).thenReturn(posts);

        // Act
        List<PostResponseDto> result = service.getPostsFromFollowed(userId, null);

        // Assert
        assertEquals(1, result.size());
        assertEquals(postWithinLastTwoWeeks.getId(), result.get(0).getPost_id());
    }
}
