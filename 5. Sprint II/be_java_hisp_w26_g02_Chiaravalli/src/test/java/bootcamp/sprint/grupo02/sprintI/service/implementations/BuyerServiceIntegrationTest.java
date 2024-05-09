package bootcamp.sprint.grupo02.sprintI.service.implementations;


import bootcamp.sprint.grupo02.sprintI.exception.BadRequestException;
import bootcamp.sprint.grupo02.sprintI.exception.NotFoundException;
import bootcamp.sprint.grupo02.sprintI.exception.UnfollowNotAllowedException;
import bootcamp.sprint.grupo02.sprintI.model.Buyer;
import bootcamp.sprint.grupo02.sprintI.model.Seller;
import bootcamp.sprint.grupo02.sprintI.repository.BuyerRepository;
import bootcamp.sprint.grupo02.sprintI.repository.SellerRepository;
import bootcamp.sprint.grupo02.sprintI.util.TestGeneratorUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BuyerServiceIntegrationTest {
    @Mock
    private BuyerRepository buyerRepository;
    @Mock
    private SellerRepository sellerRepository;

    @InjectMocks
    private BuyerServiceImpl buyerService;

    @Test
    @DisplayName("Seguir y dejar de seguir usarios")
    public void  testFollowAndUnfollowUserIntegration(){
        //Arrange
        Buyer buyer = TestGeneratorUtil.createBuyerWithId(1);
        Seller seller = TestGeneratorUtil.createSellerWithId(2);
        when(buyerRepository.findById(anyInt())).thenReturn(Optional.of(buyer));
        when(sellerRepository.findById(anyInt())).thenReturn(Optional.of(seller));

        // Act & Asserts
        buyerService.followUser(buyer.getId(), seller.getId());
        assertThrows(BadRequestException.class, () -> {
            buyerService.followUser(buyer.getId(), seller.getId());
        });

        buyerService.UnfollowUser(buyer.getId(), seller.getId());
        assertThrows(UnfollowNotAllowedException.class, () -> {
            buyerService.UnfollowUser(buyer.getId(), seller.getId());
        });

        assertFalse(buyer.getFollows().contains(seller));
        assertFalse(seller.getFollowers().contains(buyer));
    }

    @Test
    @DisplayName("Test getAllSellers for an existing buyer")
    public void testGetAllSellersForExistingBuyer() {
        // Given
        Buyer buyer = TestGeneratorUtil.createBuyerWithId(1);
        List<Seller> sellers = Arrays.asList(
            TestGeneratorUtil.createSellerWithId(1),
            TestGeneratorUtil.createSellerWithId(2)
        );
        buyer.setFollows(sellers);
        when(buyerRepository.findById(buyer.getId())).thenReturn(Optional.of(buyer));

        // When
        sellers = buyerService.getAllSellers(buyer.getId());

        // Then
        assertNotNull(sellers);

        assertEquals(2, sellers.size());
        assertTrue(sellers.contains(sellers.get(0)));
        assertTrue(sellers.contains(sellers.get(1)));
    }

    @Test
    @DisplayName("Test getAllSellers for a non-existing buyer")
    public void testGetAllSellersForNonExistingBuyer() {
        // When & Then
        assertThrows(NotFoundException.class, () -> buyerService.getAllSellers(999));
    }
}
