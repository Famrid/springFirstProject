package com.ecnantes.springFirstProject;

import com.ecnantes.springFirstProject.Model.Article;

import org.springframework.jdbc.core.RowMapper;


import java.sql.ResultSet;
import java.sql.SQLException;

public class ArticleMapper implements RowMapper<Article> {
    @Override
    public Article mapRow(ResultSet resultSet, int rows) throws SQLException {
        Article article = new Article();
        article.setTitre(resultSet.getString("titre"));
        article.setCorps(resultSet.getString("corps"));
        return article;
    }
}
