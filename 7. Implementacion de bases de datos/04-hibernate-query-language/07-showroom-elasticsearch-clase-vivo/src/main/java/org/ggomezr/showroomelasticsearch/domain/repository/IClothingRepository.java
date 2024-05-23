package org.ggomezr.showroomelasticsearch.domain.repository;



import org.ggomezr.showroomelasticsearch.domain.model.Clothing;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IClothingRepository extends ElasticsearchRepository<Clothing, String>{
    List<Clothing> findBySize(String size);
    List<Clothing> findByNameEqualsIgnoreCase(String name);
}
