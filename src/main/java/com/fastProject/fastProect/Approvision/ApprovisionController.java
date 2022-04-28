package com.fastProject.fastProect.Approvision;

import com.fastProject.fastProect.Approvision.Approvision;
import com.fastProject.fastProect.Approvision.ApprovisionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.fastProject.fastProect.Article.ArticleService;
import com.fastProject.fastProect.Article.Article;

import java.util.List;

@Controller
public class ApprovisionController {
    private  final ApprovisionService approvisionService;
    private  final  ArticleService articleService;

    public ApprovisionController(ApprovisionService approvisionService, ArticleService articleService) {
        this.approvisionService = approvisionService;
        this.articleService = articleService;
    }

    @GetMapping("/addApprovision")
    public String addApprovision(Model model){
        model.addAttribute("approvision",new Approvision());
        List<Article> articles =   articleService.giveAll();
        model.addAttribute("articles",articles);
        return "Approvision/enr_approvision";
    }

    @PostMapping("/addApprovision")
    public  String  PostaddApprovision(Model model,@ModelAttribute("approvision") Approvision approvision){
        approvisionService.addApprovison(approvision);
        return  "redirect:/GiveApprovisions";
    }

    @GetMapping("/GiveApprovisions")
    public String GiveApprovision(Model model){
         List<Approvision>  approvisions = approvisionService.getAllApprovision();
         model.addAttribute("approvisions",approvisions);
        //  for (int i = 0; i < approvisions.size(); i++) {
        //         System.out.println(approvisions.get(i).getDateApprovision());
        //  }

         return "Approvision/list_approvision";
    };
}
