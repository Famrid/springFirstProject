package com.ecnantes.springFirstProject.Services;

import com.ecnantes.springFirstProject.ArticleJPARepositery;
import com.ecnantes.springFirstProject.CategorieJPARepositery;
import com.ecnantes.springFirstProject.Model.Article;
import com.ecnantes.springFirstProject.Model.ArticleEntity;
import com.ecnantes.springFirstProject.Model.Categorie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Service
@Transactional
public class ArticleService {
    private Logger logger = LoggerFactory.getLogger(ArticleService.class);

    private ArticleJPARepositery articleJPARepositery;
    private CategorieJPARepositery categorieJPARepositery;

    public ArticleService(ArticleJPARepositery articleJPARepositery, CategorieJPARepositery categorieJPARepositery) {
        this.articleJPARepositery = articleJPARepositery;
        this.categorieJPARepositery = categorieJPARepositery;
    }

    public Optional<ArticleEntity> findById(Long id) {
        return this.articleJPARepositery.findById(id);
    }

    public Categorie creerCategorie(String nom) {
        Categorie categorieElse = new Categorie();
        categorieElse.setNom(nom);
        categorieElse = this.categorieJPARepositery.save(categorieElse);
        return categorieElse;
    }

    public ArticleEntity creerArticle(HttpSession session, Article article) {
        if(article.getAuteur() == null) {
            logger.error("L'article n'a pas d'auteur");
            return null;
        } else {
            Categorie categorie;
            categorie = categorieJPARepositery.findByNom(article.getNom()).orElse(creerCategorie(article.getNom()));
            ArticleEntity articleEntity = new ArticleEntity();
            articleEntity.setCorps(article.getCorps());
            articleEntity.setTitle(article.getTitre());
            articleEntity.setCategorie(categorie);
            session.setAttribute("article", articleEntity);
            articleJPARepositery.save(articleEntity);
            return articleEntity;
        }
    }


}
