package com.miniprojet.venteproduit.Services;

import com.miniprojet.venteproduit.DAO.ProduitRepository;
import com.miniprojet.venteproduit.Entities.Produit;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ServiceProduit implements IServiceProduits {
    ProduitRepository produitRepository;
    @Override
    public Produit saveProduit(Produit p) {
        produitRepository.save(p);
        return p;
    }

    @Override
    public List<Produit> getAllProduits() {
        return produitRepository.findAll();
    }

    @Override
    public List<Produit> getProduitsByNom(String nomP) {
        return produitRepository.findByNomContains(nomP);
    }

    @Override
    public List<Produit> getProduitsByCat(Long idCat) {
        return produitRepository.getProduitsByCat(idCat);
    }

    @Override
    public void deleteProduit(Long id) {
        produitRepository.deleteById(id);
    }

    @Override
    public Produit getProduit(Long id) {
        return produitRepository.findById(id).orElse(null);
    }

    @Override
    public void updateProduit(Long id, Produit updatedProduit) {
        Optional<Produit> existingProduitOptional=produitRepository.findById(id);
        if(existingProduitOptional.isPresent()){
            Produit existingProduit=existingProduitOptional.get();
            existingProduit.setNom(updatedProduit.getNom());
            existingProduit.setDescription(updatedProduit.getDescription());
            existingProduit.setPrix(updatedProduit.getPrix());
            existingProduit.setCategorie(updatedProduit.getCategorie());
            produitRepository.save(existingProduit);
        }

    }
}
