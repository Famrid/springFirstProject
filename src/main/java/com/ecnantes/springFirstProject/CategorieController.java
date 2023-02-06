package com.ecnantes.springFirstProject;


import com.ecnantes.springFirstProject.Model.Categorie;
import com.ecnantes.springFirstProject.Services.CategorieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorie")
public class CategorieController {
    private CategorieService categorieService;

    public CategorieController(CategorieService categorieService) {
        this.categorieService = categorieService;
    }

    @GetMapping
    public List<Categorie> getCategories() {
        return this.categorieService.getCategories();
    }

    @GetMapping("/{id}")
    public  Categorie getCategoryById(@PathVariable("id") Long id) {
        if(this.categorieService.getCategorieById(id).isPresent()){
            return this.categorieService.getCategorieById(id).get();
        }
        return null;
    }

    @PostMapping
    public Categorie creerCategorie(@RequestBody Categorie categorie) {
        return this.categorieService.creerCategorie(categorie);
    }
}
