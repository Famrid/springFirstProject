package com.ecnantes.springFirstProject;

import com.ecnantes.springFirstProject.Model.ArticleEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Types;

@Repository
public class ArticleRepositery  {
    @Autowired
    private JdbcTemplate jdbcTemplate;


    public ArticleEntity getArticleById(Integer id) {
        return null;
    }


}
