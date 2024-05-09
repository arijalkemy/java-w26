package org.example.social_meli.services.impl;

import org.example.social_meli.dto.FollowListDTO;
import org.example.social_meli.dto.UserDTO;
import org.example.social_meli.dto.UserResponseDTO;
import org.example.social_meli.exceptions.BadRequestException;
import org.example.social_meli.repository.IProductRepository;
import org.example.social_meli.repository.IUserRepository;
import org.example.social_meli.services.IProductService;
import org.example.social_meli.services.IUserService;
import org.example.social_meli.model.Post;
import org.example.social_meli.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.Collections;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)

public class ProductServiceImplTest {

    @Mock
    IProductService iProductService;

    @Mock
    IProductRepository productRepository;

    @Mock
    IUserRepository userRepository;

    @Mock
    IUserService userService;

    @InjectMocks
    ProductServiceImpl productService;

    private UserResponseDTO userResponseDTO;
    private FollowListDTO followListDTO;
    private List<Post> allPosts;

    @BeforeEach
    public void setup(){
        UserDTO userDTO = new UserDTO(1, "");
        userResponseDTO = new UserResponseDTO(
                1, "", List.of(userDTO)
        );
        followListDTO = new FollowListDTO(
                1, Collections.emptyList()
        );

        // setup para US 9
        allPosts = new ArrayList<>();
        Product product1 = new Product(1, "product A", "Type A", "Brand A", "Blue", "note");
        LocalDate postLocalDate1 = LocalDate.of(2024, 5, 6);
        Post post1 = new Post(1, 2, postLocalDate1, product1, 1, 12000.0);

        Product product2 = new Product(2, "product B", "Type B", "Brand B", "Blue", "note");
        LocalDate postLocalDate2 = LocalDate.of(2024, 5, 7);
        Post post2 = new Post(2, 2, postLocalDate2, product2, 1, 12000.0);

        allPosts.add(post1);
        allPosts.add(post2);
    }

    @Test
    @DisplayName("Verificar que el tipo de ordenamiento por fecha exista (US-0009)")
    public void getOrderedSellersPostsFollowedByUserExistenceExceptionTest(){
        //Arrange
        Integer id = 1;
        String orderBy = "wrong_input";

        //Act
        when(userService.getFollowedById(anyInt())).thenReturn(userResponseDTO);
        when(iProductService.getSellersPostsFollowedByUser(id)).thenReturn(followListDTO);
        when(iProductService.getAllPosts()).thenReturn(List.of());

        //Assert
        assertThrows(
                BadRequestException.class,
                () -> productService.getOrderedSellersPostsFollowedByUser(id, orderBy)
        );
    }

    @Test
    @DisplayName("Verificar que el tipo de ordenamiento por fecha exista (US-0009) ASC")
    public void getAscOrderedSellersPostsFollowedByUserExistenceTest(){
        //Arrange
        Integer id = 1;
        String orderBy = "date_asc";

        when(userService.getFollowedById(anyInt())).thenReturn(userResponseDTO);
        when(iProductService.getSellersPostsFollowedByUser(id)).thenReturn(followListDTO);
        when(iProductService.getAllPosts()).thenReturn(List.of());

        //Act
        FollowListDTO actual = productService.getOrderedSellersPostsFollowedByUser(id, orderBy);

        //Assert
        assertEquals(followListDTO, actual);
    }

    @Test
    @DisplayName("Verificar que el tipo de ordenamiento por fecha exista (US-0009) DESC")
    public void getDescOrderedSellersPostsFollowedByUserExistenceTest(){
        //Arrange
        Integer id = 1;
        String orderBy = "date_desc";

        when(userService.getFollowedById(anyInt())).thenReturn(userResponseDTO);
        when(iProductService.getSellersPostsFollowedByUser(id)).thenReturn(followListDTO);
        when(iProductService.getAllPosts()).thenReturn(List.of());

        //Act
        FollowListDTO actual = productService.getOrderedSellersPostsFollowedByUser(id, orderBy);

        //Assert
        assertEquals(followListDTO, actual);
    }

