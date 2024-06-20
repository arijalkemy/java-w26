package com.mercadolibre.pf_be_hisp_w26_t10_meza.service.implementations;

import com.mercadolibre.pf_be_hisp_w26_t10_meza.dtos.CheckInventoryResponseDto;
import com.mercadolibre.pf_be_hisp_w26_t10_meza.dtos.InventoryByWarehouseDto;
import com.mercadolibre.pf_be_hisp_w26_t10_meza.dtos.ProductsGeneralDto;
import com.mercadolibre.pf_be_hisp_w26_t10_meza.dtos.product.ProductInfoDto;
import com.mercadolibre.pf_be_hisp_w26_t10_meza.dtos.product.ProductLoadRequestDto;
import com.mercadolibre.pf_be_hisp_w26_t10_meza.dtos.product.ProductLoadResponseDto;
import com.mercadolibre.pf_be_hisp_w26_t10_meza.entity.Category;
import com.mercadolibre.pf_be_hisp_w26_t10_meza.entity.Product;
import com.mercadolibre.pf_be_hisp_w26_t10_meza.entity.Rol;
import com.mercadolibre.pf_be_hisp_w26_t10_meza.entity.UserAccount;
import com.mercadolibre.pf_be_hisp_w26_t10_meza.exceptions.NoAccessException;
import com.mercadolibre.pf_be_hisp_w26_t10_meza.exceptions.NotFoundException;
import com.mercadolibre.pf_be_hisp_w26_t10_meza.repository.ICategoryRepository;
import com.mercadolibre.pf_be_hisp_w26_t10_meza.repository.IProductRepository;
import com.mercadolibre.pf_be_hisp_w26_t10_meza.repository.IUserAccountRepository;
import com.mercadolibre.pf_be_hisp_w26_t10_meza.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
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

    private void SellerValidation(Long idSeller){
        //Validating if the seller exist
        Optional<UserAccount> posibleUser = userAccountRepository.findById(idSeller);

        if (!posibleUser.isPresent()){
            throw new NotFoundException("There is no user with id: " + idSeller);
        }

        //Validating if the user is a Seller
        Rol rolUser = posibleUser.get().getUserRole();
        if (!(rolUser == Rol.SELLER)){
            throw new NoAccessException("No access to register a product because you have no Seller acount");
        }
    }

    private void categoryValidation(Integer productCategory) {
        Optional<Category> posibleCategory = categoryRepository.findById(productCategory);

        if (!posibleCategory.isPresent()){
            throw new NotFoundException("There is no category with id " + productCategory);
        }
    }

    private void setNewProductOrUpdateProduct(Product product, String productName, Double productPrice, Category category) {

        product.setName(productName);
        product.setPrice(productPrice);
        product.setCategory(category);

        productRepository.save(product);
    }

    @Override
    public ProductLoadResponseDto productRegister(ProductLoadRequestDto productLoadRequestDto, Long idSeller) {

        SellerValidation(idSeller);

        //Validating if the category exist
        for (ProductInfoDto p: productLoadRequestDto.getProductInfoDtoList()) {
            categoryValidation(p.getProductCategory());
        }


        for (ProductInfoDto p: productLoadRequestDto.getProductInfoDtoList()) {
            Optional<Category> posibleCategory = categoryRepository.findById(p.getProductCategory());
            Product newProduct = new Product();
            setNewProductOrUpdateProduct( newProduct ,p.getProductName(), p.getPrice(), posibleCategory.get());

        }

        ProductLoadResponseDto productLoadResponseDto = new ProductLoadResponseDto();
        productLoadResponseDto.setCode(201);
        productLoadResponseDto.setOperation(901);
        productLoadResponseDto.setMessage("Products register successfully");

        return productLoadResponseDto;
    }

    @Override
    public ProductLoadResponseDto updateProduct(ProductInfoDto productInfoDto, Long idSeller, Integer idProduct) {

        SellerValidation(idSeller);

        Optional<Product> posibleProduct = productRepository.findById(idProduct);

        if (!posibleProduct.isPresent()){
            throw new NotFoundException("There is no product with id : " + idProduct);
        }

        categoryValidation(productInfoDto.getProductCategory());

        Optional<Category> posibleCategory = categoryRepository.findById(productInfoDto.getProductCategory());

        setNewProductOrUpdateProduct(posibleProduct.get(), productInfoDto.getProductName(), productInfoDto.getPrice(), posibleCategory.get());

        ProductLoadResponseDto productLoadResponseDto = new ProductLoadResponseDto();
        productLoadResponseDto.setCode(201);
        productLoadResponseDto.setOperation(1001);
        productLoadResponseDto.setMessage("Products updated successfully");

        return productLoadResponseDto;
    }
}
