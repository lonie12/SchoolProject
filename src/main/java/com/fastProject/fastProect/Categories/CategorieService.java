package com.fastProject.fastProect.Categories;

import com.fastProject.fastProect.Article.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorieService {
    private final ArticleRepository articleRepository;
    private final CategorieRepository categorieRepository;

    @Autowired
    public CategorieService(ArticleRepository articleRepository, CategorieRepository categorieRepository) {
        this.articleRepository = articleRepository;
        this.categorieRepository = categorieRepository;
    }

    public  void  addCategorie(Categorie categorie){
        categorieRepository.save(categorie);
    }

    public  void deleteCategorie(Long id){
        categorieRepository.deleteById(id);
    }

    public List<Categorie> getAll(){
        List<Categorie> listeDeCategorie =  categorieRepository.findAll();
        return  listeDeCategorie;
    }
}
