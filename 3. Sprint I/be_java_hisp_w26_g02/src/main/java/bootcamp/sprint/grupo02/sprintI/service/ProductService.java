package bootcamp.sprint.grupo02.sprintI.service;

import bootcamp.sprint.grupo02.sprintI.dto.request.ProductDTO;
import bootcamp.sprint.grupo02.sprintI.dto.response.ProductResponseDTO;
import bootcamp.sprint.grupo02.sprintI.model.Product;

public interface ProductService {
    ProductResponseDTO convertToProductDTO(Product product);
    void addProduct(ProductDTO dto);
}
