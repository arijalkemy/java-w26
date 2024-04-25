package bootcamp.sprint.grupo02.sprintI.service.implementations;

import bootcamp.sprint.grupo02.sprintI.dto.request.ProductDTO;
import bootcamp.sprint.grupo02.sprintI.dto.response.ProductResponseDTO;
import bootcamp.sprint.grupo02.sprintI.model.Product;
import org.springframework.stereotype.Service;

import bootcamp.sprint.grupo02.sprintI.repository.ProductRepository;
import bootcamp.sprint.grupo02.sprintI.service.ProductService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;

    public ProductResponseDTO convertToProductDTO(Product product) {
        ProductResponseDTO productResponseDTO = new ProductResponseDTO();
        productResponseDTO.setBrand(product.getBrand());
        productResponseDTO.setType(product.getType());
        productResponseDTO.setId(product.getId());
        productResponseDTO.setNotes(product.getNotes());
        productResponseDTO.setName(product.getName());
        productResponseDTO.setColor(product.getColor());
        return productResponseDTO;
    }

    @Override
    public void addProduct(ProductDTO dto){
        repository.add(parseDtoToModel(dto));
    }


    private Product parseDtoToModel(ProductDTO proDto){
        Product product = new Product(proDto.getProductId(),proDto.getProductName(),proDto.getType(),proDto.getColor(),
                proDto.getNotes(),proDto.getBrand());
        return product;
    }
}
