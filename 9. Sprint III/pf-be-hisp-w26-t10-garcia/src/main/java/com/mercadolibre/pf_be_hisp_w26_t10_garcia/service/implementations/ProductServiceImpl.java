package com.mercadolibre.pf_be_hisp_w26_t10_garcia.service.implementations;

import com.mercadolibre.pf_be_hisp_w26_t10_garcia.dtos.*;
import com.mercadolibre.pf_be_hisp_w26_t10_garcia.entity.Product;
import com.mercadolibre.pf_be_hisp_w26_t10_garcia.entity.UserAccount;
import com.mercadolibre.pf_be_hisp_w26_t10_garcia.exceptions.NotFoundException;
import com.mercadolibre.pf_be_hisp_w26_t10_garcia.repository.ICategoryRepository;
import com.mercadolibre.pf_be_hisp_w26_t10_garcia.repository.IProductRepository;
import com.mercadolibre.pf_be_hisp_w26_t10_garcia.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class ProductServiceImpl implements IProductService {

    private static final Integer CATEGORY_DEFAULT = 1;

    @Autowired
    private IProductRepository productRepository;

    @Autowired
    private UserServiceImpl userService;

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

    private Product findWithoutId(Product product) {
        return productRepository.findByCategoryAndNameAndSeller
                (product.getCategory(),product.getName(),product.getSeller()).orElse(null);
    }

    @Override
    public ProductsOperationResponseDTO saveProducts(ProductsRequestDTO products, Long sellerId) {
         AtomicReference<Integer> cantProductSave = new AtomicReference<>(0);
         products.getProducts().forEach(product -> {
                   Product productSave = findWithoutId(convertProductResquestSellerDTOToProduct(product, sellerId));
                     if (productSave == null) {
                         productSave = convertProductResquestSellerDTOToProduct(product, sellerId);
                         productRepository.save(productSave);
                         cantProductSave.getAndSet(cantProductSave.get() + 1);
                     }
                 }
         );

         return new ProductsOperationResponseDTO(cantProductSave.get(),"Created products",201);
    }

    @Override
    public ProductsOperationResponseDTO update(Integer idProduct, Long idSeller, ProductSellerRequestDTO product) {
        Product productUpdate= findById(idProduct);
        productUpdate.setName(product.getProduct_desc());
        productUpdate.setPrice(product.getPrice());
        productRepository.save(productUpdate);
        return new ProductsOperationResponseDTO(1, "Updated product", 200 );
    }

    private Product convertProductResquestSellerDTOToProduct(ProductSellerRequestDTO product, Long sellerId) {
        Product productSave = new Product();
        productSave.setCategory(categoryRepository.getReferenceById(CATEGORY_DEFAULT));
        productSave.setName(product.getProduct_desc());
        productSave.setPrice(product.getPrice());
        productSave.setSeller(userService.findById(sellerId));
        return productSave;
    }

    @Override
    public List<ProductSellerResponseDTO> findProductBySellerId(Long id) {
        UserAccount account = userService.findById(id);
        return convertToListProductSellerDTO(productRepository.findBySeller(account));
    }

    @Override
    public ProductsOperationResponseDTO updateProducts(ProductUpdateRequestDTO products, Long idSeller) {
        AtomicReference<Integer> cantProductUpdate = new AtomicReference<>(0);
        products.getProducts().forEach(product -> {
            update(product.getProduct_id(), idSeller,
                    new ProductSellerRequestDTO(product.getProduct_desc(),product.getPrice()));
            cantProductUpdate.getAndSet(cantProductUpdate.get() + 1);
        });

        return new ProductsOperationResponseDTO(cantProductUpdate.get(), "Updated products", 200 );
    }



    private List<ProductSellerResponseDTO> convertToListProductSellerDTO(List<Product> products) {
        return products.stream().map(this::convertToProductSellerDTO).toList();
    }

    private ProductSellerResponseDTO convertToProductSellerDTO(Product product) {
        ProductSellerResponseDTO productSellerDTO = new ProductSellerResponseDTO();
        productSellerDTO.setProduct_id(product.getId());
        productSellerDTO.setProduct_desc(product.getName());
        productSellerDTO.setPrice(product.getPrice());

        return productSellerDTO;
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


}
