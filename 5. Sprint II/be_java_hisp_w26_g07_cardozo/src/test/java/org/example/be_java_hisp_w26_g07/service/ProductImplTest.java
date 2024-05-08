package org.example.be_java_hisp_w26_g07.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.be_java_hisp_w26_g07.dto.products.PostDto;
import org.example.be_java_hisp_w26_g07.dto.products.PostRequestDto;
import org.example.be_java_hisp_w26_g07.dto.products.ProductDto;
import org.example.be_java_hisp_w26_g07.entity.Post;
import org.example.be_java_hisp_w26_g07.entity.User;
import org.example.be_java_hisp_w26_g07.exception.BadRequestException;
import org.example.be_java_hisp_w26_g07.exception.NotFoundException;
import org.example.be_java_hisp_w26_g07.repository.interfaces.IUserRepository;
import org.example.be_java_hisp_w26_g07.utils.GeneratorDataTest;
import org.example.be_java_hisp_w26_g07.utils.UserMessageError;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.atLeast;

@ExtendWith(MockitoExtension.class)
class ProductImplTest {
    @Mock
    private IUserRepository iUserRepository;

    @InjectMocks
    private ProductImpl productImpl;

    @DisplayName("T-0005: Verificar que el tipo de ordenamiento por fecha exista (US-0009) date_asc")
    @Test
    void verifyNormalContinuityOfSortingByDateAscTest() {
        // Arrange
        String order = "date_asc";
        Integer userID = 2;
        List<Post> posts = GeneratorDataTest.getListOfSellersLastTwoWeeks();
        User user = GeneratorDataTest.findUsers().get(1);
        when(iUserRepository.findById(userID)).thenReturn(user);
        when(iUserRepository.findProductByFollow(user)).thenReturn(posts);

        // Act
        productImpl.findProductByFollow(userID, order);
        // Assert
        verify(iUserRepository, atLeast(1)).findById(any(Integer.class));
    }

    @DisplayName("T-0005: Verificar que el tipo de ordenamiento por fecha exista (US-0009) date_desc")
    @Test
    void verifyNormalContinuityOfSortingByDateDescTest() {
        // Arrange
        String order = "date_desc";
        Integer userID = 2;
        List<Post> posts = GeneratorDataTest.getListOfSellersLastTwoWeeks();
        User user = GeneratorDataTest.findUsers().get(1);
        when(iUserRepository.findById(userID)).thenReturn(user);
        when(iUserRepository.findProductByFollow(user)).thenReturn(posts);

        // Act
        productImpl.findProductByFollow(userID, order);
        // Assert
        verify(iUserRepository, atLeast(1)).findById(any(Integer.class));
    }

    @DisplayName("T-0005: Verificar que el tipo de ordenamiento por fecha no se permita por tipo de orden incorrecto")
    @Test
    void verifyThatTheProcessIsNotExecutedDueToBadDataType() {
        // Arrange
        String order = "incorrect_data";
        Integer userID = 2;
        // Act - Assert
        assertThrows(BadRequestException.class, () -> productImpl.findProductByFollow(userID, order));
    }

    @Test
    @DisplayName("T-0006: Valor de 'orden' no es correcto")
    void findProductByFollowBadOrder() {
        // Given - Arrange
        // When - Act
        // Then - Assert
        BadRequestException thrown = Assertions.assertThrows(
                BadRequestException.class,
                () -> productImpl.findProductByFollow(3, "bad_order")
        );
        Assertions.assertEquals(UserMessageError.LIST_CLIENTE_ORDER.getMessage(), thrown.getMessage());
    }

    @Test
    @DisplayName("T-0006: El usuario no existe")
    void findProductByFollowUserDoesNotExist() {
        // Given - Arrange
        Mockito.when(iUserRepository.findById(111)).thenReturn(null);
        // When - Act
        // Then - Assert
        NotFoundException thrown = Assertions.assertThrows(
                NotFoundException.class,
                () -> productImpl.findProductByFollow(111, "date_asc")
        );
        Assertions.assertEquals(UserMessageError.USER_NOT_FOUND.getMessage(111), thrown.getMessage());
    }

    @Test
    @DisplayName("T-0006: La lista de posts esta vacia para ese usuario")
    void findProductByFollowEmptyPosts() {
        // Given - Arrange
        User seller = GeneratorDataTest.getUserCustomId(1, true);
        Mockito.when(iUserRepository.findById(1)).thenReturn(seller);
        Mockito.when(iUserRepository.findProductByFollow(seller)).thenReturn(new ArrayList<>());
        String expectedErrMsg = "No se encontraron publicaciones para las ultimas dos semanas.";
        // When - Act
        // Then - Assert
        NotFoundException thrown = Assertions.assertThrows(
                NotFoundException.class,
                () -> productImpl.findProductByFollow(1, "date_asc")
        );
        Assertions.assertEquals(expectedErrMsg, thrown.getMessage());
    }

