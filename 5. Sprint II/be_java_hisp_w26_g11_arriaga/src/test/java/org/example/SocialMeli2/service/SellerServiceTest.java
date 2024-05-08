package org.example.SocialMeli2.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.example.SocialMeli2.dto.PostDTO;
import org.example.SocialMeli2.dto.ResponsePostDTO;
import org.example.SocialMeli2.entity.Customer;
import org.example.SocialMeli2.entity.Post;
import org.example.SocialMeli2.entity.Seller;
import org.example.SocialMeli2.exception.BadRequestException;
import org.example.SocialMeli2.exception.NotFoundException;
import org.example.SocialMeli2.repository.ICustomerRepository;
import org.example.SocialMeli2.repository.ISellerRepository;
import org.example.SocialMeli2.service.seller.SellerServiceImplementation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SellerServiceTest {
    @Mock
    ISellerRepository sellerRepository;

    @Mock
    ICustomerRepository customerRepository;

    @InjectMocks
    SellerServiceImplementation sellerServiceImplementation;

    ResponsePostDTO responsePostDTOAsc;
    ResponsePostDTO responsePostDTODesc;
    Customer customer;
    Map<Integer, List<Post>> postsMap = new HashMap<>();

    @BeforeEach
    public void setup() {
        int userId = 1;
        List<PostDTO> postDTOS = new ArrayList<>();
        postDTOS.add(PostDTO.builder()
                .sellerId(2)
                .postId(100)
                .date(LocalDate.of(2024, 4, 30))
                .category(1000)
                .price(1000)
                .build()
        );

        postDTOS.add(PostDTO.builder()
                .sellerId(3)
                .postId(101)
                .date(LocalDate.of(2024, 5, 2))
                .category(2000)
                .price(1000)
                .build()
        );

        List<PostDTO> reversedPostDTOS = new ArrayList<>(postDTOS);
        Collections.reverse(reversedPostDTOS);

        responsePostDTOAsc = new ResponsePostDTO(userId, postDTOS);
        responsePostDTODesc = new ResponsePostDTO(userId, reversedPostDTOS);


        customer = Customer.builder()
                .userId(1)
                .userName("Juan")
                .sellers(Arrays.asList(2, 3))
                .build();

        postsMap.put(2, List.of(
                        Post.builder()
                                .postId(100)
                                .date(LocalDate.of(2024, 4, 30))
                                .category(1000)
                                .price(1000)
                                .build()
                )
        );

        postsMap.put(3, List.of(
                        Post.builder()
                                .postId(101)
                                .date(LocalDate.of(2024, 5, 2))
                                .category(2000)
                                .price(1000)
                                .build()
                )
        );
    }

    @Test
    @DisplayName("T-0005 Verificar que el tipo de ordenamiento por fecha exista")
    public void checkDateOrderExistsTest() {
        // Act
        when(customerRepository.findCustomerById(1)).thenReturn(customer);
        when(sellerRepository.findPostsByFollowing(customer.getSellers())).thenReturn(postsMap);

        // Assert
        ResponsePostDTO responseDateAsc = sellerServiceImplementation.getPostsFromFollowingWithTwoWeeksOld(1, "date_asc");
        ResponsePostDTO responseDateDesc = sellerServiceImplementation.getPostsFromFollowingWithTwoWeeksOld(1, "date_desc");

        Assertions.assertDoesNotThrow(() -> responseDateAsc);
        Assertions.assertDoesNotThrow(() -> responseDateDesc);
    }

    @Test
    @DisplayName("T-0005 Verificar que el ordenamiento por fecha no existe")
    public void checkOrderExistsTest() {
        // Act
        when(customerRepository.findCustomerById(1)).thenReturn(customer);
        when(sellerRepository.findPostsByFollowing(customer.getSellers())).thenReturn(postsMap);

        // Assert
        Assertions.assertThrows(BadRequestException.class, () -> sellerServiceImplementation.getPostsFromFollowingWithTwoWeeksOld(1, "asdf"));
    }

    @Test
    @DisplayName("T-0006 Verificar el correcto ordenamiento ascendente y descendente por fecha")
    public void dateOrderingCorrectTest() {
        // Act
        when(customerRepository.findCustomerById(1)).thenReturn(customer);
        when(sellerRepository.findPostsByFollowing(customer.getSellers())).thenReturn(postsMap);

        ResponsePostDTO responseDateAsc = sellerServiceImplementation.getPostsFromFollowingWithTwoWeeksOld(1, "date_asc");
        ResponsePostDTO responseDateDesc = sellerServiceImplementation.getPostsFromFollowingWithTwoWeeksOld(1, "date_desc");

        // Assert
        assertEquals(responsePostDTOAsc, responseDateAsc);
        assertEquals(responsePostDTODesc, responseDateDesc);
    }


    @Test
    @DisplayName("T-0006 Verificar id de usuario no existe")
    public void checkUserIdExistsTest() {
        // Act
        when(customerRepository.findCustomerById(anyInt())).thenReturn(null);

        // Assert
        Assertions.assertThrows(NotFoundException.class, () -> sellerServiceImplementation.getPostsFromFollowingWithTwoWeeksOld(1, "date_asc"));
    }

    @Test
    @DisplayName("T-0008 Verificar que los post regresados sean efectivamente de las ultimas dos semanas")
    public void getPostsFromFollowingWithTwoWeeksOldTest()
    {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        // Arrange
        Customer customer = new Customer(1, "Alexis", List.of(1));
        Seller seller = new Seller();
        seller.setSellerId(1);

        PostDTO postDTO2 = new PostDTO();
        postDTO2.setDate(LocalDate.now());

        Map<Integer, List<Post>> x = new HashMap<>();
        x.put(seller.getSellerId(), List.of(mapper.convertValue(postDTO2, Post.class)));

        ResponsePostDTO expectedResponse = new ResponsePostDTO(seller.getSellerId(), List.of(postDTO2));

        // Act
        when(customerRepository.findCustomerById(anyInt())).thenReturn(customer);
        when(sellerRepository.findPostsByFollowing(anyList())).thenReturn(x);
        ResponsePostDTO response = sellerServiceImplementation.getPostsFromFollowingWithTwoWeeksOld(customer.getUserId(), null);

        // Assert
        assertEquals(expectedResponse.getPosts().size(), response.getPosts().size());

    }

}
