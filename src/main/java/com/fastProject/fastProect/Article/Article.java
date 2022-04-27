package com.fastProject.fastProect.Article;

import com.fastProject.fastProect.Achats.Achats;
import com.fastProject.fastProect.Approvision.Approvision;
import com.fastProject.fastProect.Categories.Categorie;
import com.fastProject.fastProect.Vente.Vente;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Article {



    public Article(){

        }

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;
        private String lib;
        private int prix;
        private int qteSeuil;
        private int qteStock;
        private LocalDate  dateCreation;

        @ManyToOne
        @JoinColumn(name = "categorie_id")
        Categorie categorie;



        @OneToMany(mappedBy = "article")
        List<Achats> achats;

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    @OneToMany(mappedBy = "article")
        List<Approvision> approvisions;




    public Long getId() {
        return id;
    }

    public String getLib() {
        return lib;
    }

    public int getPrix() {
        return prix;
    }

    public int getQteSeuil() {
        return qteSeuil;
    }

    public int getQteStock() {
        return qteStock;
    }

    public LocalDate getDateCreation() {
        return dateCreation;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLib(String lib) {
        this.lib = lib;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public void setQteSeuil(int qteSeuil) {
        this.qteSeuil = qteSeuil;
    }

    public void setQteStock(int qteStock) {
        this.qteStock = qteStock;
    }

    public void setDateCreation(LocalDate dateCreation) {
        this.dateCreation = dateCreation;
    }

    public List<Achats> getAchats() {
        return achats;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", lib='" + lib + '\'' +
                ", prix=" + prix +
                ", qteSeuil=" + qteSeuil +
                ", qteStock=" + qteStock +
                ", dateCreation=" + dateCreation +
                '}';
    }

    public Article( String lib, int prix, int qteSeuil, int qteStock,Categorie categorie){
                this.lib = lib;
                this.prix = prix;
                this.qteSeuil = qteSeuil;
                this.qteStock = qteStock;
                this.dateCreation = LocalDate.now();
                this.categorie= categorie;
            }
}
