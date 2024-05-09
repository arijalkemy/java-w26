package bootcamp.sprint.grupo02.sprintI.service.implementations;

import bootcamp.sprint.grupo02.sprintI.dto.response.FollowersListResponseDTO;
import bootcamp.sprint.grupo02.sprintI.dto.response.SellerFollowersResponseDTO;
import bootcamp.sprint.grupo02.sprintI.dto.response.UserResponseDTO;
import bootcamp.sprint.grupo02.sprintI.exception.BadRequestException;
import bootcamp.sprint.grupo02.sprintI.model.Buyer;
import bootcamp.sprint.grupo02.sprintI.model.Seller;
import bootcamp.sprint.grupo02.sprintI.repository.SellerRepository;
import bootcamp.sprint.grupo02.sprintI.util.TestGeneratorUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class SellerServiceImplTest {
    @Mock
    private SellerRepository sellerRepository;
    @InjectMocks
    private SellerServiceImpl sellerService;

    @BeforeEach
    public void setup() {
        when(sellerRepository.findById(1))
                .thenReturn(Optional.of(TestGeneratorUtil.createSellerWithIdAndFollowers(1)));
    }

    @Test
    @DisplayName("Tipo de ordenamiento ascendente existente.")
    public void searchSellerFollowsAscendingOrderTest() {
        executeOrderTest("NAME_ASC");
    }

    @Test
    @DisplayName("Tipo de ordenamiento descendente existente.")
    public void searchSellerFollowsDescendingOrderTest() {
        executeOrderTest("NAME_DESC");
    }

    @Test
    @DisplayName("Tipo de ordenamiento inexistente.")
    public void searchSellerFollowsNonExistentOrderTest() {
        // Act & Assert
        assertThrows(BadRequestException.class, () -> {
            sellerService.getFollowersList(1, "asdasdasd");
        });
    }

    @Test
    void getFollowersListAsc() {
        int id = 1;
        String order = "NAME_ASC";
        FollowersListResponseDTO expected = new FollowersListResponseDTO();
        expected.setUser(new UserResponseDTO(1, "Seller 1"));
        expected.setFollowers(TestGeneratorUtil.get4FollowersAsc().stream()
                        .sorted(Comparator.comparing(Buyer::getName))
                        .map(follower -> new UserResponseDTO(follower.getId(), follower.getName())).toList());

        when(sellerRepository.findById(id))
                .thenReturn(Optional.ofNullable(TestGeneratorUtil.createSellerWithFollowers(id)));

        FollowersListResponseDTO result = sellerService.getFollowersList(id, order);

        Assertions.assertEquals(expected, result);
    }

    @Test
    void getFollowersListDesc() {
        int id = 1;
        String order = "NAME_DESC";
        FollowersListResponseDTO expected = new FollowersListResponseDTO();
        expected.setUser(new UserResponseDTO(1, "Seller 1"));
        expected.setFollowers(TestGeneratorUtil.get4FollowersDesc().stream()
                .sorted(Comparator.comparing(Buyer::getName).reversed())
                .map(follower -> new UserResponseDTO(follower.getId(), follower.getName())).toList());

        when(sellerRepository.findById(id))
                .thenReturn(Optional.ofNullable(TestGeneratorUtil.createSellerWithFollowers(id)));

        FollowersListResponseDTO result = sellerService.getFollowersList(id, order);

        Assertions.assertEquals(expected, result);
    }

    private void executeOrderTest(String order) {
        // Act & Assert
        assertDoesNotThrow(() -> {
            sellerService.getFollowersList(1, order);
        });
    }

    @Test
    public void calculateFollowersCountTest() {
        Seller seller = TestGeneratorUtil.createSellerWithId(1);
        seller.setFollowers(List.of(TestGeneratorUtil.createBuyerWithId(1),
                TestGeneratorUtil.createBuyerWithId(2)));
        when(sellerRepository.findById(seller.getId())).thenReturn(Optional.of(seller));

        SellerFollowersResponseDTO sellerFollowersResponseDTO = this.sellerService.calculateFollowersCount(seller.getId());

        Assertions.assertEquals(2, sellerFollowersResponseDTO.getFollowersCount());
    }
}
