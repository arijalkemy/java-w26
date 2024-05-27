package meli.bootcamp.elastictest.repository;

import meli.bootcamp.elastictest.model.Article;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IArticleRepository extends ElasticsearchRepository<Article, String> {

}
