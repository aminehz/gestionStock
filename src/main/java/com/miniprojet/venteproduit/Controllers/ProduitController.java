package com.miniprojet.venteproduit.Controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.miniprojet.venteproduit.Entities.Produit;
import com.miniprojet.venteproduit.Services.IServiceProduit;
import com.miniprojet.venteproduit.Services.ServiceProduit;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
@AllArgsConstructor
@RestController
public class ProduitController {
  IServiceProduit serviceProduit;
  @GetMapping("/produits")
    public List<Produit> getAllProducts(){
      List<Produit> liste=serviceProduit.getAllProducts();
      return liste;
  }

    @PostMapping("/addProduit")
    public void addProduct(@RequestPart(value = "produit") Produit produit ,@RequestPart(value = "file" ,required = false ) MultipartFile file) throws IOException {
        serviceProduit.saveProduit(produit, file);
    }


}
