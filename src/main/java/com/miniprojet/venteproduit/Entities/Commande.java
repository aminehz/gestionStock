package com.miniprojet.venteproduit.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Commande {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;

 @Temporal(TemporalType.TIMESTAMP)
 private Date commandeDate;

 @ManyToMany
 @JoinTable(
         name = "commande_produit",
         joinColumns = @JoinColumn(name = "commande_id"),
         inverseJoinColumns = @JoinColumn(name = "produit_id")
 )
 private List<Produit> produits;

 @ManyToOne
 private Client client;



}
