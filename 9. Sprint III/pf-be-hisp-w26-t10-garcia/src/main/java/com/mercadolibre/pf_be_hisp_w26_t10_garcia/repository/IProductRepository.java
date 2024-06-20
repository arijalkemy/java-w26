package com.mercadolibre.pf_be_hisp_w26_t10_garcia.repository;

import com.mercadolibre.pf_be_hisp_w26_t10_garcia.dtos.InventoryByWarehouseDto;
import com.mercadolibre.pf_be_hisp_w26_t10_garcia.dtos.ProductSellerResponseDTO;
import com.mercadolibre.pf_be_hisp_w26_t10_garcia.entity.Category;
import com.mercadolibre.pf_be_hisp_w26_t10_garcia.entity.Product;
import com.mercadolibre.pf_be_hisp_w26_t10_garcia.entity.UserAccount;
import com.mercadolibre.pf_be_hisp_w26_t10_garcia.entity.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IProductRepository extends JpaRepository<Product, Integer> {

    /**
     * Search inventory data by item
     *
     * @param product_id Item number to search in warehauses
     * @return All information about inventory quantity in different warehauses
     */
    @Query("select new com.mercadolibre.pf_be_hisp_w26_t10_garcia.dtos.InventoryByWarehouseDto (w.id, sum(b.initialQuantity)) from Product p inner join Batch b on p.id = b.product.id inner join Sector s on b.sector.id = s.id inner join Warehouse w on s.warehouse.id = w.id where p.id = :product_id group by w.id")
    List<InventoryByWarehouseDto> getWhData(@Param("product_id") Integer product_id);

    Optional<Product> findByCategoryAndNameAndSeller(Category category, String name, UserAccount seller);

    List<Product> findBySeller(UserAccount seller);
    ;

}