package com.fastProject.fastProect.Approvision;

import com.fastProject.fastProect.Article.Article;
import com.fastProject.fastProect.Article.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApprovisionService {
    private final AppprovisionRepository appprovisionRepository;
    private final ArticleRepository articleRepository;

    @Autowired
    public ApprovisionService(AppprovisionRepository appprovisionRepository, ArticleRepository articleRepository) {
        this.appprovisionRepository = appprovisionRepository;
        this.articleRepository = articleRepository;
    }

    public void addApprovison(Approvision approvision){
        Article article =approvision.getArticle();
        article.setQteStock(article.getQteStock()+approvision.getQuante());
        appprovisionRepository.save(approvision);
        articleRepository.save(article);
    }

    public List<Approvision> getAllApprovision(){
        return  appprovisionRepository.findAll();
    }

    public void delete(Long id){
        appprovisionRepository.deleteById(id);
    }




}
