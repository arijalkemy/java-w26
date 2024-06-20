package com.mercadolibre.fresh_market.service.impl;

import com.mercadolibre.fresh_market.config.exception.BadRequestException;
import com.mercadolibre.fresh_market.config.exception.CategoryBadRequestException;
import com.mercadolibre.fresh_market.config.exception.ProductNotFoundException;
import com.mercadolibre.fresh_market.config.exception.ProductsNotFoundException;
import com.mercadolibre.fresh_market.dtos.product.ProductDetailDTO;
import com.mercadolibre.fresh_market.dtos.ProductStockDTO;
import com.mercadolibre.fresh_market.dtos.WarehouseProduct;
import com.mercadolibre.fresh_market.dtos.product.ProductReqDTO;
import com.mercadolibre.fresh_market.dtos.product.ProductResDTO;
import com.mercadolibre.fresh_market.mapper.ProductMapper;
import com.mercadolibre.fresh_market.model.*;
import com.mercadolibre.fresh_market.model.enums.Category;
import com.mercadolibre.fresh_market.repository.IBatchRepository;
import com.mercadolibre.fresh_market.repository.IProductRepository;
import com.mercadolibre.fresh_market.repository.ISectionRepository;
import com.mercadolibre.fresh_market.repository.IWarehouseRepository;
import com.mercadolibre.fresh_market.service.IProductService;
import com.mercadolibre.fresh_market.service.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements IProductService {

    private final IProductRepository productRepository;
    private final IBatchRepository batchRepository;
    private final IWarehouseRepository warehouseRepository;
    private final ISectionRepository sectionRepository;
    private final IUserService userService;

    // Constants
    private static final String WITHOUT_PRODUCTS = "Without products to process.";
    private static final Integer ZERO = 0;
    private static final Integer ONE_PRODUCT = 1;

    public ProductServiceImpl(IProductRepository productRepository,
                              IBatchRepository batchRepository, IWarehouseRepository warehouseRepository,
                              ISectionRepository sectionRepository, IUserService userService) {
        this.productRepository = productRepository;
        this.batchRepository = batchRepository;
        this.warehouseRepository = warehouseRepository;
        this.sectionRepository = sectionRepository;
        this.userService = userService;
    }


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
        Product product = productRepository.findById(productId).orElseThrow(
                () -> new ProductNotFoundException("The product with ID " + productId + " was not found."));

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
        return products.stream().map(ProductMapper::productToProductDetailDTO).toList();
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
        if (!category.equals("FF") && !category.equals("RF") && !category.equals("FS")) {
            throw new CategoryBadRequestException("This category is not valid: " + category);
        }
        List<Product> products = batchRepository.findDistinctProductsByCategory(Category.valueOf(category));
        if (products.isEmpty()) {
            throw new ProductsNotFoundException("No products were found in the category: " + category);
        }
        return products.stream().map(ProductMapper::productToProductDetailDTO).toList();
    }

    /**
     * Creates new products for a specified seller.
     * Validates the seller, checks for existing products, and saves new products if they do not already exist.
     *
     * @author jsanchezpimi
     * @param productReqDTO the request containing the products to create.
     * @param sellerId the ID of the seller creating the products.
     * @return a {@link ProductResDTO} with the creation result and message.
     * @throws BadRequestException if the product request is invalid or null.
     */
    @Override
    @Transactional(readOnly = false)
    public ProductResDTO createProducts(ProductReqDTO productReqDTO, Long sellerId) {

        User user = userService.validateUserSeller(sellerId);

        List<Product> products = getProductsExists(productReqDTO);

        if (products.size() != productReqDTO.getProducts().size())
            return new ProductResDTO(ZERO, "There are Products already exist.", HttpStatus.OK.value());

        products.forEach(product -> product.setSeller(user));
        productRepository.saveAll(products);

        return new ProductResDTO(products.size(),
                "Products created successfully.", HttpStatus.CREATED.value());
    }

    /**
     * Retrieves a list of existing products from the provided product request.
     * Filters the products based on their existence in the repository by description.
     *
     * @param productReqDTO the product request containing products to check.
     * @return a list of existing products.
     * @throws BadRequestException if the product request is null, empty, or contains no valid products.
     */
    public List<Product> getProductsExists(ProductReqDTO productReqDTO) {

        if (productReqDTO == null ||
                productReqDTO.getProducts() == null ||
                productReqDTO.getProducts().isEmpty())
            throw new BadRequestException(WITHOUT_PRODUCTS);

        return productReqDTO.getProducts().stream()
                .filter(product -> productRepository.existsByDescription(product.getDescription()))
                .map(ProductMapper::productDetailDTOToProduct)
                .toList();
    }

    /**
     * Updates the specified product's details.
     * Validates the seller, updates the product's price and description,
     * and saves the changes to the repository.
     *
     * @author jsanchezpimi
     * @param productDetailDTO the new details of the product.
     * @param sellerId the ID of the seller.
     * @param productId the ID of the product to update.
     * @return a {@link ProductResDTO} with the update result.
     * @throws BadRequestException if the product details are null.
     * @throws ProductNotFoundException if the product does not exist.
     */
    @Override
    @Transactional(readOnly = false)
    public ProductResDTO updateProduct(ProductDetailDTO productDetailDTO, Long sellerId, Long productId) {

        userService.validateUserSeller(sellerId);

        if (productDetailDTO == null)
            throw new BadRequestException(WITHOUT_PRODUCTS);

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException("Product not found."));

        product.setPrice(productDetailDTO.getPrice());
        product.setDescription(productDetailDTO.getDescription());

        productRepository.save(product);

        return new ProductResDTO(ONE_PRODUCT,
                "Product update successfully.", HttpStatus.CREATED.value());
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
