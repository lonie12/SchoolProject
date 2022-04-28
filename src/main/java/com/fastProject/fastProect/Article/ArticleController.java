package com.fastProject.fastProect.Article;

import com.fastProject.fastProect.Categories.Categorie;
import com.fastProject.fastProect.Categories.CategorieService;
import com.fastProject.fastProect.Categories.recherch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class ArticleController {

    private  final  ArticleService articleService;
    private final CategorieService categorieService;

    @Autowired
    public ArticleController(ArticleService articleService, CategorieService categorieService) {
        this.articleService = articleService;
        this.categorieService = categorieService;
    }




    @GetMapping("/")
    public  String home(Model model){
        List<Categorie> categorieList = categorieService.getAll();
        model.addAttribute("categories",categorieList);
        model.addAttribute("article",new Article());
        return  "Article/enr_article";
    }

    @PostMapping("/addArticle")
    public  String addArticle(@ModelAttribute("article") Article article){
        articleService.addArticle(article);
        return  "redirect:/GiveArticles";
    }

    @GetMapping("/GiveArticles")
    public  String GiveArticles(Model model){

        List<Article> articles = articleService.giveAll();
        int nombreArticle = articleService.articleNombre();
        model.addAttribute("recherche", new recherch());
        model.addAttribute("articles",articles);
        model.addAttribute("nbrArticle",nombreArticle);
        return  "Article/list_article";
    }

    @GetMapping("/deleteArticle")
    public  String DeleteArticles(@RequestParam(required = true) Long id ){
        articleService.deleteArticle(id);
        return  "pages/home";
    }

    @GetMapping("/serachArticles")
    public  String serachArticles(@ModelAttribute("recherche") recherch recherch,Model model){

        Optional<Article> articleOptional = articleService.search(recherch.getRecherch());


        Article articles = new Article();
        if (articleOptional.isPresent()){
             articles = articleOptional.get();
        }
        model.addAttribute("articles",articles);
        return  "Article/list_article";
    }

    @GetMapping("/GetArticleSousSeuil")
    public  String Article(Model model){
        Optional<List<Article>> articleSousSeuil = articleService.findArticleSousSeuil();
        List<Article> articles = List.of();
        if (articleSousSeuil.isPresent()){
            articles = articleSousSeuil.get();
        }
        model.addAttribute("recherche", new recherch());
        model.addAttribute("articles",articles);
        return "Article/list_article";
    }











}
