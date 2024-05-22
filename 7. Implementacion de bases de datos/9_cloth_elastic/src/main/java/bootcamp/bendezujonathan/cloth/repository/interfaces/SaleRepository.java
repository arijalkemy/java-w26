package bootcamp.bendezujonathan.cloth.repository.interfaces;

import bootcamp.bendezujonathan.cloth.model.Cloth;
import bootcamp.bendezujonathan.cloth.model.Sale;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SaleRepository  extends ElasticsearchRepository<Sale, String> {

    List<Sale> findAll();
    List<Sale> findAllByFecha(LocalDate toSearch);
//    List<Cloth> findClothBySale(String id);

}
