package com.fastProject.fastProect.Achats;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AchatRepository  extends JpaRepository<Achats,Long> {
    //pour recuperer les achats
    @Query("SELECT a  FROM Achats a where vente_id = :id")
    Optional<List<Achats>> findAchatsByVente(@Param("id") Long id);
}
