package bootcamp.bendezujonathan.elastichsearch.repository.interfaces;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import bootcamp.bendezujonathan.elastichsearch.model.Article;

public interface ArticleRepository  extends ElasticsearchRepository<Article, Long>{

    
}
