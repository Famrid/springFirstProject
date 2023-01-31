package com.ecnantes.springFirstProject;

import com.ecnantes.springFirstProject.Model.ArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleJPARepositery extends JpaRepository<ArticleEntity, Long> {

}
