package com.miniprojet.venteproduit.Controllers;

import com.miniprojet.venteproduit.Entities.Produit;
import com.miniprojet.venteproduit.Services.ServiceCategorie;
import com.miniprojet.venteproduit.Services.ServiceProduit;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class ProduitController {
    ServiceProduit serviceProduit;
    ServiceCategorie serviceCategorie;

    public ProduitController(ServiceProduit serviceProduit){
        this.serviceProduit=serviceProduit;
    }
    @GetMapping("/allProduits")
    public ResponseEntity<List<Produit>> getAllProduits(){
        List<Produit> produits=serviceProduit.getAllProduits();
        return ResponseEntity.ok(produits);
    }

    @PostMapping("/addProduit")
    public ResponseEntity<Produit> createProduit(@RequestBody Produit P){
        Produit createdProduit=serviceProduit.saveProduit(P);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProduit);

    }

    @GetMapping("/getProduit/{id}")
    public ResponseEntity<Produit> getProduitById(@PathVariable("id") Long id){
        Produit produit=serviceProduit.getProduit(id);
        if(produit !=null){
            return ResponseEntity.ok(produit);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/updateProduit/{id}")
    public ResponseEntity<Produit> updateProduit(
            @PathVariable("id") Long id,
            @RequestBody Produit updatedProduit){
        serviceProduit.updateProduit(id,updatedProduit);
        Produit existingProduit=serviceProduit.getProduit(id);
        if(existingProduit !=null){
            return ResponseEntity.ok(existingProduit);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/deleteProduit/{id}")
    public ResponseEntity<ResponseEntity> deleteProduit(@PathVariable("id") Long id){
        Produit existingProduit=serviceProduit.getProduit(id);
        if(existingProduit !=null){
            serviceProduit.deleteProduit(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();

    }

}
