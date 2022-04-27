package com.fastProject.fastProect.Achats;

import com.fastProject.fastProect.Article.Article;
import com.fastProject.fastProect.Vente.Vente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AchatSercice {

    private  final AchatRepository achatRepository;

    @Autowired
    public AchatSercice(AchatRepository achatRepository) {
        this.achatRepository = achatRepository;
    }

    // vendre un article disponible en stock
    public void AddAchat(Vente vente, Article article, int quantite){
        Achats achat = new Achats(article,vente,quantite);
        achatRepository.save(achat);
    }

}
