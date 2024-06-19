package com.mercadolibre.pf_be_hisp_w26_t10_mcaldera.service.implementations;

import com.mercadolibre.pf_be_hisp_w26_t10_mcaldera.dtos.*;
import com.mercadolibre.pf_be_hisp_w26_t10_mcaldera.entity.Category;
import com.mercadolibre.pf_be_hisp_w26_t10_mcaldera.entity.Product;
import com.mercadolibre.pf_be_hisp_w26_t10_mcaldera.exceptions.ForbiddenException;
import com.mercadolibre.pf_be_hisp_w26_t10_mcaldera.exceptions.NotAcceptable;
import com.mercadolibre.pf_be_hisp_w26_t10_mcaldera.exceptions.NotFoundException;
import com.mercadolibre.pf_be_hisp_w26_t10_mcaldera.repository.ICategoryRepository;
import com.mercadolibre.pf_be_hisp_w26_t10_mcaldera.repository.IProductRepository;
import com.mercadolibre.pf_be_hisp_w26_t10_mcaldera.repository.IUserAccountRepository;
import com.mercadolibre.pf_be_hisp_w26_t10_mcaldera.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductRepository productRepository;

    @Autowired
    IUserAccountRepository userRepository;

    @Autowired
    ICategoryRepository categoryRepository;

    @Override
    public Product findById(Integer id) {
        Optional<Product> product = productRepository.findById(id);

        if (product.isPresent()) {
            return product.get();
        } else {
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
     *
     * @return List products
     * @throws NotFoundException Si obtiene exitosamente la lista
     */
    @Override
    @Transactional
    public List<ProductsGeneralDto> getProducts() {
        List<Product> products = productRepository.findAll();
        if (products.isEmpty())
            throw new NotFoundException("No existen productos");

        return products.stream()
                .map(p -> new ProductsGeneralDto(p.getName(), p.getPrice())).toList();
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
                .map(p -> new ProductsGeneralDto(p.getName(), p.getPrice())).toList();
    }

    /**
     * Create massive new products
     *
     * @param idSeller       seller identifier
     * @param productListDto product list
     * @return transaction response
     */
    @Override
    public ProductCrudResponseDto createProductCrud(ProductListDto productListDto, String idSeller) {
        /*User role is validated*/
        String userRole = userRepository.validateUserSeller(idSeller);
        if (userRole.equals("SELLER")) {
            /*Iterate by object quantity*/
            for (ProductInfoDto productInfo : productListDto.getProducts()) {
                /*The existence of the product is validated*/
                String idProduct = productRepository.validateProduct(productInfo.getProduct_desc());
                if (idProduct == null) {
                    /*Consecutive id is generated*/
                    Integer maxId = productRepository.getMaxProductId() + 1;
                    /*A default category is obtained*/
                    Optional<Category> category = categoryRepository.findById(4);
                    if (category.isPresent()) {
                        Category categoryList = category.get();
                        /*Record is stored*/
                        Product product = new Product(maxId, categoryList, productInfo.getProduct_desc(), productInfo.getPrice());
                        productRepository.save(product);
                    }
                } else {
                    throw new NotAcceptable("El producto '" + productInfo.getProduct_desc() + "' ya se encuentra registrado");
                }
            }
            return new ProductCrudResponseDto(200, "Productos creados", 202);
        } else {
            throw new ForbiddenException("Acceso no valido para el usuario");
        }
    }

    /**
     * Modify products
     *
     * @param idSeller       seller identifier
     * @param productInfoDto product list
     * @param idProduct      product identifier
     * @return transaction response
     */
    @Override
    public ProductCrudResponseDto changeProduct(String idSeller, Integer idProduct, ProductInfoDto productInfoDto) {
        /*Validates the allowed role*/
        String userRole = userRepository.validateUserSeller(idSeller);
        if (userRole.equals("SELLER")) {
            /*The product is obtained*/
            Optional<Product> product = productRepository.findById(idProduct);
            if (product.isPresent()) {
                /*The registry is modified and updated*/
                Product productToChange = product.get();
                productToChange.setPrice(productInfoDto.getPrice());
                productToChange.setName(productInfoDto.getProduct_desc());
                productRepository.saveAndFlush(productToChange);
            } else {
                throw new NotFoundException("El producto con el id '" + idProduct + "' no esta registrado en el sistema");
            }
        } else {
            throw new ForbiddenException("El usuario no tiene acceso a este proceso");
        }
        return new ProductCrudResponseDto(200, "Se actualizo el proceso de manera correcta", 200);
    }

    /**
     * Get all products created by sellers
     *
     * @return transaction response
     */
    @Override
    public List<AllProductsBySellerDto> getAllProductSellerInfo() {
        List<AllProductsBySellerDto> productsList = productRepository.getAllProductsBySeller(4);
        if (!productsList.isEmpty()) {
            return productsList;
        } else {
            throw new NotFoundException("No hay productos registrados por sellers");
        }
    }

    /**
     * Remove products created by sellers
     *
     * @param idSeller  seller identifier
     * @param idProduct product identifier
     * @return transaction response
     */
    @Override
    public ProductCrudResponseDto removeProductsBySeller(String idSeller, Integer idProduct) {
        /*Validates the allowed role*/
        String userRole = userRepository.validateUserSeller(idSeller);
        if (!Objects.equals(userRole, "SUPERVISOR")) {
            throw new ForbiddenException("Este usuario no tiene acceso a esta herrmaienta");
        }
        Optional<Product> product = productRepository.findById(idProduct);
        if (product.isPresent()) {
            productRepository.deleteById(idProduct);
        } else {
            throw new NotFoundException("El producto no se encuentra registrado");
        }
        return new ProductCrudResponseDto(200, "Se ha eliminado el registro", 202);
    }
}
