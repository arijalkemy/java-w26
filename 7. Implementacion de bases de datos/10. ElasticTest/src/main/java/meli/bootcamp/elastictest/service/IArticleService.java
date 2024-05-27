package meli.bootcamp.elastictest.service;

import meli.bootcamp.elastictest.model.Article;

import java.util.List;

public interface IArticleService {
    Article createArticle( Article article);
    Iterable<Article> getArticles();
}
