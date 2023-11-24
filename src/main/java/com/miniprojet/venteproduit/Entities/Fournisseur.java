package com.miniprojet.venteproduit.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Fournisseur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String nomSociete;

    @NotEmpty
    private String email;

    @NotEmpty
    private String password;

    @OneToMany(mappedBy = "fournisseur",cascade =CascadeType.ALL)
    private List<Produit> produits;

    @OneToMany(mappedBy = "fournisseur")
    private List<Client> clients;
}
