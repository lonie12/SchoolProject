package com.fastProject.fastProect.Achats;

import com.fastProject.fastProect.Article.Article;
import com.fastProject.fastProect.Vente.Vente;

import javax.persistence.*;

@Entity
public class Achats {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public  Achats(){

    }

    public Achats(Article article, Vente vente, int quantite) {
        this.article = article;
        this.vente = vente;
        this.quantite = quantite;
    }

    public Long getId() {
        return id;
    }

    public Article getArticle() {
        return article;
    }

    public Vente getVente() {
        return vente;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public void setVente(Vente vente) {
        this.vente = vente;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    @ManyToOne
    @JoinColumn(name = "article_id")
    Article   article;

    @ManyToOne
    @JoinColumn(name = "vente_id")
    Vente  vente;

    private int  quantite ;
}
