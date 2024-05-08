package bootcamp.sprint.grupo02.sprintI.service.implementations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import bootcamp.sprint.grupo02.sprintI.dto.request.ProductDTO;
import bootcamp.sprint.grupo02.sprintI.dto.response.ProductResponseDTO;
import bootcamp.sprint.grupo02.sprintI.model.Product;
import bootcamp.sprint.grupo02.sprintI.repository.ProductRepository;
import bootcamp.sprint.grupo02.sprintI.util.TestGeneratorUtil;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {

    @Mock
    ProductRepository repository;

    @InjectMocks
    ProductServiceImpl underTests;


    @Test
    void givenProductDto_whenAddProduct_thenCallRepoWithProduct(){
        ProductDTO toSave = TestGeneratorUtil.createProductDTOWithId(1);
        underTests.addProduct(toSave);
        verify(repository).add(any(Product.class));
    }


    @Test
    void givenProduct_whenMapToResponse_thenTransformOk(){
        Product product = TestGeneratorUtil.createProductithId(1);
        ProductResponseDTO expected = TestGeneratorUtil.creaProductResponseDTOWithId(1);

        ProductResponseDTO actual = underTests.convertToProductDTO(product);

        assertEquals(expected, actual);

    }

}
