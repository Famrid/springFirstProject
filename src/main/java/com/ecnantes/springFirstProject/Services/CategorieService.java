package com.ecnantes.springFirstProject.Services;

import com.ecnantes.springFirstProject.CategorieJPARepositery;
import com.ecnantes.springFirstProject.Model.Categorie;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CategorieService {
    private CategorieJPARepositery categorieJPARepositery;

    public CategorieService(CategorieJPARepositery categorieJPARepositery) {
        this.categorieJPARepositery = categorieJPARepositery;
    }

    public List<Categorie> getCategories() {
        return this.categorieJPARepositery.findAll();
    }

    public Optional<Categorie> getCategorieById(Long id) {
        return this.categorieJPARepositery.findById(id);
    }

    public Categorie creerCategorie(Categorie categorie) {
        categorie = this.categorieJPARepositery.save(categorie);
        return categorie;
    }
}
