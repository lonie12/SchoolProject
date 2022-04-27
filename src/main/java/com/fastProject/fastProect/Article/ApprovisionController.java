package com.fastProject.fastProect.Article;

import com.fastProject.fastProect.Approvision.Approvision;
import com.fastProject.fastProect.Approvision.ApprovisionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ApprovisionController {
    private  final ApprovisionService approvisionService;

    public ApprovisionController(ApprovisionService approvisionService) {
        this.approvisionService = approvisionService;
    }

    @GetMapping("/addApprovision")
    public String addApprovision(Model model){
        model.addAttribute("approvision",new Approvision());
        return "Approvision/enr_approvision";
    }

    @PostMapping("/addApprovision")
    public  String  PostaddApprovision(Model model,@ModelAttribute("approvision") Approvision approvision){
        approvisionService.addApprovison(approvision);
        return  "redirect:/GiveApprovision";
    }

    @GetMapping("/GiveAppprovision")
    public String GiveApprovision(){
        return "";
    };
}
