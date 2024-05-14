package bootcamp.sprint.grupo02.sprintI.repository;

import bootcamp.sprint.grupo02.sprintI.model.Buyer;
import bootcamp.sprint.grupo02.sprintI.model.Seller;
import bootcamp.sprint.grupo02.sprintI.repository.implementations.SellerRepositoryImpl;
import jdk.jshell.spi.ExecutionControl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class SellerRepositoryTest {
    SellerRepositoryImpl sellerRepository;

    @BeforeEach
    public void setUp() {
        sellerRepository = new SellerRepositoryImpl();
    }

    @Test
    public void findyByIdTest() {
        //Arrange
        Seller seller1 = new Seller(2, "Un Vendedor 2");
        //Act
        Optional<Seller> sellerOp = sellerRepository.findById(seller1.getId());
        Seller seller = sellerOp.get();

        //Assert
        Assertions.assertEquals(seller1, seller);

    } @Test
    public void findAllTest() {
        Assertions.assertThrows(UnsupportedOperationException.class, () -> sellerRepository.findAll());
    }

}

