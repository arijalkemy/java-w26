package bootcamp.sprint.grupo02.sprintI.repository;

import bootcamp.sprint.grupo02.sprintI.model.Product;
import bootcamp.sprint.grupo02.sprintI.repository.implementations.ProductRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

public class ProductRepositoryTest {

    private ProductRepository productRepository;
    List<Product> products;

    @BeforeEach
    void setUp() {
        productRepository = new ProductRepositoryImpl();
        products = new ArrayList<>(
                List.of(new Product(1, "Termo", "Tipo 1", "Stanley", "Verde", "Muy caro para lo que es"),
                        new Product(2, "Macbook ", "Pro", "Air", "Gris", "Buena compu")));

    }

    @Test
    void findAllReturns3Products_test() {

        List<Product> productsFromRepo = productRepository.findAll();

        Assertions.assertEquals(products, productsFromRepo);
    }
    @Test
    void findById1ReturnsProduct_test() {
        Product product = new Product(1, "Termo", "Tipo 1", "Stanley", "Verde", "Muy caro para lo que es");

        Product productFromRepo = productRepository.findById(1).get();

        Assertions.assertEquals(product, productFromRepo);
    }

    @Test
    void addNewProduct_test(){
        Product product = new Product(3, "Termo 2", "Tipo 3", "Lumilagro", "Gris", "Bueno, bonito y barato");

        productRepository.add(product);

        Assertions.assertTrue(productRepository.findAll().contains(product));
    }

    @Test
    void removeProduct_test(){
        Product product = new Product(3, "Termo 2", "Tipo 3", "Lumilagro", "Gris", "Bueno, bonito y barato");

        productRepository.remove(product);

        Assertions.assertFalse(productRepository.findAll().contains(product));
    }
}
