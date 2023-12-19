package com.miniprojet.venteproduit.Entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "PRODUIT")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduit;

    @NotEmpty
    @Size(min=1,max=20)
    private String nom;

    private String description;

    @Min(0)
    private int quantiteStock;

    @Min(0)
    private Float prixUnitaire;

    private String photo;

    @ManyToMany(mappedBy = "produitsCommandes")
    private List<Commande> commandes;




}
