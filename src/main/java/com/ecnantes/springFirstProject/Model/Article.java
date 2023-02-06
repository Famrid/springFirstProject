package com.ecnantes.springFirstProject.Model;

import javax.persistence.Transient;
import java.time.LocalDateTime;

public class Article {
    private String auteur;
    private Statut statut;
    private LocalDateTime date;
    private String titre;
    private String corps;
    private Long categorie_id;

    private String nom;

    public Article() {
        this.date = LocalDateTime.now();
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public Statut getStatut() {
        return statut;
    }

    public void setStatut(Statut statut) {
        this.statut = statut;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getCorps() {
        return corps;
    }

    public void setCorps(String corps) {
        this.corps = corps;
    }

    public Long getCategorie_id() {
        return categorie_id;
    }

    public void setCategorie_id(Long category_id) {
        this.categorie_id = category_id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
