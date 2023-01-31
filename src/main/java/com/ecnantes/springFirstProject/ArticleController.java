package com.ecnantes.springFirstProject;

import com.ecnantes.springFirstProject.Model.ArticleModel;
import com.ecnantes.springFirstProject.Model.Statut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/article")
public class ArticleController {

    private Logger logger = LoggerFactory.getLogger(ArticleController.class);

    @GetMapping
    public ArticleModel getArticle() {
        ArticleModel article = new ArticleModel();
        article.setAuteur("Lemasson Steven");
        article.setTitle("Toute ma vie!");
        article.setContenu("Hello World!");
        article.setStatut(Statut.PUBLIE);
        return article;
    }

    @PostMapping
    public ArticleModel creerArticle(@RequestBody ArticleModel article) {
        if(article.getAuteur() == null) {
            logger.error("L'article n'a pas d'auteur");
            return null;
        } else {
            logger.info("Titre {} Auteur {}", article.getTitle(), article.getAuteur());
            return  article;
        }
    }
}
