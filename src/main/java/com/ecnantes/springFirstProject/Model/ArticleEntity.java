package com.ecnantes.springFirstProject.Model;

import javax.persistence.*;

@Entity
@Table(name = "article")
public class ArticleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // avec un type serial en postgres
    private Long id;

    @Column(name = "titre")
    private String titre;

    @Column(name = "corps")
    private String corps;

    @ManyToOne
    @JoinColumn(name="categorie_id", referencedColumnName = "id")
    private Categorie categorie;

    public String getTitle() {
        return titre;
    }

    public void setTitle(String titre) {
        this.titre = titre;
    }

    public String getCorps() {
        return corps;
    }

    public void setCorps(String corps) {
        this.corps = corps;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }
}
