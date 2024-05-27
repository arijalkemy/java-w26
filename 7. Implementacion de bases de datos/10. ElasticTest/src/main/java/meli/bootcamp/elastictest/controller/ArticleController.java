package meli.bootcamp.elastictest.controller;

import lombok.RequiredArgsConstructor;
import meli.bootcamp.elastictest.model.Article;
import meli.bootcamp.elastictest.service.IArticleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/article")
@RequiredArgsConstructor
public class ArticleController {

    private final IArticleService articleService;

    @PostMapping
    public ResponseEntity<Article> newArticle(@RequestBody Article article){
        return ResponseEntity.ok(articleService.createArticle(article));
    }

    @GetMapping
    public ResponseEntity<?> getAllArticles() {
        return ResponseEntity.ok(articleService.getArticles());
    }
}
