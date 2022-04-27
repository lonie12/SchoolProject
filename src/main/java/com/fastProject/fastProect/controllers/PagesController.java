package com.fastProject.fastProect.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class PagesController {

    @GetMapping("/pagesController")
    public  String home(@RequestParam(required = false,defaultValue = "cool") String cool, /*HttpServletRequest request,*/ ModelMap modelMap){
        //String cool = request.getParameter("cool");
        modelMap.put("cool",cool);
        return  "pages/home";
    }
}
