package com.miniprojet.venteproduit.DAO;

import com.miniprojet.venteproduit.Entities.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategorieRepository extends JpaRepository<Categorie,Long> {

    @Query("select c from Categorie c where c.id=:x")
    public List<Categorie> getCategorieById(@Param("x") Long idc);
}
