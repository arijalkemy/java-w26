package com.mercadolibre.final_project_java_h_w26_t10.service.implementations;

import com.mercadolibre.final_project_java_h_w26_t10.dtos.CheckInventoryResponseDto;
import com.mercadolibre.final_project_java_h_w26_t10.dtos.InventoryByWarehouseDto;
import com.mercadolibre.final_project_java_h_w26_t10.dtos.ProductsGeneralDto;
import com.mercadolibre.final_project_java_h_w26_t10.entity.Product;
import com.mercadolibre.final_project_java_h_w26_t10.exceptions.NotFoundException;
import com.mercadolibre.final_project_java_h_w26_t10.repository.IProductRepository;
import com.mercadolibre.final_project_java_h_w26_t10.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductRepository productRepository;

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
}
