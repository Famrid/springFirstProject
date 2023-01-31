package com.ecnantes.springFirstProject;

import com.ecnantes.springFirstProject.Model.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieJPARepositery extends JpaRepository<Categorie, Long> {
}
