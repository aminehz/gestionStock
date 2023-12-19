package com.miniprojet.venteproduit.Repository;

import com.miniprojet.venteproduit.Entities.Facture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FactureRepositroy extends JpaRepository<Facture,Long> {
}
