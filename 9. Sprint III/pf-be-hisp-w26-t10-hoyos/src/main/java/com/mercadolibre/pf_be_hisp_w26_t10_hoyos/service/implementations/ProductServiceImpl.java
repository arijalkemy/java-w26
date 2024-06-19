package com.mercadolibre.pf_be_hisp_w26_t10_hoyos.service.implementations;

import com.mercadolibre.pf_be_hisp_w26_t10_hoyos.dtos.*;
import com.mercadolibre.pf_be_hisp_w26_t10_hoyos.entity.Product;
import com.mercadolibre.pf_be_hisp_w26_t10_hoyos.entity.UserAccount;
import com.mercadolibre.pf_be_hisp_w26_t10_hoyos.exceptions.NotFoundException;
import com.mercadolibre.pf_be_hisp_w26_t10_hoyos.repository.IProductRepository;
import com.mercadolibre.pf_be_hisp_w26_t10_hoyos.repository.IUserAccountRepository;
import com.mercadolibre.pf_be_hisp_w26_t10_hoyos.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductRepository productRepository;
    @Autowired
    IUserAccountRepository accountRepository;

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

    @Override
    public SellerProductResponseDto createNewSellerProduct(Long id, SellerProductRequestDto sellerList) {
        Random random = new Random();
        SellerProductResponseDto response = new SellerProductResponseDto(1,"Creado con exito",random.nextInt(1000));
        UserAccount account = accountRepository.findByUserId(id);
        if(account != null){
            productRepository.saveAll(sellerList.getProducts().stream().map(e ->  new Product(null,null,e.getName(),e.getPrice(),null,null,account)).toList());
        }else {
            throw new NotFoundException("El usuario no esta registrado");
        }
        return response;
    }

    @Override
    public SellerProductResponseDto updateSellerProduct(Long idSeller, Integer productId, ProductDto product) {
        Random random = new Random();
        Product productFromQuery = productRepository.findByIdAndUserAccountUserId(productId, idSeller);
        if (productFromQuery == null){
            throw new NotFoundException("No se encuentran productos para los parametros de entrada");
        }
        productFromQuery.setName(product.getName());
        productFromQuery.setPrice(product.getPrice());
        productRepository.save(productFromQuery);
        return new SellerProductResponseDto(2,"Actualizaste el producto exitosamente",random.nextInt(1000));
    }

    @Override
    public List<ProductDto> getSellerProducts(Long idSeller) {
        List<Product> productsFromSeller = productRepository.findProductsByUserAccountUserId(idSeller);
        if(productsFromSeller.isEmpty()) {
            throw new NotFoundException("No se han encontrado productos asociados al vendedor");
        }
        return productsFromSeller.stream().map(e->new ProductDto(e.getName(),e.getPrice())).toList();
    }
    @Override
    public SellerProductResponseDto deleteSellerProduct(Integer idProducto){
        Random random = new Random();
        Product productToDelete = productRepository.findProductById(idProducto);
        if(productToDelete == null || productToDelete.getUserAccount() == null){
            throw new NotFoundException("No puedes eliminar un producto que no exista !");
        }
        productRepository.deleteById(idProducto);
        return new SellerProductResponseDto(3,"Has borrado exitosamente el producto con id: "+
                idProducto,random.nextInt(1000));
    }
}
