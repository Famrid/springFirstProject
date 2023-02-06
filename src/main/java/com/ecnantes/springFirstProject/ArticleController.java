package com.ecnantes.springFirstProject;

import com.ecnantes.springFirstProject.Model.Article;
import com.ecnantes.springFirstProject.Model.ArticleEntity;
import com.ecnantes.springFirstProject.Services.ArticleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/article")
public class ArticleController {
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    private ArticleService articleService;

    @GetMapping
    public ResponseEntity<ArticleEntity> getArticle(HttpSession session) {
        ArticleEntity article = (ArticleEntity) session.getAttribute("article");
        if(article == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(article);
    }

    @GetMapping("/{id}")
    public ArticleEntity getById(@PathVariable("id") Long id) {
        ArticleEntity article = (ArticleEntity) this.articleService.findById(id).get();
        return article;
    }

    @PostMapping
    public ArticleEntity creerArticle(@RequestBody Article article, HttpSession session) {
        return this.articleService.creerArticle(session, article);
    }
}
