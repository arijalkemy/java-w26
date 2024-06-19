package com.mercadolibre.fresh_market.service.impl;
import com.mercadolibre.fresh_market.config.CategoryBadRequestException;
import com.mercadolibre.fresh_market.config.ProductNotFoundException;
import com.mercadolibre.fresh_market.config.ProductsNotFoundException;
import com.mercadolibre.fresh_market.config.UserNotFoundException;
import com.mercadolibre.fresh_market.dtos.OperationResponseDTO;
import com.mercadolibre.fresh_market.dtos.ProductDetailDTO;
import com.mercadolibre.fresh_market.dtos.ProductStockDTO;
import com.mercadolibre.fresh_market.dtos.WarehouseProduct;
import com.mercadolibre.fresh_market.model.*;
import com.mercadolibre.fresh_market.model.enums.Category;
import com.mercadolibre.fresh_market.repository.*;
import com.mercadolibre.fresh_market.service.IProductService;
import com.mercadolibre.fresh_market.util.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository productRepository;
    @Autowired
    private IBatchRepository batchRepository;
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private IWarehouseRepository warehouseRepository;
    @Autowired
    private ISectionRepository sectionRepository;
    /**
     * Retrieves the stock of a specific product across all warehouses.
     * This method fetches the product by its ID, calculates the total stock available
     * in each warehouse by summing up the quantities in different sections, and returns
     * the stock information as a ProductStockDTO.
     *
     * @param productId The ID of the product to retrieve the stock for.
     * @return A ProductStockDTO object containing the product ID and the stock per warehouse.
     * @throws ProductNotFoundException if the product with the given ID is not found.
     */
    public ProductStockDTO getProductStock(Long productId) {
        Product product = productRepository.findById(productId).orElse(null);
        if (product == null) {
            throw new ProductNotFoundException("The product with ID " + productId + " was not found.");
        }
        List<Warehouse> warehouses = warehouseRepository.findAll();
        Map<Long, Integer> stockPerWarehouse = warehouses.stream()
                .collect(Collectors.toMap(
                        Warehouse::getId, // Key is the warehouse ID
                        warehouse -> { // Value is the total stock in that warehouse
                            List<Section> sections = sectionRepository.findByWarehouseId(warehouse.getId());
                            return sections.stream()
                                    .flatMap(section -> batchRepository.findByProductAndSection(product, section).stream())
                                    .mapToInt(Batch::getCurrentQuantity)
                                    .sum();
                        }
                ));
        return convertMapToProductStockDTO(productId, stockPerWarehouse);
    }
    /**
     * Retrieves all products from the database.
     * This method fetches all products, maps them to ProductDetailDTO objects using the ProductMapper,
     * and returns the list of ProductDetailDTOs.
     *
     * @return A List of ProductDetailDTO objects containing the details of all products.
     * @throws ProductsNotFoundException if no products were found in the database.
     */
    @Override
    public List<ProductDetailDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();
        if (products.isEmpty()) {
            throw new ProductsNotFoundException("No products were found.");
        }
        ProductMapper productMapper = new ProductMapper();
        return products.stream().map(productMapper::productToProductDetailDTO).toList();
    }
    /**
     * Retrieves all unique products from the database that belong to a specific category.
     * This method fetches all unique products from batches that belong to the given category,
     * maps them to ProductDetailDTO objects using the ProductMapper, and returns the list of ProductDetailDTOs.
     *
     * @param category The category of the products to retrieve.
     * @return A List of ProductDetailDTO objects containing the details of all products in the specified category.
     * @throws CategoryBadRequestException if the provided category is not valid.
     * @throws ProductsNotFoundException   if no products were found in the specified category.
     */
    @Override
    public List<ProductDetailDTO> getAllProductsByCategory(String category) {
        if(!category.equals("FF") && !category.equals("RF") && !category.equals("FS") ) {
            throw new CategoryBadRequestException("This category is not valid: " + category);
        }
        List<Product> products = batchRepository.findDistinctProductsByCategory(Category.valueOf(category));
        if (products.isEmpty()) {
            throw new ProductsNotFoundException("No products were found in the category: " + category);
        }
        ProductMapper productMapper = new ProductMapper();
        return products.stream().map(productMapper::productToProductDetailDTO).toList();
    }


    /**
     * Retrieves all products from the database that belong to a specific seller.
     * This method fetches all products that belong to the given seller,
     * maps them to ProductDetailDTO objects using the ProductMapper, and returns the list of ProductDetailDTOs.
     *
     * @param sellerId The ID of the seller.
     * @return A List of ProductDetailDTO objects containing the details of all products that belong to the seller.
     * @throws UserNotFoundException if the seller with the given ID is not found.
     * @throws ProductsNotFoundException   if no products were found for the seller.
     */
    @Override
    @PreAuthorize("hasRole('ROLE_SELLER')")
    public OperationResponseDTO createProduct(List<ProductDetailDTO> productsDTO, Long idSeller) {
        ProductMapper productMapper = new ProductMapper();
        User seller = userRepository.getOne(idSeller);
        if(seller.getId() == null) throw new UserNotFoundException("Not found user with this id");
        for(ProductDetailDTO p: productsDTO){
            Product product = productMapper.productDetailDTOToProduct(p);
            product.setSeller(seller);
            productRepository.save(product);
        }
        return OperationResponseDTO.builder()
                .code(null)
                .message("The products has been created")
                .operation(201).build();
    }

    /**
     * Updates a product in the database.
     * This method fetches the product by its ID, updates its details with the provided ProductDetailDTO,
     * and saves the changes to the database.
     *
     * @param idSeller The ID of the seller.
     * @param idProduct The ID of the product to update.
     * @param productDetailDTO The updated details of the product.
     * @return An OperationResponseDTO object indicating the result of the operation.
     * @throws UserNotFoundException if the seller with the given ID is not found.
     * @throws ProductNotFoundException if the product with the given ID is not found.
     */
    @Override
    @PreAuthorize("hasRole('ROLE_SELLER')")
    public OperationResponseDTO updateProduct(Long idSeller, Long idProduct, ProductDetailDTO productDetailDTO) {
        ProductMapper productMapper = new ProductMapper();
        User seller = userRepository.getOne(idSeller);
        if(seller.getId() == null) throw new UserNotFoundException("Not found user with this id");
        Product product = productMapper.productDetailDTOToProduct(productDetailDTO);
        product.setSeller(seller);
        product.setId(idProduct);
        Product productResponse = productRepository.save(product);
        return OperationResponseDTO.builder()
                .code(productResponse.getId().intValue())
                .message("The product has been updated")
                .operation(200).build();
    }

    /**
     * Converts a map of warehouse stock quantities to a ProductStockDTO.
     * This method creates a ProductStockDTO object and populates it with the
     * product ID and a list of WarehouseProduct objects representing the stock
     * quantities in each warehouse.
     *
     * @param productId         The ID of the product.
     * @param stockPerWarehouse A map where the key is the warehouse ID and the value is the stock quantity.
     * @return A ProductStockDTO object containing the product ID and a list of warehouse stock quantities.
     */
    public ProductStockDTO convertMapToProductStockDTO(Long productId, Map<Long, Integer> stockPerWarehouse) {
        ProductStockDTO productStockDTO = new ProductStockDTO();
        productStockDTO.setProductId(productId);
        List<WarehouseProduct> warehouseProduct = stockPerWarehouse.entrySet().stream()
                .map(entry -> new WarehouseProduct(entry.getKey(), entry.getValue()))
                .filter(x -> x.getQuantity() > 0)
                .toList();
        productStockDTO.setWarehouseProducts(warehouseProduct);
        return productStockDTO;
    }
}