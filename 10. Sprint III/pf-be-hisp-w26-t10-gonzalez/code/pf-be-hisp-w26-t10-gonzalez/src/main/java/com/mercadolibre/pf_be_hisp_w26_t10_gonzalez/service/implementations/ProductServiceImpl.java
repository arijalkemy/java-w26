package com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.service.implementations;

import com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.dtos.*;
import com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.entity.Category;
import com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.entity.Product;
import com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.entity.UserAccount;
import com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.exceptions.BadRequestException;
import com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.exceptions.NotFoundException;
import com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.repository.ICategoryRepository;
import com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.repository.IProductRepository;
import com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.repository.IUserAccountRepository;
import com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductRepository productRepository;
    @Autowired
    private IUserAccountRepository userAccountRepository;
    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public Product findById(Integer id) {
        Optional<Product> product = productRepository.findById(id);

        if (product.isPresent()) {
            return product.get();
        }else {
            throw new NotFoundException("Product not found");
        }
    }


    /**
     * Get all inventory by item and warehouse
     *
     * @param idProduct product identifier to search
     * @return information about the item in all warehouse
     */
    @Override
    public CheckInventoryResponseDto getProductWh(Integer idProduct) {
        /* The number of units of the item per warehouse is consulted in the repository. */
        List<InventoryByWarehouseDto> inventoryByWarehouseDto = productRepository.getWhData(idProduct);
        /* The existence of data in the repository is validated. */
        if (!inventoryByWarehouseDto.isEmpty()) {
            /* The object is returned. */
            return new CheckInventoryResponseDto(idProduct, inventoryByWarehouseDto);
        } else {
            /* In case no existing unit is found, an error must be returned. */
            throw new NotFoundException("No se encuentra inventario en ningun almacen del producto " + idProduct);
        }
    }

    /**
     * OBTIENE UNA LISTA CON TODOS LOS PRODUCTOS EN LA BD
     * Si la lista de productos está vacía
     * @throws NotFoundException
     * Si obtiene exitosamente la lista
     * @return List products
     */
    @Override
    @Transactional
    public List<ProductsGeneralDto> getProducts() {
        List<Product> products = productRepository.findAll();
        if (products.isEmpty())
            throw new NotFoundException("No existen productos");

        return products.stream()
                .map(p -> new ProductsGeneralDto(p.getName(),p.getPrice())).toList();
    }

    /**
     * @param category String
     * @return "List<Product>" List Products by category
     */
    @Override
    public List<ProductsGeneralDto> findProductsByCategory(String category) {
        List<Product> products = productRepository.findAllByCategory_Name(category);
        if (products.isEmpty())
            throw new NotFoundException("No existe la lista de productos de la categoria proporcionada");
        return products.stream()
                .map(p -> new ProductsGeneralDto(p.getName(),p.getPrice())).toList();
    }

    /**
     * Insercion de productos de un seller
     * @param products
     * @param seller_id
     * @return {@link ProductUS6Response}
     */
    @Override
    public ProductUS6Response insertProducts(List<ProductUS6Dto> products, Integer seller_id) {
        /* Verificar que el vendedor exista */
        Optional<UserAccount> seller = userAccountRepository.findById(seller_id.longValue());
        if(!seller.isPresent()){
            String message = String.format("The seller with ID: %d does not exists", seller_id);
            throw new NotFoundException(message);
        }
        if(!seller.get().getUserRole().name().equals("SELLER")){
            String message = String.format("The user with the id: %d is not a seller", seller_id);
            throw new BadRequestException(message);
        }

        /* Localizar categoria base */
        Optional<Category> category = categoryRepository.findById(1);

        /* insertar los productos */
        products.parallelStream()
                .forEach(product -> {
                    productRepository.save(
                            createProduct(
                                    product,
                                    category.get(),
                                    seller.get()
                            )
                    );
                });

        return ProductUS6Response.builder()
                .code(1000)
                .message(String.format("Productos insertados y asociados al vendedor con id %d", seller_id))
                .operation(1000)
                .build();
    }

    /**
     * Actualizacion de productos de un seller
     * @param product
     * @param product_id
     * @param seller_id
     * @return {@link ProductUS6Response}
     */
    @Override
    public ProductUS6Response updateProducts(ProductUS6Dto product, Integer product_id, Integer seller_id){
        /* Verificar que el vendedor exista */
        Optional<UserAccount> seller = userAccountRepository.findById(seller_id.longValue());
        if(!seller.isPresent()){
            String message = String.format("The seller with ID: %d does not exists", seller_id);
            throw new NotFoundException(message);
        }

        /* Verificar que el vendedor tenga rol de SELLLEr */
        if(!seller.get().getUserRole().name().equals("SELLER")){
            String message = String.format("The user with the id: %d is not a seller", seller_id);
            throw new BadRequestException(message);
        }

        /* Verificar que el producto exista */
        Optional<Product> productToUpdate = productRepository.findById(product_id);
        if(productToUpdate.isEmpty()){
            String message = String.format("The product with the id %d doest not exist", product_id);
            throw new NotFoundException(message);
        }

        /* Actualizacion del producto existente */
        productRepository.updateNameAndPrice(
                productToUpdate.get().getId(),
                product.getProduct_desc(),
                product.getPrice(),
                seller.get().getUserId().intValue()
        );

        return ProductUS6Response.builder()
                .code(1000)
                .message(String.format("Producto con el id: %d asociado al vendedor %d", product_id, seller_id))
                .operation(1000)
                .build();
    }

    /**
     * Retornar una lista de productos dentro de un rango especifico
     * @param lowPriceRange
     * @param highPriceRange
     * @return
     */
    @Override
    public List<ProductDto> findProductByPriceRange(Double lowPriceRange, Double highPriceRange) {
        if(lowPriceRange < 0 || highPriceRange < 0){
            throw new BadRequestException("The prices ranges cannot be under zero");
        }

        List<Product> productsToReturn = productRepository.findProductByPriceRange(lowPriceRange, highPriceRange);
        return productsToReturn.parallelStream().map(product -> new ProductDto(product.getName(), product.getPrice())).toList();
    }


    /**
     * Retornar una lista de productos que contengan una palabra clave
     * @param keyword
     * @return {@link List<Product>}
     */
    @Override
    public List<ProductDto> findByKeyword(String keyword) {
        List<Product> productsByKeyword = productRepository.findProductsByKeyword(keyword);
        return productsByKeyword.parallelStream().map(product -> new ProductDto(product.getName(), product.getPrice())).toList();
    }


    private Product createProduct(ProductUS6Dto product, Category category, UserAccount seller){
        return Product.builder().name(product.getProduct_desc()).price(product.getPrice()).category(category).seller(seller).build();
    }

}
