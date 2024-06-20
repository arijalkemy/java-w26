package com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.repository;

import com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.dtos.InventoryByWarehouseDto;
import com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.entity.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IProductRepository extends JpaRepository<Product, Integer> {
    Product findProductById(Integer id);

    /**
     * Search inventory data by item
     *
     * @param product_id Item number to search in warehauses
     * @return All information about inventory quantity in different warehauses
     */
    @Query("select new com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.dtos.InventoryByWarehouseDto (w.id, sum(b.initialQuantity)) from Product p inner join Batch b on p.id = b.product.id inner join Sector s on b.sector.id = s.id inner join Warehouse w on s.warehouse.id = w.id where p.id = :product_id group by w.id")
    List<InventoryByWarehouseDto> getWhData(@Param("product_id") Integer product_id);

    List<Product> findAll();

    /**
     * @return Lista de vehiculos de una categoria especificada
     */
    List<Product> findAllByCategory_Name(String name);

    @Query("select p from Product p where p.name = :name and p.price = :price and p.seller.userId = :idSeller")
    Optional<Product> findByNameAndPrice(@Param("name") String name, @Param("price") Double price, @Param("idSeller") Integer idSeller);

    /**
     * Actualiza el nombre y precio de un producto.
     *
     * @param productId ID del producto que se actualizará.
     * @param newName   Nuevo nombre del producto.
     * @param newPrice  Nuevo precio del producto.
     * @return El número de registros actualizados (debería ser 1 si el ID existe).
     */
    @Transactional
    @Modifying
    @Query("update Product p set p.name = :newName, p.price = :newPrice, p.seller.userId = :sellerId where p.id = :productId")
    void updateNameAndPrice(
            @Param("productId") Integer productId,
            @Param("newName") String newName,
            @Param("newPrice") Double newPrice,
            @Param("sellerId") Integer sellerId
    );

    /**
     * Retorna una lista de precios por range de precios
     * @param lowPriceRange
     * @param highPriceRange
     * @return {@link List<Product>}
     */
    @Transactional
    @Query("select p from Product p where p.price >= :lowPriceRange and p.price <= :highPriceRange")
    List<Product> findProductByPriceRange(@Param("lowPriceRange") Double lowPriceRange,
                                          @Param("highPriceRange") Double highPriceRange);

    /**
     * Retorna una lista de productos por keyword
     * @param keyword
     * @return {@link List<Product>}
     */
    @Transactional
    @Query("select p from Product p where lower(p.name) LIKE %:keyword%")
    List<Product> findProductsByKeyword(@Param("keyword") String keyword);
}