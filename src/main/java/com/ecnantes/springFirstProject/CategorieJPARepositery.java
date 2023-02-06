package com.ecnantes.springFirstProject;

import com.ecnantes.springFirstProject.Model.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategorieJPARepositery extends JpaRepository<Categorie, Long> {
    Optional<Categorie> findByNom(String creerCategorie);
}
