package com.miniprojet.venteproduit.Repository;

import com.miniprojet.venteproduit.Entities.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeRepository extends JpaRepository<Commande,Long> {

}
