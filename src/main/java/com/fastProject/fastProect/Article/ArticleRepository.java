package com.fastProject.fastProect.Article;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
@Repository
public interface ArticleRepository extends JpaRepository<Article,Long> {

    Optional<Article> findArticleByLib(String libel);

    //trouver les produit sous le sueil
    @Query("SELECT a From Article  a where  a.qteSeuil < a.qteStock")
    Optional<List<Article>> findArticle();

    // trouver les produit en stock
    @Query("SELECT a FROM Article a where a.qteStock > 0")
    Optional<List<Article>> findArticleEnStock();

    //trouver les articles qui on ete vendu
    @Query("SELECT a FROM Article a INNER JOIN Achats c on a.id=article_id  GROUP BY a.lib ")
    Optional<List<Article>> findArticleVendu();



}
