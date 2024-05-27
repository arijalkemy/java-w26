package meli.bootcamp.elastictest.service;

import lombok.RequiredArgsConstructor;
import meli.bootcamp.elastictest.model.Article;
import meli.bootcamp.elastictest.repository.IArticleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleService implements IArticleService{

    private final IArticleRepository articleRepository;

    @Override
    public Article createArticle(Article article) {
        return articleRepository.save(article);
    }

    @Override
    public Iterable<Article> getArticles() {
        return articleRepository.findAll();
    }
}
