package com.fastProject.fastProect.Vente;

import com.fastProject.fastProect.Article.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface VenteRepositry extends JpaRepository<Vente,Long> {
    @Query("SELECT v FROM Vente v WHERE v.DateDeLaVente BETWEEN :dateDebut AND :dateFin ")
    Optional<List<Vente>>  findVenteBetween(@Param("dateDebut") LocalDate dateDebut,@Param("dateFin") LocalDate dateFin);
}



