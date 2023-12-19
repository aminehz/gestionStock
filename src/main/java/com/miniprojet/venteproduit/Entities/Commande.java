package com.miniprojet.venteproduit.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "COMMANDE")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCommande;

    @ManyToMany
    @JoinTable(name = "Commande_Produit",
    joinColumns = @JoinColumn(name = "idCommande"),
            inverseJoinColumns = @JoinColumn(name = "idProduit")
    )
    private List<Produit> produitsCommandes;

    @OneToOne(mappedBy = "commandeAssocie")
    private Facture facture;
}
