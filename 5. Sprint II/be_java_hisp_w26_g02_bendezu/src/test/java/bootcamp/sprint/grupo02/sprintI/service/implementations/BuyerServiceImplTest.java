package bootcamp.sprint.grupo02.sprintI.service.implementations;

import bootcamp.sprint.grupo02.sprintI.dto.response.FollowedListResponseDTO;
import bootcamp.sprint.grupo02.sprintI.dto.response.UserResponseDTO;
import bootcamp.sprint.grupo02.sprintI.exception.BadRequestException;
import bootcamp.sprint.grupo02.sprintI.exception.NotFoundException;
import bootcamp.sprint.grupo02.sprintI.exception.UnfollowNotAllowedException;
import bootcamp.sprint.grupo02.sprintI.model.Buyer;
import bootcamp.sprint.grupo02.sprintI.model.Seller;
import bootcamp.sprint.grupo02.sprintI.repository.BuyerRepository;
import bootcamp.sprint.grupo02.sprintI.repository.SellerRepository;
import bootcamp.sprint.grupo02.sprintI.util.TestGeneratorUtil;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BuyerServiceImplTest {

    @Mock
    private BuyerRepository buyerRepository;

    @Mock
    private SellerRepository sellerRepository;
    @InjectMocks
    private BuyerServiceImpl buyerService;

    @BeforeEach
    public void setup() {
        lenient().when(buyerRepository.findById(1))
                .thenReturn(Optional.of(TestGeneratorUtil.createBuyerWithIdAndFollows(1)));
    }

    @Test
    @DisplayName("Tipo de ordenamiento ascendente existente.")
    public void searchBuyerFollowsAscendingOrderTest() {
        executeOrderTest("NAME_ASC");
    }

    @Test
    @DisplayName("Tipo de ordenamiento descendente existente.")
    public void searchBuyerFollowsDescendingOrderTest() {
        executeOrderTest("NAME_DESC");
    }

    @Test
    @DisplayName("Tipo de ordenamiento inexistente.")
    public void searchBuyerFollowsNonExistentOrderTest() {
        // Act & Assert
        assertThrows(BadRequestException.class, () -> {
            buyerService.searchBuyerFollows(1, "asdasdasd");
        });
    }

    @Test
    void givenBuyerNotExists_whenSearchBuyerFollows_thenThrow() {
        String expectedMessage = "No buyer founded with ID [-1]";

        when(buyerRepository.findById(-1)).thenReturn(Optional.empty());

        NotFoundException ex = assertThrows(NotFoundException.class, () -> buyerService.searchBuyerFollows(-1));

        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test
    void getFollowedAsc() {
        int id = 1;
        String order = "NAME_ASC";
        FollowedListResponseDTO expected = new FollowedListResponseDTO();
        expected.setUser(new UserResponseDTO(1, "Buyer 1"));
        expected.setFollowed(TestGeneratorUtil.get4FollowedAsc().stream()
                .map(follower -> new UserResponseDTO(follower.getId(), follower.getName())).toList());

        when(buyerRepository.findById(id))
                .thenReturn(Optional.ofNullable(TestGeneratorUtil.createBuyerWithFollowed(id)));

        FollowedListResponseDTO result = buyerService.searchBuyerFollows(id, order);

        assertEquals(expected, result);
    }

    @Test
    void getFollowedDesc() {
        int id = 1;
        String order = "NAME_DESC";
        FollowedListResponseDTO expected = new FollowedListResponseDTO();
        expected.setUser(new UserResponseDTO(1, "Buyer 1"));
        expected.setFollowed(TestGeneratorUtil.get4FollowedDesc().stream()
                .map(follower -> new UserResponseDTO(follower.getId(), follower.getName()))
                .toList());

        when(buyerRepository.findById(id))
                .thenReturn(Optional.ofNullable(TestGeneratorUtil.createBuyerWithFollowed(id)));

        FollowedListResponseDTO result = buyerService.searchBuyerFollows(id, order);

        assertEquals(expected, result);
    }

    private void executeOrderTest(String order) {
        // Act & Assert
        assertDoesNotThrow(() -> {
            buyerService.searchBuyerFollows(1, order);
        });
    }

    @Test
    @DisplayName("El usuario a dejar de seguir existe.")
    public void testUnfollowUser_UserExist() {
        // Arrange
        Buyer buyer = TestGeneratorUtil.createBuyerWithId(1);
        Seller seller = TestGeneratorUtil.createSellerWithId(1);

        when(buyerRepository.findById(anyInt())).thenReturn(Optional.ofNullable(buyer));
        when(sellerRepository.findById(anyInt())).thenReturn(Optional.ofNullable(seller));

        buyerService.followUser(1, 1);
        buyerService.UnfollowUser(1, 1);

        // Assert
        assertFalse(buyer.getFollows().contains(seller));
    }

    @Test
    @DisplayName("El usuario a dejar de seguir no existe.")
    public void testUnfollowUser_UserDoesNotExist() {
        // Arrange
        int id = 1;
        when(buyerRepository.findById(id))
                .thenReturn(Optional.ofNullable(TestGeneratorUtil.createBuyerWithFollowed(id)));
        when(sellerRepository.findById(anyInt())).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(NotFoundException.class, () -> buyerService.UnfollowUser(1, 1));
    }

    @Test
    void givenBuyerNotExists_whenUnFollowUser_thenThrow() {
        int notExistId = -1;
        String expectedMessage = "Buyer not found: -1";

        when(buyerRepository.findById(notExistId)).thenReturn(Optional.empty());

        NotFoundException ex = assertThrows(NotFoundException.class, () -> buyerService.UnfollowUser(notExistId, 1));

        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test
    void givenBuyerNotExists_whenFollowUser_thenThrow() {
        int notExistId = -1;
        String expectedMessage = "User not found: -1";

        when(buyerRepository.findById(notExistId)).thenReturn(Optional.empty());

        NotFoundException ex = assertThrows(NotFoundException.class, () -> buyerService.followUser(notExistId, 1));

        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test
    @DisplayName("El usuario a seguir existe.")
    public void testFollowUser_UserExists() {
        // Arrange
        Buyer buyer = TestGeneratorUtil.createBuyerWithId(1);
        Seller seller = TestGeneratorUtil.createSellerWithId(1);

        when(buyerRepository.findById(anyInt())).thenReturn(Optional.ofNullable(buyer));
        when(sellerRepository.findById(anyInt())).thenReturn(Optional.ofNullable(seller));

        // Act
        buyerService.followUser(1, 1);

        // Assert
        assertTrue(buyer.getFollows().contains(seller));
    }

    @Test
    @DisplayName("El usuario a seguir no existe.")
    public void testFollowUser_UserDoesNotExist() {
        // Arrange
        int id = 1;
        when(buyerRepository.findById(id))
                .thenReturn(Optional.ofNullable(TestGeneratorUtil.createBuyerWithFollowed(id)));
        when(sellerRepository.findById(anyInt())).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(NotFoundException.class, () -> buyerService.followUser(1, 1));
    }

    @Test
    void givenAlreadyFollow_whenFollowUser_thenThrow() {
        Buyer follower = TestGeneratorUtil.createBuyerWithFollowed(1);
        Seller followed = TestGeneratorUtil.createSellerWithId(1);
        String expected = "Cannot follow seller because is already followed. ";
        when(buyerRepository.findById(follower.getId())).thenReturn(Optional.of(follower));
        when(sellerRepository.findById(followed.getId())).thenReturn(Optional.of(followed));
        BadRequestException ex = assertThrows(BadRequestException.class, () -> buyerService.followUser(1, 1));
        assertEquals(expected, ex.getMessage());
    }

    @Test
    void givenNotFollow_whenUnfollowFollowUser_thenThrow() {
        Buyer follower = TestGeneratorUtil.createBuyerWithId(1);
        Seller followed = TestGeneratorUtil.createSellerWithId(1);
        String expected = "Cannot unfollow seller because not followed previously";
        when(buyerRepository.findById(follower.getId())).thenReturn(Optional.of(follower));
        when(sellerRepository.findById(followed.getId())).thenReturn(Optional.of(followed));
        UnfollowNotAllowedException ex = assertThrows(UnfollowNotAllowedException.class,
                () -> buyerService.UnfollowUser(1, 1));
        assertEquals(expected, ex.getMessage());
    }

    @Test
    void givenFollows_whenGetSellers_thenReturnList() {
        Buyer input = TestGeneratorUtil.createBuyerWithFollowed(1);

        List<Seller> expected = input.getFollows();
        when(buyerRepository.findById(1)).thenReturn(Optional.of(input));
        List<Seller> actual = buyerService.getAllSellers(1);

        assertEquals(expected, actual);
    }

    @Test
    void givenBuyerNotExists_whenGetSellers_thenThrow() {
        String expectedMessage = "Buyer not found";
        when(buyerRepository.findById(1)).thenReturn(Optional.empty());
        NotFoundException ex = assertThrows(NotFoundException.class, () -> buyerService.getAllSellers(1));

        assertEquals(expectedMessage, ex.getMessage());
    }

}
