package com.miniprojet.venteproduit.Services;

import com.miniprojet.venteproduit.Entities.Produit;

import java.util.List;

public interface IServiceProduits {
    public void saveProduit(Produit P) ;

    public List<Produit> getAllProduits();

    public List<Produit> getProduitsByNom(String nomP);
    public List<Produit> getProduitsByCat(Long idCat);

    public void deleteProduit(Long id);
    public Produit getProduit(Long id);
    public void updateProduit(Long id,Produit updatedProduit);
}
