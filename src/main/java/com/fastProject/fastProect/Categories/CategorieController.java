package com.fastProject.fastProect.Categories;

import com.fastProject.fastProect.Article.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CategorieController {
    private  final  CategorieService categorieService;


    public CategorieController(CategorieService categorieService) {
        this.categorieService = categorieService;
    }

    @GetMapping("/GiveCategories")
    public String getCategories(Model model){

      List<Categorie> categories = categorieService.getAll();
      model.addAttribute("recherche", new recherch());
      model.addAttribute("categories",categories);


      return  "Categorie/list_categorie";
    }

    @GetMapping("/addCategorie")
    public  String voirCategories(Model model){
        model.addAttribute("recherche", new recherch());
        model.addAttribute("categorie",new  Categorie());
        return  "Categorie/enr_categorie";
    };

    @PostMapping("/addCategorie")
    public  String setCategories(@ModelAttribute("categorie") Categorie categorie,Model model){
        model.addAttribute("recherche", new recherch());
        categorieService.addCategorie(categorie);
        return  "redirect:/GiveCategories";
    };

    @GetMapping("/deleteCategorie")
    public String deleteCategorie(@RequestParam() Long id){
        categorieService.deleteCategorie(id);
        return  "redirect:/GiveCategories";
    };



}
