package com.miniprojet.venteproduit.Repository;

import com.miniprojet.venteproduit.Entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepository extends JpaRepository<Produit,Long> {
}
