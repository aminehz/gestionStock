package com.miniprojet.venteproduit.DAO;

import com.miniprojet.venteproduit.Entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProduitRepository extends JpaRepository<Produit,Long> {
    List<Produit> findByNomContains(String nom);

    @Query("SELECT p from Produit p where p.categorie.id=:x")
    public List<Produit> getProduitsByCat(@Param("x") Long idc);

}
