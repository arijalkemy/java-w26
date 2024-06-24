package com.mercadolibre.project_java_w26_team13.repository;
import com.mercadolibre.project_java_w26_team13.entity.Batch;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;
import com.mercadolibre.project_java_w26_team13.entity.Product;
import org.springframework.stereotype.Repository;

@Repository
public interface IBatchRepository extends JpaRepository<Batch, Long> {
    List<Batch> findAllByProductId(long productId);
    List<Batch> findAllByDueDateBetween(LocalDate startDate, LocalDate endDate);
    List<Batch> findByProduct(Product product);
    List<Batch> findByProductId(long productId);
}
