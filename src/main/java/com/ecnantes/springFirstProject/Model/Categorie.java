package com.ecnantes.springFirstProject.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categorie")
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nom")
    private String nom;

    @OneToMany(targetEntity = ArticleEntity.class, mappedBy = "categorie")
    private List<ArticleEntity> articleList = new ArrayList<ArticleEntity>();
}
