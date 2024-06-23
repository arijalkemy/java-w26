package com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.repository.interfaces;

import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.enums.TypeProduct;
import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.model.Batch;
import org.springframework.data.jpa.repository.EntityGraph;
import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.model.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.Optional;
import java.util.List;

@Repository
public interface IBatchRepository extends JpaRepository<Batch, Integer> {
    @EntityGraph(attributePaths = {"product", "sector", "sector.warehouse"})
    List<Batch> findAllByProductIdAndDueDateGreaterThanEqualOrderByBatchNumber(
            Integer productId, LocalDate expirationDate
    );

    @EntityGraph(attributePaths = {"product", "sector", "sector.warehouse"})
    List<Batch> findAllByProductIdAndDueDateGreaterThanEqualOrderByCurrentQuantity(
            Integer productId, LocalDate expirationDate
    );

    @Query(
            "select w from Batch b " +
                    "join Sector s on b.sector.id = s.id " +
                    "join Warehouse w on s.warehouse.id = w.id " +
                    "where b.product.id = :idProduct " + "and b.dueDate >= :expirationDate " +
                    "group by s.warehouse.id, s.id " +
                    "having sum(b.currentQuantity) >= :quantity "
    )
    Optional<Warehouse> findFirstStockOfAProductByProductIdAndExpirationDate  (
            Integer idProduct, LocalDate expirationDate, Integer quantity
    );


    @EntityGraph(attributePaths = {"product", "sector", "sector.warehouse"})
    List<Batch> findAllByProductIdAndDueDateGreaterThanEqualOrderByDueDate(
            Integer productId, LocalDate expirationDate
    );

    @EntityGraph(attributePaths = {"sector", "sector.warehouse"})
    List<Batch> findAllByProductId(int idProduct);

    //Primera fecha es la cantidad de días a maximos a vencer dado por el usuario.
    //La segunda fecha es el día de hoy.
    @EntityGraph(attributePaths = {"product", "sector", "sector.warehouse", "sector.warehouse.manager"})
    List<Batch> findAllBySector_Warehouse_Manager_IdAndDueDateLessThanEqualAndDueDateGreaterThanEqualOrderByDueDateAsc(
            Integer managerId, LocalDate maxExpirationDate, LocalDate minExpirationDate
    );

    public Optional<Batch> findByBatchNumber(String batchNumber);

    @EntityGraph(attributePaths = {"product", "sector", "sector.warehouse", "sector.warehouse.manager"})
    List<Batch> findAllBySector_Warehouse_Manager_IdAndDueDateLessThanEqualAndDueDateGreaterThanEqualOrderByDueDateDesc(
            Integer managerId, LocalDate maxExpirationDate, LocalDate minExpirationDate
    );

    @EntityGraph(attributePaths = {"product", "sector", "sector.warehouse", "sector.warehouse.manager"})
    List<Batch> findAllBySector_Warehouse_Manager_IdAndDueDateLessThanEqualAndDueDateGreaterThanEqualAndProduct_TypeOrderByDueDate(
            Integer productId, LocalDate maxExpirationDate, LocalDate minExpirationDate, TypeProduct type
    );

    @EntityGraph(attributePaths = {"product", "sector", "sector.warehouse", "sector.warehouse.manager"})
    List<Batch> findAllBySector_Warehouse_Manager_IdAndDueDateLessThanEqualAndDueDateGreaterThanEqualAndProduct_TypeOrderByDueDateDesc(
            Integer managerId, LocalDate maxExpirationDate, LocalDate minExpirationDate, TypeProduct type
    );
}