package bootcamp.bendezujonathan.cloth.repository.interfaces;

import bootcamp.bendezujonathan.cloth.model.Cloth;
import bootcamp.bendezujonathan.cloth.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SaleRepository  extends JpaRepository<Sale, Long> {

    List<Sale> findAllByFecha(LocalDate toSearch);

    @Query("SELECT sc.cloth FROM Sale s join s.saleDetails sc")
    List<Cloth> findClothBySale(long id);

}
