package com.ecnantes.springFirstProject;

import com.ecnantes.springFirstProject.Model.ArticleModel;
import com.ecnantes.springFirstProject.Model.Statut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/article")
public class ArticleController {

    private Logger logger = LoggerFactory.getLogger(ArticleController.class);

    @GetMapping
    public ResponseEntity<ArticleModel> getArticle(HttpSession session) {
        ArticleModel article = (ArticleModel) session.getAttribute("article");
        if(article == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(article);
    }

    @PostMapping
    public ArticleModel creerArticle(@RequestBody ArticleModel article, HttpSession session) {
        if(article.getAuteur() == null) {
            logger.error("L'article n'a pas d'auteur");
            return null;
        } else {
            logger.info("Titre {} Auteur {}", article.getTitle(), article.getAuteur());
            session.setAttribute("article", article);
            return  article;
        }
    }
}
