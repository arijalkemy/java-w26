package bootcamp.sprint.grupo02.sprintI.repository;

import bootcamp.sprint.grupo02.sprintI.model.Product;
import bootcamp.sprint.grupo02.sprintI.repository.implementations.ProductRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
public class ProductRepositoryTest {

    ProductRepositoryImpl productRepository;

    @BeforeEach
    public void setUp() {
        this.productRepository = new ProductRepositoryImpl();
    }

    @Test
    public void findAllProductsTest() {
        //Arrange
        List<Product> products = new ArrayList<>(
                List.of(new Product(1, "Termo", "Tipo 1", "Stanley", "Verde",
                                "Muy caro para lo que es"),
                        new Product(2, "Macbook ", "Pro", "Air", "Gris",
                                "Buena compu")));
        //Act
        List<Product> expectedProducts = productRepository.findAll();
        //Assert
        Assertions.assertEquals(expectedProducts, products);
    }

    @Test
    public void addProductTest() {
        //Arrange
        Product product = new Product(3, "Termo", "Tipo 1", "Stanley",
                "Verde", "Muy caro para lo que es");
        //Act
        productRepository.add(product);

        Assertions.assertTrue(productRepository.findAll().contains(product));
    }

}
