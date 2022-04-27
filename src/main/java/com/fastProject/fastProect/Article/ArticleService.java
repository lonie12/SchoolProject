package com.fastProject.fastProect.Article;

import com.fastProject.fastProect.Categories.Categorie;
import com.fastProject.fastProect.Categories.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {

    private final  ArticleRepository articleRepository;
    private final CategorieRepository categorieRepository;

    @Autowired
    public ArticleService(ArticleRepository articleRepository, CategorieRepository categorieRepository) {
        this.articleRepository = articleRepository;
        this.categorieRepository = categorieRepository;
    }




    public boolean addArticle(Article article){
                    article.setDateCreation(LocalDate.now());
                    article.setQteStock(0);
                  articleRepository.save(article);
                  return true;
    }

    public List<Article> giveAll(){
         return articleRepository.findAll();
    }

    public void deleteArticle(Long id){
         articleRepository.deleteById(id);
    }

    public Optional<Article>  search(String mot){
       return articleRepository.findArticleByLib(mot);
    }

    public int  articleNombre(){
        return articleRepository.findAll().size();
    }

    public  Optional<List<Article>> findArticleSousSeuil(){
        Optional<List<Article>> article = articleRepository.findArticle();
        // System.out.println(article.get());
        return  article;
    }

    public Optional<List<Article>> getAllArticleEnStock(){
        Optional<List<Article>>  OptinaListArticle = articleRepository.findArticleEnStock();
        return  OptinaListArticle;
    }






}
