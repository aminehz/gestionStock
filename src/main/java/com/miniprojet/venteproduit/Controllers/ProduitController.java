package com.miniprojet.venteproduit.Controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.miniprojet.venteproduit.Entities.Produit;
import com.miniprojet.venteproduit.Services.IServiceProduit;
import com.miniprojet.venteproduit.Services.ServiceProduit;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
@AllArgsConstructor
@RestController
public class ProduitController {
  IServiceProduit serviceProduit;
  @GetMapping("/products")
    public List<Produit> getAllProducts(){
      List<Produit> liste=serviceProduit.getAllProducts();
      return liste;
  }

    @PostMapping("/addProduct")
    public ResponseEntity<String> addProduct(@RequestPart(value = "produit") Produit produit ,@RequestPart(value = "file" ,required = false ) MultipartFile file) throws IOException {
        serviceProduit.saveProduit(produit, file);
        return ResponseEntity.ok("Product Added Successfully");
    }

    @GetMapping("/product/{id}")
    public Produit getProductById(@PathVariable("id") Long id){
        return serviceProduit.getProductById(id);
    }
    @DeleteMapping("/deleteProduct/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") Long id){
        serviceProduit.deleteProduct(id);
        return ResponseEntity.ok("Product deleted Successuflly");
    }
}
