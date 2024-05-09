package org.example.be_java_hisp_w26_g04.service.seller;

import static org.example.be_java_hisp_w26_g04.service.util.UtilTest.assertEqualsDtoAsString;
import static org.example.be_java_hisp_w26_g04.service.util.UtilTest.mapListPostToPostResponseDto;
import static org.example.be_java_hisp_w26_g04.service.util.UtilTest.todayPost;
import static org.example.be_java_hisp_w26_g04.service.util.UtilTest.twoWeeksAgoPost;
import static org.example.be_java_hisp_w26_g04.service.util.UtilTest.weekAgoPost;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.example.be_java_hisp_w26_g04.dto.FollowersCountDTO;
import org.example.be_java_hisp_w26_g04.dto.PostResponseDTO;
import org.example.be_java_hisp_w26_g04.dto.SellerFollowersDTO;
import org.example.be_java_hisp_w26_g04.exceptions.BadRequestException;
import org.example.be_java_hisp_w26_g04.model.Buyer;
import org.example.be_java_hisp_w26_g04.model.Post;
import org.example.be_java_hisp_w26_g04.model.Seller;
import org.example.be_java_hisp_w26_g04.repository.buyer.IBuyersRepository;
import org.example.be_java_hisp_w26_g04.repository.seller.ISellerRepository;
import org.example.be_java_hisp_w26_g04.service.util.UtilTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

