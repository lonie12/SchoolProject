package com.fastProject.fastProect.Approvision;

import com.fastProject.fastProect.Article.Article;
import com.fastProject.fastProect.Categories.Categorie;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
@Entity
public class Approvision {
    public  Approvision(){

    }

    public Approvision(int quante, Article article) {
        this.quante = quante;
        this.article = article;
        this.DateApprovision = LocalDate.now();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public void setQuante(int quantie) {
        this.quante = quantie;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public Long getId() {
        return id;
    }

    public int getQuante() {
        return quante;
    }

    public Article getArticle() {
        return article;
    }

    private  int quante;

    private LocalDate DateApprovision;

    @ManyToOne
    @JoinColumn(name = "Article_id")
    Article article;

}
