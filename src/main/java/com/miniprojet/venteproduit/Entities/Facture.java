package com.miniprojet.venteproduit.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "FACTURE")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Facture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFacture;

    @Min(0)
    private Float montant;

    @Column(columnDefinition = "boolean default false")
    private Boolean statutPaiement;


    @Column
    private LocalDateTime dateTime=LocalDateTime.now();

    @OneToOne
    @JoinTable(
            name = "Facture_Commande",
            joinColumns = @JoinColumn(name = "idFacture"),
            inverseJoinColumns = @JoinColumn(name = "idCommande")
    )
    private Commande commandeAssocie;

}
