package bootcamp.sprint.grupo02.sprintI.service;

import bootcamp.sprint.grupo02.sprintI.dto.request.ProductRequestDTO;
import bootcamp.sprint.grupo02.sprintI.dto.response.ProductResponseDTO;
import bootcamp.sprint.grupo02.sprintI.model.Product;

public interface ProductService {
    ProductResponseDTO convertToProductResponseDTO(Product product);
    Product convertToProductRequestDTO(ProductRequestDTO product);
    void addProduct(ProductRequestDTO dto);

}
