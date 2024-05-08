package com.meli.be_java_hisp_w26_g09.service.impl;

import static org.mockito.Mockito.doReturn;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.meli.be_java_hisp_w26_g09.dto.ProductDTO;
import com.meli.be_java_hisp_w26_g09.entity.Post;
import com.meli.be_java_hisp_w26_g09.entity.Product;
import com.meli.be_java_hisp_w26_g09.entity.Role;
import com.meli.be_java_hisp_w26_g09.entity.User;
import com.meli.be_java_hisp_w26_g09.exception.NotFoundException;
import com.meli.be_java_hisp_w26_g09.repository.IPostRepository;
import com.meli.be_java_hisp_w26_g09.repository.IUserRepository;
import com.meli.be_java_hisp_w26_g09.util.mapper.PostMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import com.meli.be_java_hisp_w26_g09.util.JsonUtil;
import org.mockito.junit.jupiter.MockitoExtension;
import com.meli.be_java_hisp_w26_g09.dto.PostForListDTO;
import com.meli.be_java_hisp_w26_g09.dto.ProductFollowedListDTO;
import com.meli.be_java_hisp_w26_g09.exception.BadRequestException;
import java.io.IOException;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class PostServiceImplTest {

    // SUT
    @Spy
    private PostServiceImpl systemUnderTest;

    @Test
    @DisplayName("Test to getFollowedPostLastTwo order by date_asc with 4 post")
    public void getPostOrderByDateAsc() {

        // Arrange
        int idUser = 1;
        String order = "date_asc";
        ProductFollowedListDTO expected = getExpectedPostOrderAsc();

        // Act
        doReturn(getFakePostTwoWeeksAgo()).when(systemUnderTest).findFollowedPostsLastTwoWeeks(idUser);
        ProductFollowedListDTO result = systemUnderTest.findFollowedPostsLastTwoWeeksSorted(idUser, order);

        // Asertions

        Assertions.assertEquals(expected.getPosts().size(), result.getPosts().size());

        List<PostForListDTO> postsExpected = expected.getPosts();
        List<PostForListDTO> postsResult   = result.getPosts();

        for (int i = 0; i < postsExpected.size(); i++) {
            PostForListDTO postExpected = postsExpected.get(i);
            PostForListDTO postResult = postsResult.get(i);
            Assertions.assertEquals(postExpected.getDate(), postResult.getDate());
        }
    }
    @Spy
    private PostServiceImpl postService;

    @Test
    @DisplayName("Test to getFollowedPostLastTwo order by date_desc with 4 post")
    public void getPostOrderByDateDesc() {

        // Arrange
        int idUser = 1;
        String order = "date_desc";
        ProductFollowedListDTO expected = getExpectedPostOrderDesc();

        // Act
        doReturn(getFakePostTwoWeeksAgo()).when(systemUnderTest).findFollowedPostsLastTwoWeeks(idUser);
        ProductFollowedListDTO result = systemUnderTest.findFollowedPostsLastTwoWeeksSorted(idUser, order);

        // Asertions

        Assertions.assertEquals(expected.getPosts().size(), result.getPosts().size());

        List<PostForListDTO> postsExpected = expected.getPosts();
        List<PostForListDTO> postsResult   = result.getPosts();

        for (int i = 0; i < postsExpected.size(); i++) {
            PostForListDTO postExpected = postsExpected.get(i);
            PostForListDTO postResult = postsResult.get(i);
            Assertions.assertEquals(postExpected.getDate(), postResult.getDate());
        }
    }

    @Test
    @DisplayName("Test to getFollowedPostLastTwoWeeaksOrder when self dependency is Empty (post)")
    public void getPostOrderAnyDependencyEmpty() {
        //Arrange
        String order = "date_asc";
        int idUser = 1;


        //Act
        doReturn(getFakePostTwoWeeksAgoEmpty()).when(systemUnderTest).findFollowedPostsLastTwoWeeks(idUser);
        ProductFollowedListDTO result = systemUnderTest.findFollowedPostsLastTwoWeeksSorted(idUser, order);
        //Assertions
        Assertions.assertTrue(result.getPosts().isEmpty());
    }



    public ProductFollowedListDTO getFakePostTwoWeeksAgoEmpty() {
        ProductFollowedListDTO emptyListPost = new ProductFollowedListDTO();
        emptyListPost.setPosts(new ArrayList<>());
        return emptyListPost;
    }

    @Test
    @DisplayName("Test findFollowedPostsLastTwoWeeksSorted with valid order asc")
    void findFollowedPostsLastTwoWeeksSortedWithvalidOrderDesc() throws IOException {
        // Arrange
        int userID = 1;
        String order = "date_desc";
        ProductFollowedListDTO expected = new ProductFollowedListDTO();
        expected.setUserId(userID);
        expected.setPosts(JsonUtil.readJsonFromFileToList("postsordered/allposts.json", PostForListDTO.class));

        // Stub the postService.findFollowedPostsLastTwoWeeks(userID) method call
        doReturn(expected).when(postService).findFollowedPostsLastTwoWeeks(userID);


        // Act
        ProductFollowedListDTO result = postService.findFollowedPostsLastTwoWeeksSorted(userID, order);


        // Assert
        assertEquals(result.getUserId(), userID);
        assertEquals(result.getPosts().get(0).getDate(), LocalDate.of(2024, 04, 30));


    }

    @Test
    @DisplayName("Test findFollowedPostsLastTwoWeeksSorted with invalid order")
    void findFollowedPostsLastTwoWeeksSortedWithInvalidOrder() throws IOException {
        // Arrange
        int userID = 1;
        String order = "invalid_order";
        ProductFollowedListDTO expected = new ProductFollowedListDTO();
        expected.setUserId(userID);
        expected.setPosts(JsonUtil.readJsonFromFileToList("postsordered/allposts.json", PostForListDTO.class));

        // Stub the postService.findFollowedPostsLastTwoWeeks(userID) method call
        doReturn(expected).when(postService).findFollowedPostsLastTwoWeeks(userID);

        // Act & Assert
        assertThrows(BadRequestException.class, () -> postService.findFollowedPostsLastTwoWeeksSorted(userID, order));
    }

    @Test
    @DisplayName("Test findFollowedPostsLastTwoWeeksSorted with valid order asc")
    void findFollowedPostsLastTwoWeeksSortedWithvalidOrderAsc() throws IOException {
        // Arrange
        int userID = 1;
        String order = "date_asc";
        ProductFollowedListDTO expected = new ProductFollowedListDTO();
        expected.setUserId(userID);
        expected.setPosts(JsonUtil.readJsonFromFileToList("postsordered/allposts.json", PostForListDTO.class));

        // Stub the postService.findFollowedPostsLastTwoWeeks(userID) method call
        doReturn(expected).when(postService).findFollowedPostsLastTwoWeeks(userID);


        // Act
        ProductFollowedListDTO result = postService.findFollowedPostsLastTwoWeeksSorted(userID, order);


        // Assert
        assertEquals(result.getUserId(), userID);
        assertEquals(result.getPosts().get(0).getDate(), LocalDate.of(2024, 04, 29));

    }


    @Mock
    IUserRepository userRepository;

    @Mock
    IPostRepository postRepository;

    @Spy
    PostMapper postMapper;

    @InjectMocks
    PostServiceImpl postServiceMock;
    @Test
    @DisplayName("Test to findFollowedPostsLastTwoWeeks to verify if this only take the last two weeks posts")
    public void getPostLastTwoWeeks(){
        // Arrange
        int idCustomer = 1;
        int idSeller = 2;
        User seller = new User(idSeller, "JaneSmith", new Role(Role.ID_SELLER, "Seller"), new ArrayList<>());
        User customer = new User(idCustomer, "JohnDoe", new Role(Role.ID_CUSTOMER, "Customer"), List.of(seller));
        when(userRepository.findById(idCustomer)).thenReturn(Optional.of(customer));
        when(postRepository.findAll()).thenReturn(getPostTwoWeeksAgoBySeller(idSeller));
        ProductFollowedListDTO expected = getPostTwoWeeksAgoBySellerExpected(idSeller);
        // Act
        ProductFollowedListDTO result = postServiceMock.findFollowedPostsLastTwoWeeks(idCustomer);
        // Asertions
        for (int i = 0; i < expected.getPosts().size(); i++) {
            Assertions.assertEquals(expected.getPosts().get(i).getPostId(), result.getPosts().get(i).getPostId());
        }
    }

    @Test
    @DisplayName("Test to findFollowedPostsLastTwoWeeks to verify a user without followeds")
    public void getPostLastTwoWeeksWithAUserwithoutFolloweds(){
        // Arrange
        int idCustomer = 1;
        User customer = new User(idCustomer, "JohnDoe", new Role(Role.ID_CUSTOMER, "Customer"), null);
        when(userRepository.findById(idCustomer)).thenReturn(Optional.of(customer));
        // Asertions
        Assertions.assertThrows(NotFoundException.class, () -> postServiceMock.findFollowedPostsLastTwoWeeks(idCustomer));
    }

    @Test
    @DisplayName("Test to findFollowedPostsLastTwoWeeks to verify a invalid user")
    public void getPostLastTwoWeeksWithInvalidUser(){
        // Arrange
        int idCustomer = 3;
        when(userRepository.findById(idCustomer)).thenReturn(Optional.empty());
        // Asertions
        Assertions.assertThrows(NotFoundException.class, () -> postServiceMock.findFollowedPostsLastTwoWeeks(3));
    }

    /**
     * Method util
     * @return Return a ProductFollowedListDTO that contain 4 LocalDates unorder
     */
    private ProductFollowedListDTO getFakePostTwoWeeksAgo() {
        ProductFollowedListDTO list = new ProductFollowedListDTO();

        PostForListDTO post1 = new PostForListDTO(null, null, LocalDate.of(2024, 12, 1), null, null, null);
        PostForListDTO post2 = new PostForListDTO(null, null, LocalDate.of(2024, 11, 2), null, null, null);
        PostForListDTO post3 = new PostForListDTO(null, null, LocalDate.of(2024, 10, 3), null, null, null);
        PostForListDTO post4 = new PostForListDTO(null, null, LocalDate.of(2024, 9, 4), null, null, null);
        ArrayList<PostForListDTO> listArr = new ArrayList<PostForListDTO>();
        listArr.add(post1);
        listArr.add(post2);
        listArr.add(post3);
        listArr.add(post4);
        list.setPosts(listArr);
        return list;
    }

    private ProductFollowedListDTO getPostTwoWeeksAgoBySellerExpected(int idSeller) {
        ProductFollowedListDTO list = new ProductFollowedListDTO();

        PostForListDTO post1 = new PostForListDTO(idSeller, 3, LocalDate.of(2024, 5, 3), new ProductDTO(), 1, 100.0);
        PostForListDTO post2 = new PostForListDTO(idSeller, 2, LocalDate.of(2024, 5, 2), new ProductDTO(), 1, 100.0);
        PostForListDTO post3 = new PostForListDTO(idSeller, 1, LocalDate.of(2024, 5, 1), new ProductDTO(), 1, 100.0);
        ArrayList<PostForListDTO> listArr = new ArrayList<PostForListDTO>();
        listArr.add(post1);
        listArr.add(post2);
        listArr.add(post3);
        list.setPosts(listArr);
        return list;
    }

    private List<Post> getPostTwoWeeksAgoBySeller(int idSeller) {
        Post post1 = new Post(1, idSeller, LocalDate.of(2024, 5, 1), new Product(1,"test1","a","b","azul",""), 1, 100.0, false, null);
        Post post2 = new Post(2, idSeller, LocalDate.of(2024, 5, 2), new Product(2,"test2","a","b","azul",""), 1, 100.0,false, null);
        Post post3 = new Post(3, idSeller, LocalDate.of(2024, 5, 3), new Product(3,"test3","a","b","azul",""), 1, 100.0,false, null);
        Post post4 = new Post(4, idSeller, LocalDate.of(2024, 4, 4), new Product(4,"test4","a","b","azul",""), 1, 100.0,false, null);
        List<Post> listPosts = new ArrayList();
        listPosts.add(post1);
        listPosts.add(post2);
        listPosts.add(post3);
        listPosts.add(post4);
        return listPosts;
    }



    private ProductFollowedListDTO getExpectedPostOrderAsc() {
        ProductFollowedListDTO list = new ProductFollowedListDTO();



        PostForListDTO post1 = new PostForListDTO(null, null, LocalDate.of(2024, 9, 4), null, null, null);
        PostForListDTO post2 = new PostForListDTO(null, null, LocalDate.of(2024, 10, 3), null, null, null);
        PostForListDTO post3 = new PostForListDTO(null, null, LocalDate.of(2024, 11, 2), null, null, null);
        PostForListDTO post4 = new PostForListDTO(null, null, LocalDate.of(2024, 12, 1), null, null, null);
        list.setPosts(List.of(post1, post2, post3, post4));

        return list;
    }

    private ProductFollowedListDTO getExpectedPostOrderDesc() {
        ProductFollowedListDTO list = new ProductFollowedListDTO();

        PostForListDTO post1 = new PostForListDTO(null, null, LocalDate.of(2024, 12, 1), null, null, null);
        PostForListDTO post2 = new PostForListDTO(null, null, LocalDate.of(2024, 11, 2), null, null, null);
        PostForListDTO post3 = new PostForListDTO(null, null, LocalDate.of(2024, 10, 3), null, null, null);
        PostForListDTO post4 = new PostForListDTO(null, null, LocalDate.of(2024, 9, 4), null, null, null);

        list.setPosts(List.of(post1, post2, post3, post4));

        return list;
    }

}
