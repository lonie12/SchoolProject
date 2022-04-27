package com.fastProject.fastProect.Categories;

import com.fastProject.fastProect.Article.Article;

import javax.persistence.*;
import java.util.List;

@Entity
public class Categorie {

    public  Categorie(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String libelle;

    @OneToMany(mappedBy = "categorie")
    List<Article> articles;

    public Categorie(String libelle) {
        this.libelle = libelle;
    }

    public String getLibelle() {
        return libelle;
    }

    public Long getId() {
        return id;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
