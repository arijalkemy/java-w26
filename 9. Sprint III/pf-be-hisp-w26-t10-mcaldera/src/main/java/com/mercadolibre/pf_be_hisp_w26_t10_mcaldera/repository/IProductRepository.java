package com.mercadolibre.pf_be_hisp_w26_t10_mcaldera.repository;

import com.mercadolibre.pf_be_hisp_w26_t10_mcaldera.dtos.AllProductsBySellerDto;
import com.mercadolibre.pf_be_hisp_w26_t10_mcaldera.dtos.InventoryByWarehouseDto;
import com.mercadolibre.pf_be_hisp_w26_t10_mcaldera.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IProductRepository extends JpaRepository<Product, Integer> {
    Product findProductById(Integer id);

    /**
     * Search inventory data by item
     *
     * @param product_id Item number to search in warehauses
     * @return All information about inventory quantity in different warehauses
     */
    @Query("select new com.mercadolibre.pf_be_hisp_w26_t10_mcaldera.dtos.InventoryByWarehouseDto (w.id, sum(b.initialQuantity)) from Product p inner join Batch b on p.id = b.product.id inner join Sector s on b.sector.id = s.id inner join Warehouse w on s.warehouse.id = w.id where p.id = :product_id group by w.id")
    List<InventoryByWarehouseDto> getWhData(@Param("product_id") Integer product_id);

    List<Product> findAll();

    /**
     * @return Lista de vehiculos de una categoria especificada
     */
    List<Product> findAllByCategory_Name(String name);

    /**
     * Validate id exists
     *
     * @param product_desc Product description
     * @return id exists
     */
    @Query("select id from Product where name = :product_desc")
    String validateProduct(@Param("product_desc") String product_desc);

    /**
     * Get id max
     *
     * @return Max id
     */
    @Query("select max(id) from Product")
    Integer getMaxProductId();

    /**
     * Get Product info to return
     *
     * @param category_id category identifier
     * @return information dto
     */
    @Query("select new com.mercadolibre.pf_be_hisp_w26_t10_mcaldera.dtos.AllProductsBySellerDto (p.id, p.name, p.price, c.id, c.name) from Product p inner join Category c on p.category.id = c.id where c.id = :category_id")
    List<AllProductsBySellerDto> getAllProductsBySeller(@Param("category_id") Integer category_id);
}