    @DisplayName("Prueba orden ascendente de posts")
    @Test
    public void getSellersPostsFollowedByUserDescTest() {
        //Arrange
        Integer id = 1;
        String orderBy = "date_asc";

        // Configuración de usuario a seguir
        UserResponseDTO userResponseDTO = new UserResponseDTO(id, "Juan", List.of(new UserDTO(2, "Pedro"), new UserDTO(3, "Andres")));

        when(userService.getFollowedById(id)).thenReturn(userResponseDTO);
        when(productRepository.getAllPosts()).thenReturn(allPosts);

        //Act
        FollowListDTO result = productService.getOrderedSellersPostsFollowedByUser(id, orderBy);

        // ASSERTIONS
        assertEquals(2, result.getPost().size());
        assertEquals(1, result.getPost().get(0).getPost_id()); // post1 deberia ser el primero
        assertEquals(2, result.getPost().get(1).getPost_id()); // post2 deberia ser el segundo
    }

    @DisplayName("Prueba orden descendente de posts")
    @Test
    public void getSellersPostsFollowedByUserAscTest() {
        //Arrange
        Integer id = 1;
        String orderBy = "date_desc";

        // Configuración de usuario a seguir
        UserResponseDTO userResponseDTO = new UserResponseDTO(id, "Juan", List.of(new UserDTO(2, "Pedro"), new UserDTO(3, "Andres")));

        when(userService.getFollowedById(id)).thenReturn(userResponseDTO);
        when(productRepository.getAllPosts()).thenReturn(allPosts);
        //Act
        FollowListDTO result = productService.getOrderedSellersPostsFollowedByUser(id, orderBy);

        // ASSERTIONS
        assertEquals(2, result.getPost().size());
        assertEquals(2, result.getPost().get(0).getPost_id()); // post2 deberia ser el primero
        assertEquals(1, result.getPost().get(1).getPost_id()); // post1 deberia ser el segundo
    }

    @DisplayName("Prueba que no traiga posts de mas de dos semanas")
    @Test
    public void getSellersPostsFollowedByUserTwoWeeksTest() {
        //Arrange
        Integer id = 1;

        // Se prepara el test de mas de 2 semanas
        Product product3 = new Product(3, "product C", "Type C", "Brand C", "Blue", "note");
        LocalDate threeWeeksAgoDate= LocalDate.now().minusWeeks(3);
        Post postThreeWeeksAgo = new Post(3, 2, threeWeeksAgoDate, product3, 1, 12000.0);
        allPosts.add(postThreeWeeksAgo);

        // Configuración de usuario a seguir
        UserResponseDTO userResponseDTO = new UserResponseDTO(id, "Juan", List.of(new UserDTO(2, "Pedro"), new UserDTO(3, "Andres")));

        when(userService.getFollowedById(1)).thenReturn(userResponseDTO);
        when(productRepository.getAllPosts()).thenReturn(allPosts);

        //Act
        FollowListDTO result = productService.getSellersPostsFollowedByUser(id);

        // ASSERTIONS
        assertEquals(2, result.getPost().size()); //se verifica que solo existan dos posts
        assertNotEquals(3, result.getPost().get(0).getPost_id());// se verifica que ninguno tenga el id 3
        assertNotEquals(3, result.getPost().get(1).getPost_id());
    }

    @DisplayName("verifica el caso de un usuario sin seguidos")
    @Test
    public void getSellersPostsFollowedByUserWithoutFollowedTest() {
        //Arrange
        Integer idUserNoFolloweds = 4;

        // Configuración de usuario a seguir
        UserResponseDTO userResponseDTO = new UserResponseDTO(idUserNoFolloweds, "Juan", List.of());

        when(userService.getFollowedById(idUserNoFolloweds)).thenReturn(userResponseDTO);
        when(productRepository.getAllPosts()).thenReturn(allPosts);
        //Act
        FollowListDTO result = productService.getSellersPostsFollowedByUser(idUserNoFolloweds);

        // ASSERTIONS
        assertEquals(0, result.getPost().size());
    }

}
