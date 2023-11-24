package com.miniprojet.venteproduit.Controllers;

import com.miniprojet.venteproduit.Entities.Categorie;
import com.miniprojet.venteproduit.Services.ServiceCategorie;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class CategorieController {
    ServiceCategorie serviceCategorie;

    public CategorieController(ServiceCategorie serviceCategorie){
        this.serviceCategorie=serviceCategorie;
    }
    @GetMapping("/getCategories")
    public ResponseEntity<List<Categorie>> getAllCategories(){
        List<Categorie> categories=serviceCategorie.getAllCategories();
        return ResponseEntity.ok(categories);
    }
    @PostMapping("/addCategorie")
    public ResponseEntity<Categorie> createCategorie(@RequestBody Categorie C){
        Categorie createdCategorie=serviceCategorie.saveCategorie(C);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCategorie);
    }
    @DeleteMapping("/deleteCategorie/{id}")
    public ResponseEntity<Categorie> deleteCategorie(@PathVariable Long id){
        serviceCategorie.deleteCategorie(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/getCategorie/{id}")
    public ResponseEntity<List<Categorie>> getCategorieById(@PathVariable("id") Long id){
        List<Categorie> categorie = serviceCategorie.getCategoriesById(id);
        if(categorie.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(categorie,HttpStatus.OK);
    }

    @PutMapping("/updateCategorie/{id}")
    public ResponseEntity<Categorie> updateCategorie(
            @PathVariable("id") Long id,
            @RequestBody Categorie updatedCategorie
    ) {
        Categorie updated = serviceCategorie.updateCategorie(id, updatedCategorie);
        if (updated == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

}
