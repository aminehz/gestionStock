package com.miniprojet.venteproduit.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Size(min = 1,max = 20)
    private String nom;

    private String description;

    @NotNull(message = "le prix ne doit pas etre null")
    @DecimalMin(value = "0.0",inclusive = false,message = "le prix doit etre superieur à 0.0")
    private double prix;

    //private String image;



    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "stock_id",referencedColumnName = "id")
    private Stock stock;

    @ManyToOne
    @NotNull(message = "veuillez choisir la categorie")
    private Categorie categorie;

    @ManyToOne
    @JoinColumn(name = "fournissuer_id")
    private Fournisseur fournisseur;


}
