package org.example.be_java_hisp_w26_g04.service.buyer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.util.Optional;
import java.util.Set;
import org.example.be_java_hisp_w26_g04.model.Buyer;
import org.example.be_java_hisp_w26_g04.repository.buyer.BuyerRepositoryImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BuyerRepositoryTest {
    BuyerRepositoryImp repo;

    @BeforeEach
    public void setUp() throws IOException {
        // Acá tenemos el problema de que siempre se va a leer desde el json del repo
        // Debería parametrizarse a lo sumo el path
        repo = new BuyerRepositoryImp();
    }

    @Test
    @DisplayName("El repositorio se genera")
    public void populateShouldNotFail() {
        assertNotNull(repo);
    }

    @Test
    @DisplayName("Se guarda un buyer nuevo y se obtiene correctamente")
    public void saveAndGetUserShouldWork() {
        // Arrange
        Buyer buyer = getBuyerWithoutIdAndFollowings();

        // Act
        int id = repo.save(buyer);
        Optional<Buyer> savedBuyer = repo.findById(id);

        // Assert
        assertTrue(savedBuyer.isPresent());
        assertEquals("Juan", savedBuyer.get().getUserName());
        assertEquals(id, savedBuyer.get().getUserId());
    }

    @Test
    @DisplayName("Se guarda un buyer nuevo y se le sigue un seller")
    public void getAllBuyers() {
        // Arrange
        Buyer buyer = getBuyerWithoutIdAndFollowings();

        // Act
        repo.save(buyer);
        Set<Buyer> buyers = repo.findAll();

        // Assert
        assertFalse(buyers.isEmpty());
    }

    public Buyer getBuyerWithoutIdAndFollowings() {
        Buyer buyer = new Buyer();
        buyer.setUserName("Juan");
        buyer.setSellersFollowing(null);
        return buyer;
    }
}
