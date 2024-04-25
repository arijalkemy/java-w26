package bootcamp.sprint.grupo02.sprintI.service.implementations;

import bootcamp.sprint.grupo02.sprintI.dto.request.ProductRequestDTO;
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

    public ProductResponseDTO convertToProductResponseDTO(Product product) {
        ProductResponseDTO productResponseDTO = new ProductResponseDTO();
        productResponseDTO.setBrand(product.getBrand());
        productResponseDTO.setType(product.getType());
        productResponseDTO.setId(product.getId());
        productResponseDTO.setNotes(product.getNotes());
        productResponseDTO.setName(product.getName());
        productResponseDTO.setColor(product.getColor());
        return productResponseDTO;
    }

    public Product convertToProductRequestDTO(ProductRequestDTO productDto) {
        Product product = new Product();
        product.setBrand(product.getBrand());
        product.setType(product.getType());
        product.setId(product.getId());
        product.setNotes(product.getNotes());
        product.setName(product.getName());
        product.setColor(product.getColor());
        return product;
    }

    @Override
    public void addProduct(ProductRequestDTO dto){
        repository.add(parseDtoToModel(dto));
    }


    private Product parseDtoToModel(ProductRequestDTO proDto){
        Product product = new Product(proDto.getProductId(),proDto.getProductName(),proDto.getType(),proDto.getColor(),
                proDto.getNotes(),proDto.getBrand());
        return product;
    }
}
