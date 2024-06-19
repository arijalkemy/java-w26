package com.mercadolibre.final_project_java_h_w26_t10.repository;

import com.mercadolibre.final_project_java_h_w26_t10.dtos.InventoryByWarehouseDto;
import com.mercadolibre.final_project_java_h_w26_t10.entity.Product;
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
    @Query("select new com.mercadolibre.final_project_java_h_w26_t10.dtos.InventoryByWarehouseDto (w.id, sum(b.initialQuantity)) from Product p inner join Batch b on p.id = b.product.id inner join Sector s on b.sector.id = s.id inner join Warehouse w on s.warehouse.id = w.id where p.id = :product_id group by w.id")
    List<InventoryByWarehouseDto> getWhData(@Param("product_id") Integer product_id);

    List<Product> findAll();

    /**
     * @return Lista de vehiculos de una categoria especificada
     */
    List<Product> findAllByCategory_Name(String name);
}