    @Test
    @DisplayName("T-0006: Lista de posts ordenada ascendente")
    void findProductByFollowAsc() {
        // Given - Arrange
        ObjectMapper mapper = new ObjectMapper();
        User seller = GeneratorDataTest.getUserCustomId(1, true);
        Mockito.when(iUserRepository.findById(1)).thenReturn(seller);
        List<Post> mockPosts = GeneratorDataTest.getListOfSellersLastTwoWeeks();
        Mockito.when(iUserRepository.findProductByFollow(seller)).thenReturn(mockPosts);
        List<Post> orderedMockPosts = mockPosts.stream()
                .sorted(Comparator.comparing(Post::getDate)).toList();
        List<PostDto> orderedMockPostDtos = orderedMockPosts.stream()
                .map(mp -> mapper.convertValue(mp, PostDto.class))
                .toList();
        // When - Act
        List<PostDto> response = productImpl.findProductByFollow(1, "date_asc");
        // Then - Assert
        org.assertj.core.api.Assertions.assertThat(response)
                .usingRecursiveFieldByFieldElementComparator()
                .containsExactlyElementsOf(orderedMockPostDtos);
    }

    @Test
    @DisplayName("T-0006: Lista de posts ordenada descendente")
    void findProductByFollowDesc() {
        // Given - Arrange
        ObjectMapper mapper = new ObjectMapper();
        User seller = GeneratorDataTest.getUserCustomId(1, true);
        Mockito.when(iUserRepository.findById(1)).thenReturn(seller);
        List<Post> mockPosts = GeneratorDataTest.getListOfSellersLastTwoWeeks();
        Mockito.when(iUserRepository.findProductByFollow(seller)).thenReturn(mockPosts);
        List<Post> orderedMockPosts = mockPosts.stream()
                .sorted(Comparator.comparing(Post::getDate).reversed()).toList();
        List<PostDto> orderedMockPostDtos = orderedMockPosts.stream()
                .map(mp -> mapper.convertValue(mp, PostDto.class))
                .toList();
        // When - Act
        List<PostDto> response = productImpl.findProductByFollow(1, "date_desc");
        // Then - Assert
        org.assertj.core.api.Assertions.assertThat(response)
                .usingRecursiveFieldByFieldElementComparator()
                .containsExactlyElementsOf(orderedMockPostDtos);
    }



    @Test
    @DisplayName("T-0008 Verificar que la consulta de publicaciones realizadas en las últimas dos semanas de un determinado vendedor sean efectivamente de las últimas dos semanas. (US-0006)")
    void findProductByFollowTest() {

        //Arrange
        Integer userId = 1;
        User userMock = GeneratorDataTest.findUsers().get(0);
        List<Post> postMockList =GeneratorDataTest.getListOfSellersLastTwoWeeks();
        ObjectMapper mapper = new ObjectMapper();
        List<PostDto> expected= mapper.convertValue(postMockList, new TypeReference<List<PostDto>>() {});
        when(iUserRepository.findById(userId)).thenReturn(userMock);
        when(iUserRepository.findProductByFollow(userMock)).thenReturn(postMockList);

        //Act
        List<PostDto> output = productImpl.findProductByFollow(userId,null);

        //Assert
        assertEquals(expected, output);
    }

    @Test
    @DisplayName("Verifica que se cree correctamente un post")
    void createProductPostHappyPathTest() {
        //Arrange
        User userMock = GeneratorDataTest.findUsers().get(0);
        PostRequestDto postRequestDto = new PostRequestDto(1, LocalDate.now(),new ProductDto(),100,
                9.0);

        PostDto expected = new PostDto();
        expected.setUserId(postRequestDto.getUserId());
        expected.setId(11);
        expected.setDate(postRequestDto.getDate());
        expected.setProduct(postRequestDto.getProduct());
        expected.setPrice(postRequestDto.getPrice());
        expected.setCategory(postRequestDto.getCategory());

        when(iUserRepository.findById(userMock.getId())).thenReturn(userMock);

        //Act
        PostDto output = productImpl.createPost(postRequestDto);

        //Assert
        assertEquals(expected, output);
    }

    @Test
    @DisplayName("Verifica que se no se cree correctamente un post cuando el usuario es null")
    void createProductPostSadPathTest() {
        //Arrange
        User userMock = null;
        PostRequestDto postRequestDto = new PostRequestDto(1, LocalDate.now(),new ProductDto(),100,
                9.0);
        when(iUserRepository.findById(1)).thenReturn(userMock);

        //Act and Assert
        assertThrows(BadRequestException.class, () -> productImpl.createPost(postRequestDto));
    }

}