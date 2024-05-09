package bootcamp.sprint.grupo02.sprintI.service.implementations;

import bootcamp.sprint.grupo02.sprintI.dto.request.ProductDTO;
import bootcamp.sprint.grupo02.sprintI.model.Product;
import bootcamp.sprint.grupo02.sprintI.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProductServiceImplTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    @Test
    void addProductOk_test() {
        ProductDTO product = new ProductDTO(3, "Termo 2", "Tipo 3", "Lumilagro", "Gris", "Bueno, bonito y barato");

        productService.addProduct(product);

        verify(productRepository, atLeastOnce()).add(any());


    }

}
