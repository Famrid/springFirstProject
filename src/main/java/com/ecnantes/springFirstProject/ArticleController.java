package com.ecnantes.springFirstProject;

import com.ecnantes.springFirstProject.Model.Article;
import com.ecnantes.springFirstProject.Model.ArticleEntity;
import com.ecnantes.springFirstProject.Model.Categorie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@RestController
@RequestMapping("/article")
public class ArticleController {
    private ArticleRepositery repositery;

    @Autowired
    private CategorieJPARepositery categorieJPARepositery;
    @Autowired
    private ArticleJPARepositery articleJPARepositery;
    private Logger logger = LoggerFactory.getLogger(ArticleController.class);

    public ArticleController(ArticleRepositery repositery) {
        this.repositery = repositery;
    }

    @GetMapping
    public ResponseEntity<ArticleEntity> getArticle(HttpSession session) {
        ArticleEntity article = (ArticleEntity) session.getAttribute("article");
        if(article == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(article);
    }

    @GetMapping("/{id}")
    public ArticleEntity getById(@PathVariable("id") Integer id) {
        ArticleEntity article = this.repositery.getArticleById(id);
        return article;
    }

    @PostMapping
    public ArticleEntity creerArticle(@RequestBody Article article, HttpSession session) {
        if(article.getAuteur() == null) {
            logger.error("L'article n'a pas d'auteur");
            return null;
        } else {
            Categorie categorie;
            categorie = categorieJPARepositery.findById(article.getCategorie_id()).orElse(new Categorie());
            ArticleEntity articleEntity = new ArticleEntity();
            articleEntity.setCorps(article.getCorps());
            articleEntity.setTitle(article.getTitre());
            articleEntity.setCategorie(categorie);
            session.setAttribute("article", article);
            articleJPARepositery.save(articleEntity);
            return articleEntity;
        }
    }
}
