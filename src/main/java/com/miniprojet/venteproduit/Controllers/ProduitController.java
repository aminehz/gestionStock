package com.miniprojet.venteproduit.Controllers;

import com.miniprojet.venteproduit.Entities.Produit;
import com.miniprojet.venteproduit.Services.ServiceCategorie;
import com.miniprojet.venteproduit.Services.ServiceProduit;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/produits")
public class ProduitController {
    ServiceProduit serviceProduit;
    ServiceCategorie serviceCategorie;

    public ProduitController(ServiceProduit serviceProduit){
        this.serviceProduit=serviceProduit;
    }
    @GetMapping
    public ResponseEntity<List<Produit>> getAllProduits(){
        List<Produit> produits=serviceProduit.getAllProduits();
        return ResponseEntity.ok(produits);
    }

}
