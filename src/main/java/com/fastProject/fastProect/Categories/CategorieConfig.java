package com.fastProject.fastProect.Categories;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CategorieConfig {
    @Bean
     CommandLineRunner commandLineRunner(CategorieRepository categorieRepository){
        return args -> {
            Categorie categorie = new Categorie("school");
            Categorie categorie2 = new Categorie("electronique");
            categorieRepository.saveAll(List.of(categorie,categorie2));

        };






    }
}