// Disclaimer:
// Hay muchos tests que se configuran igual y se pueden seguir abstrayendo y parametrizando
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class SellerServiceTest {

    private Set<Seller> sellers;
    private Set<Buyer> buyers;

    @Mock
    ISellerRepository sellerRepository;

    @Mock
    IBuyersRepository buyerRepository;

    @InjectMocks
    SellerService service;


    @BeforeEach
    public void setUp() throws IOException {
        sellers = UtilTest.getSellers();
        buyers = UtilTest.getBuyers();
    }

    @Test
    void findFollowers() {
    }

    @Test
    @DisplayName("T-0003: Verifica si ordenamiento name_asc existe")
    void sortGetFollowersAscExist() {
        int sellerId = 234;
        int buyerId1 = 456;
        int buyerId2 = 789;

        when(sellerRepository.findById(sellerId)).thenReturn(getSellerById(sellerId));
        when(buyerRepository.findById(buyerId1)).thenReturn(getBuyerById(buyerId1));
        when(buyerRepository.findById(buyerId2)).thenReturn(getBuyerById(buyerId2));

        assertDoesNotThrow(() -> service.sortGetFollowers(sellerId, "name_asc"));
    }

    @Test
    @DisplayName("T-0003: Verifica si ordenamiento name_desc existe")
    void sortGetFollowersDescExist() {
        int sellerId = 234;
        int buyerId1 = 456;
        int buyerId2 = 789;

        when(sellerRepository.findById(sellerId)).thenReturn(getSellerById(sellerId));
        when(buyerRepository.findById(buyerId1)).thenReturn(getBuyerById(buyerId1));
        when(buyerRepository.findById(buyerId2)).thenReturn(getBuyerById(buyerId2));

        assertDoesNotThrow(() -> service.sortGetFollowers(sellerId, "name_desc"));
    }

    @Test
    @DisplayName("T-0003: Verifica si se lanza una excepcion con un ordenamiento invalido")
    void sortGetFollowersIvalidNameORdering() {
        int sellerId = 234;
        int buyerId1 = 456;
        int buyerId2 = 789;

        when(sellerRepository.findById(sellerId)).thenReturn(getSellerById(sellerId));
        when(buyerRepository.findById(buyerId1)).thenReturn(getBuyerById(buyerId2));
        when(buyerRepository.findById(buyerId2)).thenReturn(getBuyerById(buyerId2));

        assertThrows(BadRequestException.class, () ->
            service.sortGetFollowers(sellerId, "invalid_order_type")
        );
    }

    @Test
    @DisplayName("T-0004: Verifica el correcto ordenamiento ascendente por nombre de los seguidores de un seller")
    void sortGetFollowersAsc() throws JsonProcessingException {
        //Arrange
        int sellerId = 234;
        int buyerId1 = 456;
        int buyerId2 = 789;

        when(sellerRepository.findById(sellerId)).thenReturn(getSellerById(sellerId));
        when(buyerRepository.findById(buyerId1)).thenReturn(getBuyerById(buyerId1));
        when(buyerRepository.findById(buyerId2)).thenReturn(getBuyerById(buyerId2));

        SellerFollowersDTO expected = UtilTest.generateListFollowersAsc();

        //Act
        SellerFollowersDTO result = service.sortGetFollowers(sellerId, "name_asc");

        //Assert
        assertEqualsDtoAsString(expected, result);
    }

    @Test
    @DisplayName("T-0004: Verifica el correcto ordenamiento descendente por nombre de los seguidores de un seller")
    void sortGetFollowersDesc() throws JsonProcessingException {
        //Arrange
        int sellerId = 234;
        int buyerId1 = 456;
        int buyerId2 = 789;

        when(sellerRepository.findById(sellerId)).thenReturn(getSellerById(sellerId));
        when(buyerRepository.findById(buyerId1)).thenReturn(getBuyerById(buyerId1));
        when(buyerRepository.findById(buyerId2)).thenReturn(getBuyerById(buyerId2));

        SellerFollowersDTO expected = UtilTest.generateListFollowersDesc();

        //Act
        SellerFollowersDTO result = service.sortGetFollowers(sellerId, "name_desc");

        //Assert
        assertEqualsDtoAsString(expected, result);
    }

    @Test
    @DisplayName("T-0005: Verificar que el tipo de ordenamiento por fecha exista")
    void sortedFollowersByDateExist() {
        //Arrange
        int buyerId = 456;
        String order = "date_asc";


        List<Post> posts = getPosts();

        when(buyerRepository.findById(buyerId)).thenReturn(getBuyerById(buyerId));
        when(sellerRepository.getPosts()).thenReturn(posts);

        //Act & Assert
        assertDoesNotThrow(() -> service.sortGetPostFromFollower(buyerId, order));
    }

    @Test
    @DisplayName("T-0005: Retorna una excepción cuando el tipo de ordenamiento por fecha no exista")
    void sortedFollowersByDateNotExist() {
        //Arrange
        int buyerId = 456;
        String order = "foo";

        List<Post> posts = getPosts();

        when(buyerRepository.findById(buyerId)).thenReturn(getBuyerById(buyerId));
        when(sellerRepository.getPosts()).thenReturn(posts);

        //Act & Assert
        assertThrows(BadRequestException.class, () ->
            service.sortGetPostFromFollower(buyerId, order)
        );
    }

    @Test
    @DisplayName("T-0006: Verificar el correcto ordenamiento ascendente por fecha")
    void sortGetPostFromFollowerAsc() throws JsonProcessingException {
        //Arrange
        int buyerId = 456;
        String order = "date_asc";

        List<Post> posts = getPosts();

        when(buyerRepository.findById(buyerId)).thenReturn(getBuyerById(buyerId));
        when(sellerRepository.getPosts()).thenReturn(posts);

        List<PostResponseDTO> expected = UtilTest.generatePostResponseDTOAsc();

        //Act
        List<PostResponseDTO> result = service.sortGetPostFromFollower(buyerId, order);

        //Assert
        assertEqualsDtoAsString(expected, result);
    }

    @Test
    @DisplayName("T-0006: Verificar el correcto ordenamiento descendente por fecha")
    void sortGetPostFromFollowerDesc() throws JsonProcessingException {
        //Arrange
        int buyerId = 456;
        String order = "date_desc";

        List<Post> posts = getPosts();

        when(buyerRepository.findById(buyerId)).thenReturn(getBuyerById(buyerId));
        when(sellerRepository.getPosts()).thenReturn(posts);

        List<PostResponseDTO> expected = UtilTest.generatePostResponseDTODesc();

        //Act
        List<PostResponseDTO> result = service.sortGetPostFromFollower(buyerId, order);

        //Assert
        assertEqualsDtoAsString(expected, result);
    }

    @Test
    @DisplayName("T-0007: Verificar que la cantidad de seguidores de un determinado usuario sea correcta.")
    public void countFollowersTest() throws JsonProcessingException {
        //Arrange
        int sellerId = 123;

        FollowersCountDTO expectedFollowersCountDTO = new FollowersCountDTO();
        expectedFollowersCountDTO.setUserId(123);
        expectedFollowersCountDTO.setUserName("JohnDoe");
        expectedFollowersCountDTO.setFollowersCount(1);

        when(sellerRepository.findById(sellerId)).thenReturn(getSellerById(sellerId));

        //Act
        FollowersCountDTO resultFollowersCountDTO = service.findFollowers(sellerId);

        //Assert
        assertEqualsDtoAsString(expectedFollowersCountDTO, resultFollowersCountDTO);
    }

    @Test
    @DisplayName("T-0008 Verificar la consulta de publicaciones realizadas en las últimas 2 semanas")
    public void returnPostsFromLastTwoWeeks() throws JsonProcessingException {
        // Arrange
        List<Post> posts = List.of(todayPost(), weekAgoPost(), twoWeeksAgoPost());
        Seller seller = new Seller(1, "", posts, null, null);
        Buyer buyer = new Buyer(1, "Valen", Set.of(seller.getUserId()));

        List<Post> expectedPosts = List.of(todayPost(), weekAgoPost());
        List<PostResponseDTO> expected = mapListPostToPostResponseDto(expectedPosts);

        when(buyerRepository.findById(1)).thenReturn(Optional.of(buyer));
        when(sellerRepository.getPosts()).thenReturn(posts);

        // Act
        List<PostResponseDTO> result = service.sortGetPostFromFollower(1, "date_desc");

        // Assert
        assertEquals(2, result.size());
        assertEqualsDtoAsString(expected, result);
    }

    Optional<Seller> getSellerById(int id) {
        return sellers.stream().filter(x -> x.getUserId() == id).findFirst();
    }

    Optional<Buyer> getBuyerById(int id) {
        return buyers.stream().filter(x_ -> x_.getUserId() == id).findFirst();
    }

    List<Post> getPosts() {return sellers.stream().flatMap(x -> x.getListPost().stream()).toList();}
}