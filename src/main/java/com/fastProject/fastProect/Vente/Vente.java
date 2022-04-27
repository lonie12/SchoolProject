package com.fastProject.fastProect.Vente;

import com.fastProject.fastProect.Achats.Achats;
import com.fastProject.fastProect.Article.Article;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Vente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDate DateDeLaVente;

    public Long getId() {
        return id;
    }

    public LocalDate getDateDeLaVente() {
        return DateDeLaVente;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDateDeLaVente(LocalDate dateDeLaVente) {
        DateDeLaVente = dateDeLaVente;
    }

    public void setAchats(List<Achats> achats) {
        this.achats = achats;
    }

    public List<Achats> getAchats() {
        return achats;
    }

    public Vente() {
         this.DateDeLaVente = LocalDate.now() ;
    }

    @OneToMany(mappedBy = "vente")
    List<Achats> achats;
}
